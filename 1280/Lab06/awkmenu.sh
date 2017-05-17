#!/bin/bash
while true
do
echo "Enter the input"
echo "1- Question 2"
echo "2- Question 3"
echo "3- Question 4"
echo "4- Question 5"
read -n 1 c input;
case $input in
"1")bash Question2.awk;;
"2")bash Question3.awk;;
"3")bash Question4.awk;;
"4")bash Question5.awk;;
"*") echo "Wrong input";;
esac
done

exit 0