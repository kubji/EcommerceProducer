package  com.pixipanda

import com.pixipanda.loggenerator.EcommerceLogGenerator
import com.pixipanda.producer.AvroPageViewProducer


object Main {

  def main(args: Array[String]) {

    val configParser = new ConfigParser()
    val logGeneratorConfig = configParser.loadLogGeneratorConfig
    val ecommerceLogGenerator = new EcommerceLogGenerator(logGeneratorConfig)
    val kafkaConfig = configParser.loadKafkaConfig
    val kafkaProducer = new AvroPageViewProducer(kafkaConfig)
    ecommerceLogGenerator.generateEvent(kafkaProducer)

  }

}