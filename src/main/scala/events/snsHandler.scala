package events

import com.amazonaws.services.lambda.runtime.events.SNSEvent


/**
  * Created by bweigel on 2/6/17.
  */
object snsHandler {
  def handlerEvent(event: SNSEvent): String = {
    val result = "SNS Event recieved!"
    println(result)
    return result
  }
}
