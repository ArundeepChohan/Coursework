/**********************************************************
 * RPS GUI : view / controls
 *    Abstracts the Graphical User Interface for the game of RPS
 *    The goal is to hide the details of how the GUI is defined from the rest of the system.
 **********************************************************/

//#### C O N T R O L S #########
// Define a 'Global Variable' for each "control" on the user interface

// For example, here is a variable to store a reference to the "rock" button.
// Now when the program wants to reference this GUI control, it can use the variable rockButton
var rockButton = document.getElementById('rock-button');
var paperButton = document.getElementById('paper-button');
var scissorButton = document.getElementById('scissors-button');

//#### V I E W #########
// Define a 'Global Variable' for each "visual element" on the user interface
// And define a function that will update the visual display of that element.

var userThrow=document.getElementById('human-throw');
var computerThrow=document.getElementById('computer-throw');

var userScore=document.getElementById('human-wins');
var computerScore=document.getElementById('computer-wins');
var tieGame=document.getElementById('tie-games');

var rockImage = document.getElementById('rock-image').src;
var paperImage = document.getElementById('paper-image').src;
var scissorImage = document.getElementById('scissors-image').src;

// For example, here is a variable to store a reference to the "message" area.
var messageElement = document.getElementById('message');
	
// and here is a function to post a new message on the UI:
function sendMessage(newMessage) {
	messageElement.innerHTML = newMessage;
}

function showUserThrow( symbol )         //- set the user's throw image
{
	if(symbol == 'rock')
	{
	userThrow.src= rockImage;
	}
	else if(symbol == 'paper')
	{
	userThrow.src= paperImage;
	}
	else if(symbol == 'scissors')
	{
	userThrow.src= scissorImage;
	}
}

function showCompThrow( symbol )        // - set the computer's throw image
{
	if(symbol == 'rock')
	{
	computerThrow.src= rockImage;
	}
	else if(symbol == 'paper')
	{
	computerThrow.src= paperImage;
	}
	else if(symbol == 'scissors')
	{
	computerThrow.src= scissorImage;
	}
}

function updateScoreboard( win, lose, tie ) //- update the 3 scores on the scoreboard.
{
	userScore.innerHTML = win;
	computerScore.innerHTML = lose;
	tieGame.innerHTML = tie;
}

/* TRY IT:  
 *   -  Load the page and in the console, type:  sendMessage('hello');
 *   -  assign a function value to the rockButton's onclick handler like this:
 *           rockButton.onclick = function(event) { alert("You picked " + event.target.value); };
 */

