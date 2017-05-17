/**********************************************************
 * Cardagain GUI : view / controls
 *    Abstracts the Graphical User Interface for the Cardagain demo
 * 
 * Cardagain.controls:
 *  - manages the UI controls - the deck and the cards
 *    Usage: 
 *        Cardagain.controls.newGameButton.onclick = someFunction;
 *        Cardagain.controls.deck.onclick = someFunction;
 *        Cardagain.controls.cards.onclick = someFunction;
 * 
 * Cardagain.view:
 *  - provides a view of the game using several UI elements.
 *    Usage: 
 *        Cardagain.view.clearCards();
 *        Cardagain.view.dealCard(card);
 *        Cardagain.view.updateUI ();
 * 
 * Implemenation Notes:
 *  - this module defines two "singleton" objects: controls and view 
 *  - control.cards is an array of pairs that maps a card object (model element) on the associated card image (view element).
 **********************************************************/
// Namespace for Cardagain components
var Cardagain = Cardagain || {};

//********  C O N T R O L S  *********
Cardagain.controls = {
	newGameButton : {onclick: undefined},
	deck 		  : {onclick: undefined},
	cards 		  : [],        // this will be an array of {card, cardImage} pairs (with an onclick property)
};

Cardagain.controls.init = function() {
	this.newGameButton = document.getElementById('newgame-button');
	this.deck = document.getElementById('deck-button');
	
	this.initCards();
};

// private: for internal use only
Cardagain.controls.initCards = function () {
	// The number of cards handled by the controller is completely defined by the HTML document.
	// Since this app does not require any understanding of the spatial layout of the cards,
	//   we can treat them as a simple, linear array and leave their spatail arrangement completely to HTML
	var cardImages = document.querySelectorAll("#gameboard .cards img");
	for (var c = 0; c < cardImages.length; c++) {
		var imgEl = cardImages[c];
		imgEl.onclick = null;
		imgEl.style.visibility = "hidden",
		this.cards[c] = {
			imgEl : imgEl,
			card  : null,
		};
	}
};

/**
 * Return the number of card controls.
 */
Cardagain.controls.size = function() {
	return this.cards.length;	
};

// private: for internal use only
// Apply the given function to each of the card controls
Cardagain.controls.apply = function ( operation ) {
	for (var c = 0; c < this.cards.length; c++) {
		operation( this.cards[c] );
	}
};

/**
 * Protected: for interal use.  Use view.dealCard(card) instead.
 * add a Card, if there is an empty "slot" in the cards control
 * @param {Object} card - an object representing a card. Must have an isFaceUp property and a toString() method.
 * @return  the card control item if the card was successfully added to the controls, or false if there is no more free space
 */
Cardagain.controls.addCard = function(card) {
	// Find an empty slot in the cards array to put the card.
	for (var c = 0; c < this.cards.length; c++) {
		if (! this.cards[c].card) {  		// find a slot with no card
			this.cards[c].card = card;
			this.cards[c].imgEl.onclick = this.wrapCardsHandler(card);	 
			return this.cards[c];  	// we found one - stop processing this loop
		}
	}
	return false;  // no empty slots.
};

/**
 * Only in JS you say... pity.
 * This is a "function factory" - it returns "specialized" versions of a function... 
 *   that "wraps" a call to the handler function with the given card location.
 * The inner function here shows an example of a function "closure".
 */
// Private: for internal use only.
Cardagain.controls.wrapCardsHandler = function( card ) {
	var self = this;
	var handlerWrapper = function ( event ) {
		if (self.cards.onclick)
			self.cards.onclick(event, card);   // card comes from parent function's scope, and is "closed over"
	};
	return handlerWrapper;   // return a function value - now that is pretty weird stuff!!
};


//********  V I E W  **********
Cardagain.view = { 
	// Paths to card images:
	CARD_PATH : "media/cards/",
	CARD_BACK : "b.gif",
	// milliseconds between animation steps
	ANIMATION_INTERVAL : 200,
};

Cardagain.view.init = function() {
};

/**
 * Clear all cards from the "card table"
 */
Cardagain.view.clearCards = function() {
	Cardagain.controls.initCards();
};

/** 
 * Update all elements on the user interface to match state of model.
 */
Cardagain.view.updateUI = function() {
	Cardagain.controls.apply( this.displayCard );
};

/**
 * deal a Card onto the "card table" on the User Inteface.
 * @param {Object} card - an object representing a card. Must have an isFaceUp property and a toString() method.
 */
Cardagain.view.dealCard = function(card) {
	var cardControl = Cardagain.controls.addCard(card);
	if (cardControl){ 
		this.displayCard(cardControl, true);  // display the card "hidden", until we...
		// Run a small animation to simulate taking the card off the deck.
		this.animateCard(cardControl.imgEl);
	}
};

// private: for internal use only.
Cardagain.view.displayCard = function(cardControl, hidden) {
	if (cardControl && cardControl.card) {
		var card = cardControl.card;
		var cardFile = card.isFaceUp ? card.toString() + ".gif" : Cardagain.view.CARD_BACK;
		var imgURL = Cardagain.view.CARD_PATH + cardFile;
		
		cardControl.imgEl.src = imgURL;
		cardControl.imgEl.alt = card.toString();
		cardControl.imgEl.style.visibility = hidden ? "hidden" : "visible";
	}
};

//****** A N I M A T I O N ********
// private: for internal use only
// Animate the dealing of a card from the deck to the destination.
// When the animation is complete, the destination element is made "visible".
Cardagain.view.animateCard = function( destination ) {
	var animation_steps = 10;  // number of animation steps - larger value, slower animation.
	// STEP 1: figure out where we are going and how to get there from the deck.
	var dealCard = document.getElementById("deal-card");
	var startLocation = this.getPosition( dealCard );
	var endLocation = this.getPosition( destination );
	var vector = { 
		x: (endLocation.x-startLocation.x) / animation_steps,
		y: (endLocation.y-startLocation.y) / animation_steps, 
	};
	
	// Step 2: Clone the card image and position it right over the deck.
	var element = dealCard.cloneNode(true);
	var pos = {
		left: startLocation.x,
		top : startLocation.y,
	};
	element.style.position = "absolute";
    element.style.left = pos.left+'px';
    element.style.top  = pos.top+'px';
	document.body.appendChild(element);	
    
    // Finally: run the animaiton...
	requestAnimationFrame( animationStep );

	function animationStep( ) {
		if (animation_steps > 0) {
			pos.left += vector.x;
			pos.top += vector.y;
			element.style.left = pos.left + "px";
			element.style.top = pos.top + "px";
			animation_steps--;
			requestAnimationFrame( animationStep );
		}
		else {
			// end of animation: remove the animated element and reveal the actual destination element
			document.body.removeChild(element);
			destination.style.visibility = "visible";
	
		}
	}
};

// private: for internal use only
// Compute absolute positions of elements.   From: http://www.kirupa.com/html5/get_element_position_using_javascript.htm
Cardagain.view.getPosition = function (element) {
    var xPos = 0;
    var yPos = 0;
    while(element) {
        xPos += (element.offsetLeft - element.scrollLeft + element.clientLeft);
        yPos += (element.offsetTop - element.scrollTop + element.clientTop);
        element = element.offsetParent;
    }
    return { x: xPos, y: yPos };
};
