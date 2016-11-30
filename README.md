# scaLambda

This is a skeleton for writing functions for AWS Lambda in Scala. 
It was blatently copied from [this blogpost](https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/).

## Usage

### 1. Compile using sbt

```
$ cd /dir/to/git/repo
$ sbt
> compile
```

### 2. Upload jar to AWS Lambda

- Runtime: Java 8
- Handler: `example.Main::getSourceBuckets`

### 3. Test using _S3 put_ event
