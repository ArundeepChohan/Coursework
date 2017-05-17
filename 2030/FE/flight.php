<?php
 $array = $_POST["saveToFile"];
 
 
 $arrlength = count($array);

$file = fopen("flight.txt", "w")or die(print_r(error_get_last(),true)); 

for($x = 0; $x < $arrlength; $x++) {
    fwrite($file, $array[$x]); 
}

fclose($file); 

?>