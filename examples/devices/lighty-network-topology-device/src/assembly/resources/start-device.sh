#!/bin/bash

# The script accepts one parameter signifying the listening port of the NETCONF server.
#
# ./start-device <NETCONF-port>
#
# When run without a parameter a default port 17830 will be used.

CLASSPATH=lighty-network-topology-device-13.1.1.jar

for jar in `ls -1 lib/`;
do
   CLASSPATH=$CLASSPATH:lib/$jar
done

#echo $CLASSPATH
java -server -Xms16M -Xmx40M -XX:MaxMetaspaceSize=40m -classpath $CLASSPATH io.lighty.netconf.device.topology.Main $1
