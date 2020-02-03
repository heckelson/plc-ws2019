#!/bin/sh
if [ -z "$1" ]
then
	echo "Usage: ./run.sh <PROGRAM-NAME>"
else
	echo "java -cp bin $@"
	java -cp bin $@
fi
