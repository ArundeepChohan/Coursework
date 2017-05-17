/**********************************************************
 *riseOfGallantMon Model : model
 *    Implements the model for the riseOfGallantMon demo
 **********************************************************/
 /*
 First things first is to put all the global variables then I would need to keep track off each portion of this project.
 */
var	GOLD = 0;
var CLICKDMG = 1;

var enemyImages=["enemy1.png","enemy2.png","enemy3.png","enemy4.png","enemy5.png"];
var equipmentImages=["claws.png","axes.png","lance.png"];
var backgroundImages=["digiMonBg.png","fryingPan.jpg"];

var hp=[10,100,500,1000,5000];
var goldAwarded=[5,10,15,20,25];
var timeAllocated=[20,20,20,30,30];

var CURRENTHP =hp[0];
var CURRENTMONSTER="";
var CURRENTVALUE=0;

var countdown;
var countdown_number;

var ENDTIME=0;
var SCORES=[];

/* More sounds https://www.youtube.com/watch?v=qliRztEtIbM ,https://www.youtube.com/watch?v=CaxJn64yXM8 ,https://www.youtube.com/watch?v=zE92ijITcEY , https://www.youtube.com/watch?v=gGcANh24QIA bg.src="bg2.mp3";bg.src="bg3.mp3";bg.src="bg4.mp3";bg.src="boss.mp3";

*/
var bg= new Audio();
bg.src="bg4.mp3";
bg.volume = 0.25;

/*
This will change enemy to the enemy we have selected CURRENTHP,CURRENTVALUE and start the timer.
*/
function enemyClickListener(event) {
	
	var element = event.target;
	//Sets currentmonster values
	CURRENTVALUE = element.value;
	CURRENTMONSTER=element.id;
	CURRENTHP=hp[CURRENTVALUE];

	//Some audio	
	bg.play();
	
	//Sets current monster image on display.
	document.getElementById('enemy-image').src = enemyImages[CURRENTVALUE];
	
	//Makes sure you can't change enemies during the timer.
	disableEnemies();
	
	//Runs a timer in the background.
	countdown_init(CURRENTVALUE);
	
	//Updates the view
	upDateBg();
	upDateHp();
}

/* 
Got this from http://www.electrictoolbox.com/using-settimeout-javascript/ basically switched countdown_number = timeAllocated[value] ; in order to make it work for any timer associated with any enemy.
 */
function countdown_init(value) {
	
    countdown_number = timeAllocated[value];
    countdown_trigger();
}

/*
This basically countdowns from a value associated with each enemy.
*/
function countdown_trigger() {
	console.log("called")

	if(countdown_number<=0)
	{
		//Say repeat when every countdown for audio
		bg.pause();
		var r = confirm("Do you want to restart this level?");
		if (r == true) {
			CURRENTHP = hp[CURRENTVALUE];
			upDateHp();
			countdown_init(CURRENTVALUE);
		} 
		else
		{
			enableEnemies();
		}
	}
	else {
		if(countdown_number > 0) {
			ENDTIME+=1;
			countdown_number--;
			document.getElementById('countdown_text').innerHTML = countdown_number;
			if(countdown_number >= 0) {
				countdown = setTimeout('countdown_trigger()', 1000);
			}
		}
	}
} 

/*
This is basically to update CLICKDMG based of the value/10 of the equipment button and decriments based off cost for GOLD.
*/
function equipmentClickLIstener(event)
{
	var element=event.target;
	CLICKDMG+=element.value/10;
	console.log(CLICKDMG);
	GOLD-=element.value;
	console.log(GOLD);

	//Updates the view
	upDateClick();
	upDateGold();
	upDateBuy();
}

/*
Initializing all the click events and creating the default view.
*/
function startApp(event) {
	console.log("riseOfGallantmon App started...");
	
	// Here I made all my buttons for my enemytypes
	var button1 = document.getElementById("enemyType1");
	button1.onclick = enemyClickListener;
	var button2 = document.getElementById("enemyType2");
	button2.onclick = enemyClickListener;
	var button3 = document.getElementById("enemyType3");
	button3.onclick = enemyClickListener;
	var button4 = document.getElementById("enemyType4");
	button4.onclick = enemyClickListener;
	var button5 = document.getElementById("enemyType5");
	button5.onclick = enemyClickListener;
	
	//Here are all the buttons for the equipment
	
	var button6 = document.getElementById("myFirstButton");
	button6.disabled;
	button6.onclick = equipmentClickLIstener;
	
	var button7 = document.getElementById("mySecondButton");
	button7.disabled;
	button7.onclick = equipmentClickLIstener;
	
	var button8 = document.getElementById("myThirdButton");
	button8.disabled;
	button8.onclick = equipmentClickLIstener;
	
	
	//Here are all the events that handle the clicking on the enemy.
	document.getElementById("enemy-image").addEventListener("click", getHp);
	
	//Make the default view.
	upDateGold();
	upDateClick();
	upDateEquipment();
	upDateHp();
	upDateBuy();
	upDateBg();
	
};

