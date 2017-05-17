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

function doMandala()
{
	var radius = 110, xCenter = theCanvas.width/2, yCenter = theCanvas.height/2; 
	var j,sides = getIntegerInput('Number of sides on the polygon');
	c.beginPath();
	c.translate(xCenter,yCenter);//
	for(j = 0;j < sides;j+=1) 
	{
		drawMandela(sides);//Comment out to test rotation polygon
		drawPolygon(sides,radius);
	}	
	c.closePath();
	c.strokeStyle = "#000000";
	c.lineWidth = 1;
	c.stroke();
}
//Prompting user for a positive number(Let's say 0 is positive)
function getIntegerInput(question)
{
	var input;
	do
	{
		input = Number(prompt(question));
	}	
	while((isNaN(input)) || input < 0)
	return input;
}

//This part basically displays the polygon
function drawPolygon(sides,radius)
{
	var i,angle = 2*Math.PI/sides;;
	for(i = 0;i <= sides;i+=1) //This part basically displays the polygon
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

function drawMandela(intensity)
{
	var angle = 2*Math.PI/intensity;
	c.rotate(angle*-Math.PI/2);
}

doMandala();

//---------------------------------------------------