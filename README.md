# spark-newday-test
NewDay Spark Test
## To build package jar
```
    sbt clean package
```

## Run application locally
```
/path/to/spark/bin/spark-submit \
  --class com.newday.mucahit.SparkApp \
  --master local[*] \
  /path/to/spark-newday-test/target/scala-2.12/spark-newday-test_2.12-0.1.jar \
  -i /input/path/to/movies \
  -m /output/path/to/movies \
  -r /input/path/to/ratings \
  -s /output/path/to/ratings \
  -d '::'
```
