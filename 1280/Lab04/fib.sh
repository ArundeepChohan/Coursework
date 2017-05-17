#!/bin/bash
f1 = 0
f2 = 1
input = $1
for((i=0; i<input; i++));
do
echo -n "$f1"
fn = $((f1 + f2))
f1 = $f2
f2 = $fn

done
exit 0