package events

import java.net.URLDecoder
import java.util.{List => JList}

import com.amazonaws.services.lambda.runtime.events.S3Event

import scala.collection.JavaConverters._

/**
  * Created by bweigel on 2/6/17.
  */
object s3Handler {
  def handleEvent(event: S3Event): String = {
    println("Encountered S3Event!")

    val result = event.getRecords.asScala.map(record => decodeS3Key(record.getS3.getObject.getKey)).asJava
    return result.get(0)
  }

  def decodeS3Key(key: String): String = URLDecoder.decode(key.replace("+", " "), "utf-8")
}
