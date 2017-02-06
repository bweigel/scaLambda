# scaLambda

This is a skeleton for writing functions for AWS Lambda in Scala. 
It was blatently copied from [this blogpost](https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/).

## Usage

### 1. Compile using sbt

```
$ cd /dir/to/git/repo
$ sbt assembly
... info messages ...
[info] Packaging /home/bweigel/dev/scalambda/target/scala-2.12/scala-lambda-assembly-1.0.jar ...
[info] Done packaging.
```

### 2. Upload `target/scala-2.12/scala-lambda-assembly-1.0.jar` to AWS Lambda

- Runtime: Java 8
- Handler: `example.main::getSourceBuckets`

### 3. Test using _S3 put_ event
