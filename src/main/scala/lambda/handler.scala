package lambda

import com.amazonaws.services.lambda.runtime.events.{S3Event, SNSEvent}
import events.{s3Handler, snsHandler}

/*
    Example from: https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/
*/
class handler {
  def handleEvent(event: Any): Any = {
    event match {
      case event: S3Event => handleS3Event(event)
      case event: SNSEvent => handleSNSEvent(event)
      case _ => handleUnspecifiedEvent(event)
    }
  }

  def handleUnspecifiedEvent(event: Any): String = {
    println(event)
    return "No suitable handler for event!"
  }

  def handleS3Event(event: S3Event): java.util.List[String] = {
    println(event)
    s3Handler.handleEvent(event)
  }


  def handleSNSEvent(event: SNSEvent): String = {
    snsHandler.handlerEvent(event)
  }
}
