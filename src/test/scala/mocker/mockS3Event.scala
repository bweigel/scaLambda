package mocker

import com.amazonaws.services.lambda.runtime.events.S3Event
import com.amazonaws.services.s3.event.S3EventNotification._

import scala.collection.JavaConverters._

/**
  * Created by bweigel on 2/6/17.
  */

object mockS3Event {

  def mockS3Event(): S3Event = {
    new S3Event(List(mockS3EventNotificationRecord()).asJava)
  }

  def mockS3EventNotificationRecord() = new S3EventNotificationRecord(
    "EU-central1",
    "ObjectCreated:Put",
    "aws:s3",
    "1970-01-01T00:00:00.000Z",
    "2.0",
    new RequestParametersEntity("127.0.0.1"),
    new ResponseElementsEntity("EXAMPLE123/5678abcdefghijklambdaisawesome/mnopqrstuvwxyzABCDEFGH", "EXAMPLE123456789"),
    new S3Entity(
      "testConfigRule",
      new S3BucketEntity(
        "sourcebucket",
        new UserIdentityEntity("EXAMPLE"),
        "arn:as:s3:::mybucket"
      ),
      new S3ObjectEntity(
        "HappyFace.jpg",
        12L,
        "0123456789abcdef0123456789abcdef",
        "0A1B2C3D4E5F678901"
      ),
      "1.0"
    ),
    new UserIdentityEntity("EXAMPLE")
  )

}