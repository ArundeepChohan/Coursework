/**********************************************************
 * Cardagain Model : model
 *    Implements the model for the Cardagain demo
 **********************************************************/
// THIS IS WHERE ALL OF YOUR CODE SHOULD GO.

/**
 * "Card Factory" - creates and returns a "card" object
 */
function getCard() {
	
	// STUB: this code shows a minmal model for a Card object.  You job is to build a better one!
	var card = {
		isFaceUp  : true,
		toString  : function() { 
						return "2d"; 
					},
	};
	
	return card;	
}



/**********************************************************
 * Cardagain App : app contorller
 *    Implements the controller for the Cardagain demo
 **********************************************************/
// Namespace for Cardagain components
var Cardagain = Cardagain || {};

/**
 * Event Handler - Start a new game
 */
Cardagain.newGame = function ( ) {
	console.log("New Game");
		
	Cardagain.view.clearCards();
};

/**
 * Event Handler: Deal a card - this method adds a card to the "card table" in the view.
 */
Cardagain.dealCard = function( ) {
	console.log("Deal Card ");

	Cardagain.view.dealCard( getCard() );
};

/**
 * Event Handler: Pick a card - this method responds to clicks on cards - it flips them over.
 */
Cardagain.pickCard = function( event, card ) {
	console.log("Pick Card: ", card);
	
	if ("flip" in card) {  // if the card object has a "flip" method, call it!
		card.flip();
	}	
	Cardagain.view.updateUI(card);
};

/**
 * Typical application start up - initialize view/controller, plug in event handlers, and wait for user to do something!
 */
Cardagain.startApp = function() {
	console.log("Start App");
	Cardagain.controls.init();
	Cardagain.view.init();
	
	Cardagain.controls.newGameButton.onclick = Cardagain.newGame;
	Cardagain.controls.deck.onclick  =  Cardagain.dealCard;
	Cardagain.controls.cards.onclick =  Cardagain.pickCard;
	
	Cardagain.newGame();
};

// Here's where it all begins - when the window's load event fires, it will call the startApp function declared above...
window.onload = Cardagain.startApp;
