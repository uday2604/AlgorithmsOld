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

object program{


  def main(args: Array[String]) = {
    System.setProperty("hadoop.home.dir", "D:\\Downloads\\hadoop-common-2.2.0-bin-master\\hadoop-common-2.2.0-bin-master\\")
    val conf = new SparkConf().setAppName("Bayes Model").setMaster("local")
    val sc = new SparkContext(conf)
    val data = sc.textFile("sample_naive_bayes_data.txt")
    val parsedData = data.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }
    // Split data into training (60%) and test (40%).
    val splits = parsedData.randomSplit(Array(0.6, 0.4), seed = 11L)
    val training = splits(0)
    val test = splits(1)
    val model = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")
    val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
    println("Accuracy of the model is: "+accuracy)
    // Save and load model
    model.save(sc, "target/tmp/myNaiveBayesModel")
    //    val sameModel = NaiveBayesModel.load(sc, "target/tmp/myNaiveBayesModel")
  }
}