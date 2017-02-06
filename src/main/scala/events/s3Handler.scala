package events

import java.net.URLDecoder

import com.amazonaws.services.lambda.runtime.events.S3Event

import scala.collection.JavaConverters._

/**
  * Created by bweigel on 2/6/17.
  */
object s3Handler {
  def decodeS3Key(key: String): String = URLDecoder.decode(key.replace("+", " "), "utf-8")

  def handleEvent(event: S3Event): java.util.List[String] = {
    val result = event.getRecords.asScala.map(record => decodeS3Key(record.getS3.getObject.getKey)).asJava
    println(result)
    return result
  }
}
