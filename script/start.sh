#!/bin/sh
base_dir=$(dirname $0)/..

# loading dependency jar in lib directory
for file in $base_dir/lib/*.jar;
do
  JARS=$JARS,$file
done
  JARS=${JARS:1}

conf_src=$base_dir/conf/conf.properties
conf_dest=$base_dir/lib/conf.properties
rm -f $conf_dest
cp  $conf_src $conf_dest


master=yarn-client
jar=.
main_class=com.ehl.streaming.tohive.RealtimeKafkaService
#应用于stand alone模式
cores=4
#用于yarn-client模式，每个executor使用的内核数
#excores=2
memory=2g
appname=spark-kafka-hive

cmd="spark-submit\
 --master ${master}\
 --class ${main_class}\
 --total-executor-cores ${cores}\
 --executor-memory ${memory}\
  --driver-java-options '-Xms2048m -Xmx2048m'\
  --jars ${JARS}\
  --files $base_dir/conf/conf.properties\
 $jar ${appname}"
 
$base_dir/bin/daemon.sh start  ${appname} "$cmd"
