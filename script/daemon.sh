#!/bin/sh


SERVICE_NAME=$2
SCRIPT_PATH=$(cd "$(dirname "$0")"; pwd)
BASE=$(dirname ${SCRIPT_PATH})
SERVICE_PID=${SERVICE_NAME}.pid
PID_PATH_NAME=${BASE}/pids/$SERVICE_PID
CMD=$3

#echo "base: $BASE"
#echo "pid path name: $PID_PATH_NAME"

# Start service 
start() {
    echo "Starting $SERVICE_NAME ..."

    if [ -f "$PID_PATH_NAME" ]; then
    	PID=$(cat $PID_PATH_NAME);
    else
	    PID=0;
    fi

    if [ ! -d "/proc/$PID" ]; then
        echo -e "running command \n$CMD\n"
       # eval nohup $CMD > /dev/null 2>&1 &
 eval nohup $CMD > server.out 2>&1 &
        pid=$!
        sleep 1

        if [ ! -d "/proc/$pid" ]; then
            echo "$SERVICE_NAME not started. See log for detail."
            rm -f $PID_PATH_NAME
            rm -f /app/tvc-realtime-spark/$SERVICE_NAME
            exit 1
        else
            echo $pid > $PID_PATH_NAME
            echo "$SERVICE_NAME started ... PID: $!"
            touch /app/tvc-realtime-spark/$SERVICE_NAME
        fi
    else
        echo "$SERVICE_NAME is already running ..."
    fi
}

# Start service 
stop() {
    if [ -f "$PID_PATH_NAME" ]; then
    	PID=$(cat $PID_PATH_NAME);
    else
	    PID=0;
    fi

    if [ -d "/proc/$PID" ]; then
        echo "$SERVICE_NAME stoping ..."
        for p_pid in `ps -ef |grep $PID|egrep -v grep | awk '{print $2}'`
        do
         kill -s 9 $p_pid
        done
        echo "$SERVICE_NAME stopped ..."
        rm -f $PID_PATH_NAME
        rm -f /app/tvc-realtime-spark/$SERVICE_NAME
    else
        echo "$SERVICE_NAME is not running."
    fi
}

status() {
    if [ -f "$PID_PATH_NAME" ]; then
    	PID=$(cat $PID_PATH_NAME);
    else
	    PID=0;
    fi
    #echo $PID;

    if [ -d "/proc/$PID" ]; then
        echo "Service '$SERVICE_NAME' is running..."
	echo "PID: $PID"
    else
        echo "Service '$SERVICE_NAME' is not running."
    fi
}

case $1 in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        stop
        start
        ;;
    status)
        status
        ;;
    *)
        echo $"Usage: $0 {start|stop|restart|reload|status}"
        exit 1
esac

exit 0
