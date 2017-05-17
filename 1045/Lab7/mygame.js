/**
This JavaScript file is part of the Lab7 index.html
It plays a story while allowing the user to make choices using if/else statements.
**/
// Check if the user is ready to play!
confirm('Ready to unbark on your journey!');
var name = prompt("What's your name");

//General Storyline of the character
console.log(name + ' awakens in a bar amongst burly drunken men on the floor.');
console.log('A man bursts in the bar and yells that everything is on him.');
var userAnswer = prompt("Do you want a drink?(yes/other)");

//1st choice for the user
if(userAnswer === 'yes')
{
    console.log('You stagger around and bump into the man and he talks about how he slayed a dragon');
}
else
{
    console.log('The man approaches you and talks about how he just slayed a dragon.');
}

var response = prompt("What do you think of this?(Awesome,other)");
//2nd choice for the user
if(response === 'Awesome')
{
    console.log('You talk all night with the man and drift slowly back to sleep.');
}
else
{
    console.log('You fight the man and he Fus Ro Dah you into the next true Nord King.');
}
//Ending line of the story
console.log('Have a good sleep');