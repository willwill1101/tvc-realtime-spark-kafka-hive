package com.ehl.streaming.tohive

import java.text.SimpleDateFormat

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka.EhlKafkaUtils
import org.slf4j.LoggerFactory

import com.ehl.streaming.tohive.bean.PassCar
import com.ehl.streaming.tohive.bean.UUIDGenerator
import com.google.gson.Gson

import kafka.serializer.StringDecoder
import com.ehl.streaming.tohive.util.ConfigLoader
import org.apache.spark.sql.hive.HiveContext
import javax.sql.DataSource
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.SparkContext
import com.ehl.streaming.tohive.bean.PassCar
import com.ehl.streaming.tohive.bean.CarPlaBean
import java.lang.Long


object RealtimeKafkaService extends SparkStreamOp with Serializable with App {
  val groupName = ConfigLoader.getPropertyValueString("use_kafka_group")
  val logger = LoggerFactory.getLogger("RealtimeKafkaService")
  try {
    //程序入口 
    operateStreamSpark(args)(executeTask)
  } catch {
    case ex: Exception => logger.error("启动异常:", ex)
  }
  def executeTask(streamsc: StreamingContext, args: Array[String]): Unit = {

    logger.info("==================启动服务=============")
    //不同组使用不用的checkpoint will
    streamsc.checkpoint("checkpoint-" + groupName)
    val consumer = createKafkaConsumer(streamsc, groupName)
    startCounterService(consumer)
    startRealtimeService(consumer._1, groupName,streamsc.sparkContext)
  }

  /**
   * 启动kafka consumer offset计数服务
   * @param stream
   */
  def startCounterService(consumer: (InputDStream[(String, String)], EhlKafkaUtils)) = {
    println("开始启动counter服务")
    consumer._1.foreachRDD(rdd => {
      if (rdd.count() > 0) consumer._2.update[String, String](rdd)
    })
    println("counter服务已启动")
  }

  def createKafkaConsumer(sc: StreamingContext, groupName: String): (InputDStream[(String, String)], EhlKafkaUtils) = {
   
    val topicsSet = Set(ConfigLoader.getPropertyValueString("trTopic")); //.toSet
    val kafkaParams = Map[String, String]("metadata.broker.list" -> ConfigLoader.getPropertyValueString("kafkaBroker"), "group.id" -> groupName)
    val kafka = EhlKafkaUtils(kafkaParams)
    val stream = kafka.createKafkaDirectStream[String, String, StringDecoder, StringDecoder](sc, kafkaParams, topicsSet, true);
    return (stream, kafka)
  }

  /**
   * 启动实时流计算服务，包括normal和field两类
   * @param stream
   */
  def startRealtimeService(stream: InputDStream[(String, String)], groupName: String, sc:SparkContext) = {
    Thread.sleep(5000L)
     val hiveContext = new HiveContext(sc)
    
     import hiveContext.implicits._
    stream.foreachRDD(rdd => {
     val data = rdd.map(f =>{
         PassCar.coverToBean(f._2)
      }).map { f => {
        CarPlaBean.coverToCarPlaBean(f)
      } }.filter { f => f!=null }.map(f => Carcase(f.getUid,f.getVersion,f.getPasstime,f.getCarstate,f.getCarplate,f.getPlatetype,
                           f.getSpeed,f.getPlatecolor,f.getLocationid,f.getDeviceid,f.getDriveway,f.getDrivedir,
                           f.getCapturedir,f.getCarcolor,f.getCarbrand,f.getCarbrandzw,f.getTgsid,f.getPlatecoord,
                           f.getCabcoord,f.getImgid1,f.getDt,f.getPasstime_yyyymm)
              ).toDF().registerTempTable("passcartable1")
                hiveContext.sql("set hive.exec.dynamic.partition=true");
      hiveContext.sql("set hive.exec.dynamic.partition.mode=nonstrict");
      var orc_table= ConfigLoader.getPropertyValueString("orc_table")
     hiveContext.sql(" insert into table "+orc_table+" partition ( passtime_yyyymm) select uid,version,passtime,carstate,carplate,platetype,speed,platecolor,locationid,deviceid,driveway,drivedir,capturedir,carcolor,carbrand,carbrandzw,tgsid,platecoord,cabcoord,imgid1,'' as imgid2,'' as imgid3,'' as imgid4,'' as imgid5,dt, passtime_yyyymm from passcartable1")
    });
  }
  
  case class Carcase(uid:String ,
	version:String,
	passtime:Long,// 通行时间
	carstate:String,// 车辆状态
	carplate:String,// 车牌号
	platetype:String,// 号牌种类
	speed:Integer,// 号牌种类
	platecolor:String,// 车牌颜色
	locationid:String,// 地点编号
	deviceid:String,
	driveway:Integer,// 车道编码
	drivedir:String,// 行驶方向
	capturedir:String,// 抓拍方向
	carcolor:String,// 车身颜色
	carbrand:String,// 车辆品牌
	carbrandzw:String,//中文车辆品牌
	tgsid:String,// 卡口编号
	platecoord:String,// 车牌坐标
	cabcoord:String,// 驾驶室坐标 	
	imgid1:String,// 图片文件名1
	dt:String,
	passtime_yyyymm:Integer)

}

