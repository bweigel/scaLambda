package test

import com.amazonaws.services.lambda.runtime.Context
import lambda.genericLambdaEventHandler
import mocker.{mockS3Event, mockSNSEvent}
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec}

import scala.collection.JavaConverters._

class test_handler extends FlatSpec with BeforeAndAfter with MockitoSugar {

  private val S3event = mockS3Event.mock()
  private val SNSevent = mockSNSEvent.mock()
  private val context = mock[Context]

  "An S3Event" should "return the right ObjectEntetiy.key" in {
    assert(genericLambdaEventHandler.handleEvent(S3event, context) === "HappyFace.jpg")
  }
  it should "contain the right EventSource" in {
    assert(S3event.getRecords.asScala.toList.head.getEventSource === "aws:s3")
  }

  "An SNSEvent" should "not be empty" in {
    assert(SNSevent.getRecords.asScala.nonEmpty)
  }
  it should "contain the right EventSource" in {
    assert(SNSevent.getRecords.asScala.toList.head.getEventSource === "aws:sns")
  }
  it should "contain a non empty SNS" in {
    assert(SNSevent.getRecords.asScala.toList.head.getSNS !== ())
  }
  it should "be processed right" in {
    assert(genericLambdaEventHandler.handleEvent(SNSevent, context) === "This is a Mock-Subject!")
  }

}