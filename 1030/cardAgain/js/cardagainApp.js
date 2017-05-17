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
	/*
	var card = {
		isFaceUp  : true,
		toString  : function() { 
						return "2d"; 
					},
	};

	*/
	//var whichCard=Math.floor(Math.random() * 13);
	var randSuit = randSuit();
	var randRank = randRank();


function Card (rank, suit) {

    this.rank = rank;
    this.suit = suit;
	isFaceUp  : true,
	toString  : function() { 
						return this.rank+this.suit;
					},
};

	


	return Card;	
	
}

//isFaceUp = !isFaceup;

var rankSymbol=
{
	1: "A",
	2: 2,
	3: 3,
	4: 4,
	5: 5,
	6: 6,
	7:7,
	8:8,
	9:9,
	10:10,
	11:"J",
	12:"Q",
	13:"K",
	
}
 var suitSymbol=
 {
	 1:"d",
	 2:"h",
	 3:"s",
	 4:"c",
 }

function randRank()
{
	console.log(rankSymbol(Math.floor(Math.random() * 13)));
	return rankSymbol(Math.floor(Math.random() * 13));
}
function randSuit()
{
	console.log(suitSymbol(Math.floor(Math.random() * 4)));
	return suitSymbol(Math.floor(Math.random() * 4));
	
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
