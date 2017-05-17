<?php
$name = $_POST["name"];
$seat= $_POST["seat"];
$type = $_POST["type"];
$price= $_POST["price"];


$file = fopen("flight_100201711.txt", "w")or die(print_r(error_get_last(),true)); 
 
 fwrite($file, $name); 
 fwrite($file, $seat); 
 fwrite($file, $type); 
 fwrite($file, $price); 
 fclose($file); 

?>