/*
Was thinking later on might want to do a stage switch and switch the background accordingly.
*/
function upDateBg()
{
/*
	if(CURRENTMONSTER ==="enemyType5")
	{
		 document.getElementById("wrapper").style.backgroundImage = "url('fryingPan.jpg')";
	}
	else
	{
		
	}
	*/
}

/*
Setting the display to the current gold you have.
*/
function upDateGold() {
	document.getElementById('gold').innerHTML = "GOLD : "+GOLD;
}
/*
Setting the display to the current clickdmg you have.
*/
function upDateClick() {
	document.getElementById('clickDmg').innerHTML = CLICKDMG;
}

/*
Setting the display of the equipment images.
*/
function upDateEquipment() {
	
	document.getElementById('claw').src = equipmentImages[0];
	document.getElementById('axe').src = equipmentImages[1];
	document.getElementById('lance').src=equipmentImages[2];
}

/*
Enabling/Disabling the ability to click on buttons by the current gold you have.
*/
function upDateBuy()
{
	if(GOLD >0)
	{
		if(GOLD>=document.getElementById("myFirstButton").value)
		{
			document.getElementById("myFirstButton").disabled = false;
		}
		else
		{
			document.getElementById("myFirstButton").disabled = true;
		}
		
		if(GOLD>=document.getElementById("mySecondButton").value)
		{
			document.getElementById("mySecondButton").disabled = false;
		}
		else
		{
			document.getElementById("mySecondButton").disabled = true;
		}
		
		if(GOLD>=document.getElementById("myThirdButton").value)
		{
			document.getElementById("myThirdButton").disabled = false;
		}
		else
		{
			document.getElementById("myThirdButton").disabled = true;
		}
	}
	else
	{
		document.getElementById("myFirstButton").disabled = true;
		document.getElementById("mySecondButton").disabled = true;
		document.getElementById("myThirdButton").disabled = true;
		
	}
}

/*
Setting the display to the current hp you have.
*/
function upDateHp()
{
	document.getElementById("hp").innerHTML = "Hp&nbsp;:&nbsp;"+CURRENTHP;
}

/*
This function will be getting the hp, resetting the hp and incrementing GOLD for the value associated with the monster.
*/
function getHp() {
		
	if((CURRENTHP <=0)  )
	{
		if(countdown_number>0)
		{
			GOLD+=goldAwarded[CURRENTVALUE];
		}
		//These two need to change according to image
		CURRENTHP = hp[CURRENTVALUE];
		if(CURRENTMONSTER==="enemyType5")
		{
			
			endGame();
		}
	}
	else
	{
		CURRENTHP -=CLICKDMG;
	}
	//Updates the view
	upDateHp();
	upDateClick();
	upDateGold();
	upDateBuy();
}

/*
Disables the ability to click on enemies after user selects one.
*/
function disableEnemies()
{
	document.getElementById("enemyType1").disabled=true;
	document.getElementById("enemyType2").disabled=true;
	document.getElementById("enemyType3").disabled=true;
	document.getElementById("enemyType4").disabled=true;
	document.getElementById("enemyType5").disabled=true;
	
}

/*
Enables the ability to click on enemies after timer runs out and after the user prompt for restarting the level
*/
function enableEnemies()
{
	/* I wanted to do this to select all the enemies and disable them for growth of the program in case I needed more enemies.
	var enemyList =document.querySelectorAll("enemyType");
	for(var i =0;i<enemyList.length;i++)
	{
		enemyList[i].button.disabled=false;
		
	}
	*/
	
	document.getElementById("enemyType1").disabled=false;
	document.getElementById("enemyType2").disabled=false;
	document.getElementById("enemyType3").disabled=false;
	document.getElementById("enemyType4").disabled=false;
	document.getElementById("enemyType5").disabled=false; 
}

/*
So it displays you have won the game and it then pops up a scoreboard of all the attempts you have made so far.
*/
function endGame()
{
	alert("You have won in "+ENDTIME+" seconds");
	//Sorts all the scores you have in your array.
	manageScores();
	document.getElementById("popupBoxContent").innerHTML=message();
	document.getElementById("popup").style.display = "block";
	//After 5 seconds the score disappears because the popup display will alternate between display:none and display:block.
	setTimeout( function() { document.getElementById("popup").style.display="none";}, 5000);
	//Resets default scores.
	resetScores();
}

/*
Changes values to what they were at the start.
*/
function resetScores()
{
	GOLD = 0;
	CLICKDMG = 1;
	ENDTIME = 0;
}

/*
Basically only shows 10 scores and sorts them
*/
function manageScores()
{
	SCORES.push(ENDTIME);
	SCORES.sort();
	if(SCORES.length >10)
	{
		SCORES.pop();
	}
}

/* 
Constructs a message based upon the array on a new line each.
*/
function message()
{
	var boardMessage="";
	for(var i =0;i<SCORES.length;i++)
	{
		boardMessage+=""+(i+1)+".Score: "+SCORES[i]+" seconds " +'<br>';
	}
	return boardMessage;
}
// Here's where it all begins - when the window's load event fires, it will call the startApp function declared above...
window.onload = startApp;