package lambda

import com.amazonaws.services.lambda.runtime.events.{S3Event, SNSEvent}
import events.{s3Handler, snsHandler}

/*
    Example from: https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/
*/
class genericLambdaEventHandler {
  def handleEvent(event: Any): Any = {
    event match {
      case ev: S3Event => s3Handler.handleEvent(ev)
      case ev: SNSEvent => snsHandler.handleEvent(ev)
      case _ => handleUnspecifiedEvent(event)
    }
  }

  def handleUnspecifiedEvent(event: Any): Unit = {
    println("No suitable handler for event!")
  }

}
