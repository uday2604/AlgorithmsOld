/**
  * Created by Uday on 2016-04-21.
  */
import kafka.consumer._
import scala.collection.immutable.Map;

object KafkaConsumer {

  def main(args: Array[String]) = {

    val props = new java.util.Properties()
    props.put("zookeeper.connect", "ec2-54-191-101-60.us-west-2.compute.amazonaws.com:2181")
    props.put("group.id", "testgroup")
    props.put("zookeeper.session.timeout", "400")
    props.put("zookeeper.sync.time.ms", "300")
    props.put("auto.commit.interval.ms", "1000")
    val config = new kafka.consumer.ConsumerConfig(props);

    //val consumerConnector = Consumer.createJavaConsumerConnector(config)

    val consumer = kafka.consumer.Consumer.create(config)

    val topicName = "testnew6"
    val numThreads = 1

    val topicMap = Map(topicName -> numThreads)

    val consumerMap = consumer.createMessageStreams(topicMap)

    val consumerIterator=consumerMap.get(topicName).get.head.iterator()

    val msgs=consumerIterator.map(_.message())

   // msgs.foreach(msg=>println(new String(msg)))

    val stringBuilder = new java.lang.StringBuilder

    msgs.foreach(message=>stringBuilder.append(new String(message)))

    println(stringBuilder)

    var stringArray= new Array[String](3)

    stringArray = stringBuilder.toString.split(",")
    println("2".parseDouble)
    println(("3".parseDouble)

    //msgs.foreach(msg=> val x=new String(msg))

  }
}
