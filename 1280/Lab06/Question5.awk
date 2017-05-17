#!/bin/bash

ls -la | awk '
BEGIN {current=0 }
{
lineCounter++;
totalSize += $5;

if($5 > current){
	current = $5;
	largestFile=$9  
}
}
END {print " total: " totalSize, " average: " totalSize/lineCounter, " Largest: " largestFile }'

