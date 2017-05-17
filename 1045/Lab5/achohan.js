/*
Name:		Arundeep Chohan
Course:		Cpsc 1045-003
Lab Number: 5
*/

document.write("Hello World ");

//a is the first side, b is the second, c is the length of hypotenuse
var a = Number(prompt("Please enter the value for the first side"));
var b = Number(prompt("Please enter the value for the second side"));
var c = Math.sqrt((a*a) + (b*b));

document.write("The length of the hypotenuse of a right-triangle: " +c +" with sides of "+a+" , "+b+".");