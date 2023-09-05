package spark.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author zhuqi at 2021/7/27
 */
object WordCountDemo3 {


  def main(args: Array[String]): Unit = {
    // 建立和spark 的连接
    var sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")

    val sc = new SparkContext(sparkConf)

    // 业务
    // 1.读取文件 获取某行为单位的数据
    // hello world
    val lines: RDD[String] = sc.textFile(path = "data")

    // 2.将行数据进行拆分, 分词效果
    // hello, hello , word, word,
    val words:RDD[String] = lines.flatMap(_.split(" "))


    val wordToOne = words.map(
      word => (word, 1)
    )

    val wordToCount = wordToOne.reduceByKey(_ + _)
//    wordToOne.reduceByKey((x,y)=> {x+y})

    val array: Array[(String, Int)] = wordToCount.collect()
    array.foreach(println)

    // 关闭连接
    sc.stop()
  }

}
