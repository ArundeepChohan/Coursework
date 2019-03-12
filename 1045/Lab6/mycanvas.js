/**
 * This JavaScript file is part of the "Canvas Template"
 * Code in this file draws on theCanvas canvas element in the document.
**/

var theCanvas = document.querySelector("#theCanvas");
// We use the variable name "c" here to be consistent with Code Maven (http://www.crunchzilla.com/code-maven)
var c = theCanvas.getContext("2d");

// Your code goes here! 
// You can write any code here that draws on the canvas "c", for example:

var size = 200;
var offset = 40;
var change = 2.5;

c.beginPath();
c.strokeStyle = "brown";
c.moveTo(140,0);
c.lineTo(190,40);
c.lineTo(90,40 );
c.lineTo(140,0 );
c.stroke();


c.fillStyle ="gold";
c.fillRect(offset, offset, size, size);

offset = 60;
size = 50;
c.fillStyle ="white";
c.fillRect(offset, offset, size, size);
c.fillRect(offset*change, offset, size, size);

c.fillRect(offset,offset*change,size*change,size);