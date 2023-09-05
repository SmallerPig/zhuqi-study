package spark.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author zhuqi at 2021/7/27
 */
object WordCountDemo1 {


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

    // 3.相同的单词进行分组,便于统计
    // (hello, hello, hello),(world, world)
    val wordGroup:RDD[(String, Iterable[String])] = words.groupBy(word => word)

    //4.对分组后的数据进行转换
    // (hello, 3),(world,4)
    val wordToCount = wordGroup.map {
      case (word, list) => {
        (word, list.size)
      }
    }

    //5.将结果采集到控制台打印
    val array: Array[(String, Int)] = wordToCount.collect()
    array.foreach(println)

    // 关闭连接
    sc.stop()
  }

}
