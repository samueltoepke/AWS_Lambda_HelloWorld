# AWS_Lambda_HelloWorld
Amazon AWS provides Lambda as its 'code in the cloud' solution. In this example we will use Ant to create a HelloWorld .jar file.

The file can be uploaded and run in Lambda using CloudWatch to affect a scheduled task. The code will print out to logs the source trigger as well as the current time.
  
Java and Ant need installed/configured/set-up properly.   

## SOFTWARE:
 * [Java SDK 1.8.0_79](http://www.oracle.com/technetwork/java/javase/overview/index.html)
 * [Apache Ant 1.9.6](https://ant.apache.org/)
 * [AWS Lambda Java API](https://github.com/aws/aws-lambda-java-libs/tree/master/aws-lambda-java-core)

## EXECUTION:
 * All possible targets are in the ./build.xml file.
 * "$ ant" # Fully build the code.

Full instructions can be found here: [http://www.samueltoepke.com/amazon-aws-java-and-lambda/](http://www.samueltoepke.com/amazon-aws-java-and-lambda/) 

ROLE POLICY DOCUMENT:
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": [
        "logs:CreateLogGroup",
        "logs:CreateLogStream",
        "logs:PutLogEvents"
      ],
      "Resource": "arn:aws:logs:*:*:*"
    }
  ]
}

TEST EVENT:
{
  "account": "123456789012",
  "region": "us-east-1",
  "detail": {},
  "detail-type": "Scheduled Event",
  "source": "aws.events",
  "time": "1970-01-01T00:00:00Z",
  "id": "cdc73f9d-aea9-11e3-9d5a-835b769c0d9c",
  "resources": [
    "arn:aws:events:us-east-1:123456789012:rule/my-schedule"
  ]
}
