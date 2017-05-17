#!/bin/bash
u="$USER"

uptime=$(</proc/uptime)
uptime=${uptime%%.*}

seconds=$(( uptime%60 ))
minutes=$(( uptime/60%60 ))
hours=$(( uptime/60/60%24 ))
days=$(( uptime/60/60/24 ))

echo "After being online for" 
echo "$minutes minutes"
echo "$u said"
echo "$@"
echo "The sentence has $0 words in it."
exit 0