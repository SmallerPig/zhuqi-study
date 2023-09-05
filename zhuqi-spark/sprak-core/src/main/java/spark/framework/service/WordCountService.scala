package spark.framework.service

import org.apache.spark.rdd.RDD
import spark.framework.common.TService
import spark.framework.dao.WordCountDao

/**
  * 服务层
  */
class WordCountService extends TService {

    private val wordCountDao = new WordCountDao()

    // 数据分析
    def dataAnalysis() = {

        val lines = wordCountDao.readFile("data")
        val words: RDD[String] = lines.flatMap(_.split(" "))
        val wordToOne = words.map(word=>(word,1))
        val wordToSum: RDD[(String, Int)] = wordToOne.reduceByKey(_+_)
        val array: Array[(String, Int)] = wordToSum.collect()
        array
    }
}
