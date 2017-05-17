#!/bin/bash

ps -auxh | awk '
BEGIN{} 
{cpu+=$3;memory+=$4}
END 
{print "Total cpu:"cpu "Total memory: " memory}'