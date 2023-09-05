package spark.framework.common

import org.apache.spark.{SparkConf, SparkContext}
import spark.framework.util.EnvUtil

trait TApplication {

    def start(master:String ="local[*]", app:String = "Application")( op : => Unit ): Unit = {
        val sparConf = new SparkConf().setMaster(master).setAppName(app)
        val sc = new SparkContext(sparConf)
        EnvUtil.put(sc)

        try {
            op
        } catch {
            case ex => println(ex.getMessage)
        }

        // TODO 关闭连接
        sc.stop()
        EnvUtil.clear()
    }
}
