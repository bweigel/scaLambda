package mocker

import com.amazonaws.services.lambda.runtime.events.SNSEvent
import com.amazonaws.services.lambda.runtime.events.SNSEvent._

import scala.collection.JavaConverters._

/**
  * Created by bweigel on 2/6/17.
  */


object mockSNSEvent {

  private val mockSNS = new SNS()
  mockSNS.setMessage("Hello from SNS!")
  mockSNS.setSubject("This is a Mock-Subject!")

  private val mockSNSEventRecord = new SNSRecord()
  mockSNSEventRecord.setEventSource("aws:sns")
  mockSNSEventRecord.setEventSubscriptionArn("arn:aws:test")
  mockSNSEventRecord.setEventVersion("2.0")
  mockSNSEventRecord.setSns(mockSNS)

  private val mockSNSEvent = new SNSEvent()
  mockSNSEvent.setRecords(List(mockSNSEventRecord).asJava)

  def mock(): SNSEvent = {
    mockSNSEvent
  }
}