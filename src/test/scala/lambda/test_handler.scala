package test

import com.amazonaws.services.lambda.runtime.events.SNSEvent
import lambda.genericLambdaEventHandler
import mocker.mockS3Event
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FlatSpec}

class test_handler extends FlatSpec with BeforeAndAfter with MockitoSugar {

  private val S3event = mockS3Event.mockS3Event()
  private val SNSevent = mock[SNSEvent]

  "An S3Event" should "return the right ObjectEntetiy.key" in {
    assert(new genericLambdaEventHandler().handleEvent(S3event) === "HappyFace.jpg")
  }

}