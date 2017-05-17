/**
 * This JavaScript file implments solutions for the problems posed in Lab 9
 * Code in this file draws on theCanvas canvas element in the document.
**/
var theCanvas = document.querySelector("#theCanvas");
// We use the variable name "c" here to be consistent with Code Maven (http://www.crunchzilla.com/code-maven)
var c = theCanvas.getContext("2d");


// Determine if a value is a postitive integer
function isPositiveInteger( value ) {
	return ! (isNaN(value) || value <=0 || value%1 !== 0);
}

// Prompt for a positive integer
function getIntegerInput(question) {
  var input;
	do {
		var input = Number( prompt(question));
		if (! isPositiveInteger( input ) ) {
			question = "Please enter a positive integer value\n" + question;
		}
	} while ( !isPositiveInteger( input ) );
	// assert: input is a positive integer
	return input;
}


// Draw a single polygon of the given size with the given number of sides
function drawPolygon(numSides, radius) {
	var x, y;
	var angle = 2*Math.PI/numSides;
	
	c.beginPath();
	for (var i=0; i<=numSides; i++) {
		x = radius * Math.cos(i * angle );
		y = radius * Math.sin(i * angle);
		if (i===0) {
			c.moveTo(x, y);
		}
		else {
			c.lineTo(x, y);
		}
	}
	c.stroke();
}

// Ask user what type of polygon they want to draw, then draw it.
function doPolygon() {


	var sides = getIntegerInput("Draw a polygon with how many sides? (>=3)");
	//var sides=event.target.value;
	var radius = 100;
	c.translate(radius*1.2, radius*1.2);  // move the drawing origin away from the top-right.
	drawPolygon(sides, radius);
}

function doOctagon()
{
	var sides = event.target.value;
	var radius = 100;
	c.translate(radius*1.2, radius*1.2);  // move the drawing origin away from the top-right.
	drawPolygon(sides, radius);
}

// Draw a mandala or "spirograph" by rotating and re-drawing the polygon
function drawMandala( intensity ) {
	var sides = intensity <= 5 ? 7 : 5;  // decide which polygon to use, an hexagon or a pentagon
	var size = 100;
	var angle = 2*Math.PI / intensity; // compute rotation angle so we complete 1 revolution
	
	// Loop over all rotations.
	for (var rotation=0; rotation < intensity; rotation++) {
		// draw the polygon (notice that I had to copy the whole draw polygon algorithm ~~ hmmmmm)
		drawPolygon(sides, size);
		// rotate the canvas.
		c.rotate(angle);
	}
}

function doMandala() {
	var intensity = getIntegerInput("How intense do you want your Mandala?  (3 - 10)");
	var radius = 100;
	c.translate(radius*1.2, radius*1.2);  // move the drawing origin away from its current position.
	drawMandala(intensity);
}

window.onload = configureEventHandlers;

/**
 * This function does all the set-up for the program.
 * It is intended to be called just once, just as the page has completed loading.
 */
function configureEventHandlers(event) {
	// The "click" event happens when the user makes a mouse-click on an element.
	// We often listen for click events on buttons, like this:
	var button = document.getElementById("myFirstButton");
	button.onclick = buttonClickListener;
	var button2 = document.getElementById("mySecondButton");
	button2.onclick = buttonClickListener;
	var button3 = document.getElementById("myThirdButton");
	button3.onclick = buttonClickListener;
}
//-------------------------------------------------------------------------------- 
//-----  EVENT LISTENERS - these functions are used to handle various events -----
//-------------------------------------------------------------------------------- 
/**
 * buttonClickListener : a simple handler for click events
 *   It just pops up an alert and logs the event..
 */
function buttonClickListener(event) {
  var element = event.target;

  // Pop up and alert to say which button was pressed.
 	/*if (element.type && element.type === "button") {
 		alert("You clicked the " + element.id + " button with value " + element.value);
 	}
	*/
	if(element.value==3)
	{
		
		doMandala();
	}
	else if(element.value==4)
	{
		
		doPolygon();
	}
	else if(element.value==8)
	{
		
		doOctagon();
	}
 	 //Call the generic event logging function
 	logDrawings( event );
}
function logDrawings(event)
{
	var element = event.target; 
	
	var myList = document.getElementById("output");
	var newItem = document.createElement("li");
	
	var html;
	html = event.type+element;

    newItem.innerHTML = html;
	output.appendChild( newItem );
}

// Finally - here is the actual program that runs when the page loads...
//doPolygon();
//doMandala();

// Oh - that was easy!