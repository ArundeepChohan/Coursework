/**********************************************************
 * Craps GUI : view / controls
 *    Abstracts the Graphical User Interface for the game of Craps
 * 
 * Craps.controls:
 *  - manages a 2 UI controls - the "new game" and "roll" buttons
 *    Usage: 
 *        Craps.controls.newGameButton.onclick = someFunction;
 *        Craps.controls.rollButton.onclick = someOtherFunction;
 *        Craps.controls.rollButton.disabled = booleanValue;  // true to disable button, false to enable it
 * 
 * Craps.view:
 *  - provides a view of the model using 2 UI elements - a pair of dice images and a message box.
 *    Usage: 
 *        Craps.view.roll(die1Value, die2Value);
 *        Craps.view.sendMessage(message);
 *
 * Implemenation Notes:
 *  - this module defines two "singleton" objects: controls and view   
 *  - the view implements a short animation when the dice are rolled. 
 **********************************************************/
// Namespace for Craps components
var Craps = Craps || {};

Craps.controls = {
	newGameButton : document.getElementById('newgame-button'),
	rollButton : document.getElementById('roll-button'),
};

Craps.controls.init = function() {
	this.newGameButton.disable = false;
	this.rollButton.disable = false;
};

Craps.view = { 
	dice : [document.getElementById('players-dice1'), document.getElementById('players-dice2')],
	message : document.getElementById('message'),
	dieImages : [],  // this array is filled during init.
};

Craps.view.init = function(message) {
	this.dieImages = this.loadDieImages();  // load the 6 images
	var startDie = Math.floor(Math.random()*6 + 1);
	this.roll(startDie, startDie);
	this.sendMessage(message);
};

Craps.view.roll = function(die1, die2) {
	Craps.assert(1 <= die1 && die1 <= 6, "In Craps.view.roll() - die1 is out of range", die1);
	Craps.assert(1 <= die2 && die2 <= 6, "In Craps.view.roll() - die2 is out of range", die2);

	var self = this;
	var animationsLeft = 10;
	
	function animationStep() {
	  if (animationsLeft > 0) {
	  	for (var i=0; i<self.dice.length; i++) {
			var randomDie = Math.floor( Math.random() * 6 + 1 );
	  		self.dice[i].src = self.dieImages[randomDie];
	  	}
	  	animationsLeft--;
	  	window.requestAnimationFrame(animationStep);
	  }
	  else {  // at the end of the animation, settle on the given dice faces.
		self.dice[0].src = self.dieImages[die1];
		self.dice[1].src = self.dieImages[die2];
	  	
	  }
	}
	// Do the animation, which concludes by setting the dice faces to die1 and die2
	window.requestAnimationFrame(animationStep);
};

Craps.view.sendMessage = function(message) {
	this.message.innerHTML = message;	
};

Craps.view.loadDieImages = function() {
	var numDie = 6;
	var images = [];
	for (var i=1; i<=numDie; i++) {
		var dieID = 'die'+i;
		images[i] = document.getElementById(dieID).src;
	}
	return images;
};

Craps.assert = function(test, message, object) {
	if (!test) {
		console.log(message, object);
		throw message;
	}
};
