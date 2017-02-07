package events

import com.amazonaws.services.lambda.runtime.events.SNSEvent

import scala.collection.JavaConverters._

/**
  * Created by bweigel on 2/6/17.
  */
object snsHandler {
  def handleEvent(event: SNSEvent): String = {
    println("Encountered SNSEvent!")
    println(event.getRecords.asScala.map(record => record.getSNS.getSubject))
    return event.getRecords.asScala.map(record => record.getSNS.getSubject).toList.head
  }
}
