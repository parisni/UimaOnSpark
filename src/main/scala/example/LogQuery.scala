/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println
package org.apache.spark.examples

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.uima.dkpro.spark.PojoTest
/**
 * Executes a roll up-style query against Apache logs.
 *
 * Usage: LogQuery [logFile]
 */
object LogQuery {

	  @transient 
	  val tt = new org.apache.uima.dkpro.spark.PojoTest("/tmp/")

  def main(args: Array[String]) {



    val sparkConf = new SparkConf().setAppName("Uima Note Deid")
    val sc = new SparkContext(sparkConf)

  //
  // -> WILL BECOME: only one json file containing all texts, included demographics.
  // -> WILL BECOME: sc.textFile("/home/nps/git/fhir-json/test.json",32).toDF.show(10, truncate = false)

          val input_path = args(0)
          val output_path = args(1)

	  val rdd = sc.textFile(input_path)
	  rdd.map(string => tt.analyzeText(string)).collect

  //
  //
  //


    sc.stop()
  }
}
// scalastyle:on println

