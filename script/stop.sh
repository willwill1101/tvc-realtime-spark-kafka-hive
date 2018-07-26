#!/bin/sh

script_path=$(cd "$(dirname "$0")"; pwd)
base=$(dirname ${script_path})
appname=spark-kafka-hive
$base/bin/daemon.sh stop ${appname}
