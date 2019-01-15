import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.classification.NaiveBayesModel
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.regression.LabeledPoint
import java.sql.{ResultSet, DriverManager, Connection}
import org.apache.spark.rdd.JdbcRDD


object  Model_Build_DB {
  def main(args: Array[String]) = {
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://ec2-52-37-241-124.us-west-2.compute.amazonaws.com/credit_data"
    val username = "root"
    val password = ""
    System.setProperty("hadoop.home.dir", "C:\\Users\\Sharath\\Desktop\\hadoop-common-2.2.0-bin-master\\")
    val conf = new SparkConf().setAppName("Bayes Model").setMaster("local")
    val sc = new SparkContext(conf)
    var connection: Connection = null;
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val resultset = statement.executeQuery("select count(*) from credit_data")

    try{

      Class.forName(driver)



      val data = new JdbcRDD( sc, () =>
        DriverManager.getConnection(url,username,password) ,
        "SELECT * FROM credit_data limit ?,?",
        1, 120, 4, resultset => resultset.getInt( 1 )+ "," +resultset.getInt( 2 )+ "," +resultset.getInt( 3 )+ "," +resultset.getInt( 4 )+ "," +resultset.getInt( 5 )+
          "," +resultset.getInt( 6 )+ "," +resultset.getInt( 7 )+ "," +resultset.getInt( 8 )+ "," +resultset.getInt( 9 )+ "," +resultset.getInt( 10 )+ "," +
          resultset.getInt( 11 )+ "," +resultset.getInt( 12 )+ "," +resultset.getInt( 13 )+ "," +resultset.getInt( 14 )+ "," +resultset.getInt( 15 ) )
      println("Size of the RDD is :" +data.count()+"\n****************")
      data.foreach(line=>println(line))
    }

    catch{
      case e: Exception => {
        print(e)
      }
    }


  }

  //      val data = sc.textFile("sample_naive_bayes_data.txt")
  //      val parsedData = data.map { line =>
  //        val parts = line.split(',')
  //        LabeledPoint(parts(14).toDouble, Vectors.dense(parts(1).toDouble,
  //          parts(2).toDouble,
  //          parts(3).toDouble,
  //          parts(4).toDouble,
  //          parts(5).toDouble,
  //          parts(6).toDouble,
  //          parts(7).toDouble,
  //          parts(8).toDouble,
  //          parts(9).toDouble,
  //          parts(10).toDouble,
  //          parts(11).toDouble,
  //          parts(12).toDouble,
  //          parts(13).toDouble))
  //      }
  //      // Split data into training (60%) and test (40%).
  //      val splits = parsedData
  //      val training = splits
  //      val test = Vectors.dense(Array(41,0.04,2,10,4,0.04,0,1,1,0,1,560,1))
  //      val model = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")
  //  //    val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
  //  val predictionAndLabel =  model.predict(test)
  //  //    val x=predictionAndLabel.collect()
  //  //  println(x.length)
  //      println("**************************************result*******************************")
  //  //    x.foreach(x=> println(x.toString()+"\n"))
  //      if(predictionAndLabel==0)
  //      println("Prediction model says credit cannot be approved")
  //      else
  //        println("Prediction model says credit can be approved")
  //
  //
  //  //    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
  //  //    println("Accuracy of the model is: "+accuracy)
  //      // Save and load model
  //      model.save(sc, "target/tmp/myNaiveBayesModel1")
  //      //    val sameModel = NaiveBayesModel.load(sc, "target/tmp/myNaiveBayesModel")
  //    }


  //  def main(args: Array[String])={
  //
  //    val driver = "com.mysql.jdbc.Driver"
  //    val url = "jdbc:mysql://localhost/scala_db"
  //    val username = "root"
  //    val password = "password"
  //
  //    var connection:Connection=null;
  //    try{
  //      Class.forName(driver)
  //      connection=DriverManager.getConnection(url,username,password)
  //      val statement=connection.createStatement()
  //      val resultset=statement.executeQuery("SELECT * FROM credit_model")
  //      while(resultset.next()){
  //        println(resultset.getInt("Male")+","+resultset.getInt("Age")+","+resultset.getInt("Debt")+","+resultset.getInt("Married")+","+resultset.getInt("EducationLevel")+","+resultset.getInt("Ethnicity")+","+resultset.getInt("YearsEmployed")+","+resultset.getInt("PriorDefault")+","+resultset.getInt("Employed")+","+resultset.getInt("CreditScore")+","+resultset.getInt("DriversLicense")+","+resultset.getInt("Citizen")+","+
  //          resultset.getInt("ZipCode")+","+resultset.getInt("Income")+","+resultset.getInt("Approved")+"\n")
  //      }
  //    }
  //    catch {
  //      case e: Exception=>{
  //        println("Error acquired")
  //      }
  //    }
  //    connection.close()
  //  }

}