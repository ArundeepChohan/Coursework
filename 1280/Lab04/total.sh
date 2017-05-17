#!/bin/bash

f1 = ls -l $1 | wc-l
f2 = ls -l $2 | wc-l
f3 = $((f1 + f2))
echo $f3
exit 0