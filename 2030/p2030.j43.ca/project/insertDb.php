<?php
    // Create connection
    $conn = new mysqli('j43.ca', 'p2030_p2030', '12345', 'p2030_p2030');
    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

// prepare and bind
$stmt = $conn->prepare("INSERT INTO property (address, bedroom, bathroom, type, pet_friendly, price, img_path) 
  VALUES (?, ?, ?, ?, ?, ?, ?)");
$stmt->bind_param("sssssss", $adress, $bedroom, $bathroom, $type, $pet, $price, $img);

// set parameters and execute
$adress = $_POST["address"];
$bedroom = $_POST["bedroom"];
$bathroom = $_POST["bathroom"];
$type = $_POST["type"];
$pet = $_POST["pet"];
$price = $_POST["price"];
$img = $_POST["img"];
$stmt->execute();

echo "New records created successfully";

$stmt->close();
$conn->close();
?>
