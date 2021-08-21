package com.zhuqi.study.spark.wc

/**
 * @author zhuqi at 2021/7/27
 */
object WordCountDemo1 {


  def main(args: Array[String]): Unit = {
    var sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(sparkConf)




    sc.stop()
  }

}
