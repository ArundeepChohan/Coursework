#!/bin/bash
var text = find . -type f -name "*.txt" | wc -l
var text2 =  find . -type f ! -name "*.txt" | wc -l

var searchdir =$1
for file in "ls -a searchdir"
do
file "$file"
done

echo "Found $text text files."
echo "Found $text2 files of other types."
exit 0