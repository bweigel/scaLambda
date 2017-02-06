package events

import com.amazonaws.services.lambda.runtime.events.SNSEvent


/**
  * Created by bweigel on 2/6/17.
  */
object snsHandler {
  def handleEvent(event: SNSEvent): String = {
    println("Encountered SNSEvent!")
    return "SNSEvent!"
  }
}
