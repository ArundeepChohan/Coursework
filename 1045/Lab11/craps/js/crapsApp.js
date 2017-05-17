/**********************************************************
 * Craps App : app / model
 *    Implements the app and model for the game of Craps
 *
 *
 **********************************************************/
 var point;

 function rollDice()
 {
	 var die1=rollDie();
	 var die2=rollDie();
	 Craps.view.roll(die1,die2);
	 return die1+die2;
 }
 function isGameOver(roll,point)
 {
	 
	
 }
 function getMessage(roll,point){
	 if(isWinner(roll,point))
	{
		point=roll;
		 console.log("Hi");
	}
	else if(isLoser(roll,point))
	{
		point=roll;
 console.log("Hi");
	}
	
	else
	{
	 point = roll;	
	 do 
	 {
		 roll = rollDice();
	 }
	 while(roll!=7 || roll!=point)
	}
 console.log("Hi");
		
	 }
	
 function isWinner(roll,point)
 {
 if(roll == 7|| roll ==11)
	{
		return true;
	}
	return false;
 }
 function isLoser(roll,point)
 {
	if (roll ==2 ||roll ==3||roll==12)
	{
		return true;
	}
	return false;
 }
 function rollDie()
 {
	return Math.floor(Math.random()*6)+1;
 }
function rollClick()
{
	console.log("The roll click");
	var roll =rollDice();
	//getMessage(roll,point);
	
	Craps.view.sendMessage("Your roll is: "+ roll);
}
function newGameClick()
{
	console.log("The new game click");
	point= undefined;
}
function startApp() {
	Craps.view.init("Welcome to Craps - press Roll to get started");
	Craps.controls.init();
	
	Craps.controls.newGameButton.onclick = newGameClick;
	Craps.controls.rollButton.onclick = rollClick;
};

/**
 * This is a placeholder - you need to write the functions to replace this code with something else
 * However, you may want to keep this code around - it shows examples of how to use the Craps GUI
 */
function replaceThisCode( ) {
	Craps.view.sendMessage("You pressed a button");
	var randomDie=Math.floor(Math.random()*6)+1;
	Craps.view.roll(randomDie, randomDie);
	if (Craps.controls.rollButton.disabled) {
		Craps.controls.rollButton.disabled = false;
	}
	else {
		Craps.controls.rollButton.disabled = true;		
	}
	
}

// Here's where it all begins - when the window's load event fires, it will call the startApp function declared above...
window.onload = startApp;
//replaceThisCode();
