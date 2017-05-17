/**
 * This JavaScript file is part of the "Canvas Template"
 * Code in this file draws on theCanvas canvas element in the document.
**/

var theCanvas = document.querySelector("#theCanvas");
// We use the variable name "c" here to be consistent with Code Maven (http://www.crunchzilla.com/code-maven)
var c = theCanvas.getContext("2d");

// Your code goes here! 
// You can write any code here that draws on the canvas "c", for example:
//c.fillRect(20, 20, 50, 75);

//-----------Part 1(comment second part out)
/*
var offset = -75;
var size = 150;
var angle = 0.2;

c.translate(size,size);

for(var i = 1; i < 50; i++)
{
	if(i < 10 )
	{
		c.fillStyle = "rgba(255, 0, 0, 0.5)";
	}
	else if (i < 30)
	{
		c.fillStyle = "rgba(0, 255, 0, 0.3)";
	}
	else
	{
		c.fillStyle = "rgba(0, 0, 255, 0.1)";
	}
	c.fillRect(offset,offset,size,size);
	c.rotate(angle);
}
*/

//----------Part 2(comment first part out)

//Prompting user for a positive number(Let's say 0 is positive)
var s;
do
{
	s = Number(prompt("Number of sides on the polygon"));
}
while((isNaN(s)) || s < 0)
		
var i, j, x, y;

// Using from the internet
var radius = 110, xcenter = theCanvas.width/2, ycenter = theCanvas.height/2, angle = 2*Math.PI/s;
 
c.beginPath();

c.save();//Saves coordinates before we screw with it
c.translate(xcenter,ycenter);//Moves to the middle of the canvas

for(j = 0;j < s;j+=1) //This part isn't rotating correctly
{	
	c.rotate(angle*-Math.PI/2); //Comment out to test rotation polygon
	for(i = 0;i <= s;i+=1) //This part basically displays the polygon
	{
		x = radius* Math.cos(i* angle);//Getting the x and y coordinates of the edges
		y = radius* Math.sin(i* angle);
		
		if(i === 0)//Moves to the first point
		{
			c.moveTo(x, y);
		}
		else
		{
			c.lineTo(x, y);
		}
	}
}	
c.restore();
c.closePath();
c.strokeStyle = "#000000";
c.lineWidth = 1;
c.stroke();

//---------------------------------------------------