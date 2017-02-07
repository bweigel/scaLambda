package lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.{S3Event, SNSEvent}
import events.{s3Handler, snsHandler}

/*
    Example from: https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/
*/
object genericLambdaEventHandler {
  def handleEvent(event: Any, context: Context): Any = {
    println(event.getClass)
    event match {
      case ev: S3Event => s3Handler.handleEvent(ev)
      case ev: SNSEvent => snsHandler.handleEvent(ev)
      case _ => handleUnspecifiedEvent(event)
    }
  }

  def handleUnspecifiedEvent(event: Any): Unit = {
    println("No suitable handler for event: " + event)
  }

}
