package com.ehl.streaming.tohive

import org.apache.spark.streaming.StreamingContext
import org.apache.spark._
import org.apache.spark.streaming.Milliseconds
import org.apache.spark.streaming.Seconds
import com.ehl.streaming.tohive.util.ConfigLoader

/**
 * @author ehl
 */
trait SparkStreamOp {
  /**
   * stream context;
   * args
   * 0--second
   */
  def operateStreamSpark(args: Array[String])(op: (StreamingContext, Array[String]) => Unit) {
    //first
     val conf  = new SparkConf();
    if (args.length < 1) {
      println("Task takes one params,please set taskName ")
       conf.setAppName("test").setMaster("local[*]")
    }else{
        conf.setAppName(args(0))
    }
   
    val sc = new SparkContext(conf)

    val streamC = new StreamingContext(sc, Milliseconds(ConfigLoader.getPropertyValueString("process_cycle").toLong))
    try {
      op(streamC, args)
      streamC.start()
      streamC.awaitTermination()
    } catch {
      case ex: Exception => ex.printStackTrace()
    } finally {
      //end
      //sc.stop()
    }
  }

}