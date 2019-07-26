package org.spark.learn


import org.apache.spark.sql.SparkSession

object TestSpark {

  def main(args: Array[String]): Unit = {
    val spark=SparkSession.builder().master("local[*]").appName("Sample Spark App").enableHiveSupport().getOrCreate()
    val filePath=getClass.getResource("/MOCK_DATA.csv").toString
    val sourceDF=spark.read.option("header","true").csv(filePath)
    sourceDF.show(false)
    spark.stop()
  }
}
