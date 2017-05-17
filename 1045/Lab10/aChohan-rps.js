
function getUserThrow()
{
	var input;
	do
	{
		input = prompt("Do you choose rock, paper or scissors?");
	}
	while(input!=="rock"&&input!=="paper"&&input!=="scissors")
	return input;
}
function getComputerThrow()
{
	var compChoice=Math.random();
	if (compChoice < 0.34) 
	{
		return "rock";
	} 
	else if(compChoice <= 0.67) 
	{
		return "paper";
	}
	else 
	{
		return "scissors";
	}
}

function compare(choice1, choice2) 
{
    
    if(choice1 === choice2)
    {
        return "The result is a tie!";
    }
    else if(choice1 === "rock")
    {

        if(choice2 === "scissors") 
        {
            return "rock wins";
        }
        else
        {
            return "paper wins";
        }
    }
    else if(choice1 === "paper") 
    {
        if(choice2 === "scissors") 
        {
            return "scissors win";
        }
        else 
        {
            return "paper wins";
        }
    }
     else if(choice1 === "scissors") 
    {
        if(choice2 === "paper") 
        {
            return "scissors win";
        }
        else 
        {
            return "rock wins";
        }
    }
}

function reportResult(choice1,choice2)
{
	if(choice1 === choice2)
    {
        return "Tie!";
    }
	else if ((choice1 === "rock"&&choice2==="scissors")||(choice1 ==="paper"&&choice2 ==="rock")||(choice1 === "scissors" && choice2==="paper"))
	{
		return "You win!";
	}
	else
	{
		return "You lose!";
	}
}
function playOneRound()
{
	var userChoice,computerChoice,playAnother,result,win=0,lose=0,tie=0;
	do
	{
		userChoice = getUserThrow();
		computerChoice = getComputerThrow();
		console.log("User: " + userChoice);
		console.log("Computer: " + computerChoice);
		
		console.log(compare(userChoice,computerChoice));
		result=reportResult(userChoice,computerChoice);
		if(result==="You win!")
		{
			win+=1;
		}
		else if(result ==="Tie!")
		{
			tie+=1;
		}
		else
		{
			lose+=1;
		}
		console.log(result);
		playAnother = prompt("Would you like to play another round?");
	}
	while(playAnother === "yes")
		
	console.log("Game over");
	console.log("Your score: " + win+" wins, " +lose+ " loses, "+tie+ " ties.");
}
playOneRound();
