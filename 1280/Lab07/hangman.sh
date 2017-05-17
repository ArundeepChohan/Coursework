#!/bin/bash
hangman =( b e d)
hangmansize=${#hangman[@]}
answer =()
for (i =0 ;i< hangmansize;i++)
do
answer[$i]="_"
done
win = "false";
 
while[ "$win" == "false" ]
do
read -n 1 c input;
guesses+=($input)
for (i =0 ;i< hangmansize;i++)
do
{
if("${hangman[$i]}" == "$input" )
then 
answer[$i]=input
fi
}
echo ${answer[@]}	
	echo ${guesses[@]}
done
diff=$(diff <(printf "%s\n" "${answer[@]}") <(printf "%s\n" "${hangman[@]}"))

if [[ -z "$diff" ]]; then
    $win = "true"
else
    $win = "false"
fi
done
echo "You win"
exit 0