
#!/bin/bash

  getName () {
	echo `grep -e "^Name:" $1`
}
   getState () {
	 echo `grep -e "^State:" $1`
}
  getPid () {
	echo `grep -e "^Pid:" $1`
}
printToConsole() {
	FILES="/proc/[0-9]*/status"
	for f in $FILES
	do
		 getName $f
		 getState $f
		 getPid $f
		 echo "---------------"
	done
}
printToConsole
exit 0