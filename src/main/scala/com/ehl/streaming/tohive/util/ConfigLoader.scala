package com.ehl.streaming.tohive.util


import java.io.File
import java.io.InputStream
import scala.collection.JavaConversions._
import scala.collection.mutable.HashMap
import scala.io.Source
import org.slf4j.LoggerFactory
import java.io.FileInputStream
import java.util.Properties
import java.util.{Map => JavaMap}
import java.io.Reader
import java.io.InputStreamReader

object ConfigLoader {
   val logger = LoggerFactory.getLogger("ConfigLoader")
  val props   = new  Properties()
  
   //相对路径加载属性文件，UTF-8方式读取
  val load ={
    var input:InputStream =null;
    input = new FileInputStream(ConfigerUtil.getResource("conf.properties"))
    //input = ConfigLoader.getClass.getClassLoader.getResourceAsStream("conf.properties")
    props.load(new InputStreamReader(input,"UTF-8"));
    input.close()
  }

  //加载至HashMap，只供内部用
  private[this] def setAsProps[U](arr: Array[String]): Unit = {
    arr.length match {
      case 2 => set(arr(0).trim(),arr(1).trim())
      case _ => None
    }
  }

  //加载，只供内部用
  private[this] def set(key: String, value: String): Unit = {
    if (key == null) {
      throw new NullPointerException("null key")
    }
    if (value == null) {
      throw new NullPointerException("null value for " + key)
    }
    props.put(key, value)
  }
  
  def getPropertyValueString(key:String):String={
    println(props(key))
    props(key)
  }
  
  def getPropertyMap():JavaMap[Object,Object]={
    return props
  }
}