#!/bin/bash
while true
do
echo "Enter the input"
echo "1- List Files"
echo "2- Date"
echo "3- Dmesg"
echo "4- Exit"
read -n 1 c input;
if[[$input = "4"]]
then 
exit
fi
case $input in
"1")ls-l;;
"2")echo date;;
"3")printk("Baetato");
 dmesg| less;;
"4")exit;;
"*") echo "Wrong input";;
esac
done

exit 0