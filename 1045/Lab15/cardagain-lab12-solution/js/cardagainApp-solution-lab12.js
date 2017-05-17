/**********************************************************
 * Cardagain Model : model
 *    Implements the model for the Cardagain demo
 **********************************************************/

 
var cardDeck = { 
	CARD_RANK : ["joker","a", "2", "3", "4", "5", "6", "7", "8", "9", "t","j", "q", "k"],
	CARD_SUIT: ["c", "d", "h", "s"],
	cards : [],  // array of objects!
	isEmpty : function() {  return this.cards.length === 0; },
	shuffle : function() { 

	// Set array of cards.
	
     for (var suit = 0; suit < this.CARD_SUIT.length; suit++)
	{
		for (var rank = 1; rank < this.CARD_RANK.length; rank++)
		{
			this.cards.push(new Card(this.CARD_RANK[rank],this.CARD_SUIT[suit]));
			console.log(new Card(this.CARD_RANK[rank],this.CARD_SUIT[suit])); 
		}
	}
	this.cards.push(new Card(this.CARD_RANK[0], ''));
	this.cards.push(new Card(this.CARD_RANK[0], ''));
	
 }, 
	drawCard: function() { 
	if(this.cards.length>0)
	{//Generates a random integer between 0 - this.cards.length  -- thus, as the deck gets smaller, we always select one of remaining cards.
	
	var index =Math.floor(Math.random() * this.cards.length);
	console.log(index);
		var card=this.cards.splice(index, 1);
	console.log(card);
	console.log(this.cards);
		return card[0];
		
	}
	else
	{
		return null;
	}
 }, 
 
 
 };
/**
 * Card object "Constructor" - constructs cards to a given specification
 */
function Card(rank, suit) {

	this.rank = rank;
	console.log(this.rank);
	this.suit = suit;
	console.log(this.suit);
	this.isFaceUp = true;
	this.toString = function() { 
	console.log(this.rank + this.suit);
						return this.rank + this.suit; 
				};
	this.flip = function() {
	console.log(this.isFaceUp);
					this.isFaceUp = !this.isFaceUp;
			};
}

/** 
 * Compute a random card suit
 * Returns one of:  'c', 'd', 'h', 's'
 */
function randomSuit() {
	var suit = Math.floor(Math.random() * 4);
	// Note: "break;" normally required after each case - but not needed here because the function returns in each case.
	/*
	switch (suit) {
		case 0 : return 'c';
		case 1 : return 'd';
		case 2 : return 'h';
		case 3 : return 's';
		default:  return "error - this should never happen!";
	};
	*/
	return CARD_SUIT[suit];
}

/** 
 * Compute a random card rank
 * Returns one of:  'a', '2', '3', ... , '9', 't', 'j', 'q', 'k'
 */
function randomRank() {
	var rank = Math.floor(Math.random() * 13) + 1;
	/*
	switch (rank) {
		case 1  : return 'a';
		case 10 : return 't';
		case 11 : return 'j';
		case 12 : return 'q';
		case 13 : return 'k';
		default:  return String(rank);
	};
	*/
	return CARD_RANK[rank];
}
/**
 * "Card Factory" - creates and returns a random "card" object
 */
function getCard() {
	
	/*return new Card( randomRank(), randomSuit() );	*/
	if (cardDeck.isEmpty())
	{
		cardDeck.shuffle();
	}
	return cardDeck.drawCard();
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
