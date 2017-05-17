<?php
    $bedroomNum = $_POST["bedroomPostp"];
    $bathroomNum = $_POST["bathroomPostp"];
    $typeNum = $_POST["typePostp"];
    $pet_friendlyNum = $_POST["petPostp"];
   

	
    // Create connection
    $conn = mysqli_connect('j43.ca', 'p2030_p2030', '12345' , 'p2030_p2030');
    // Check connection
   if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }

    $sql = "SELECT * FROM property where bedroom > "  . $bedroomNum . " and bathroom > "  . $bathroomNum . " and type = '"  . $typeNum . "' and pet_friendly = '"  . $pet_friendlyNum . "'";
    $result = mysqli_query($conn, $sql) or die("Query: ($sql) [problem]");
    $fields = mysqli_num_fields($result);

    if (mysqli_num_rows($result) > 0) {

	   while($row = mysqli_fetch_row($result)) {
		display("<div class='".img."'>","\n");
            for ($i=0; $i < $fields; $i+=7) {

		echo "<img src='".$row[$i+6]."'>";

  		display("<p>",Address .': '. $row[$i]."</p>");

		display("<p>",Bedroom .': '. $row[$i+1] . "</p>");
		display("<p>",Bathroom .': '. $row[$i+2] . "</p>");
		display("<p>",$row[$i+3] . "</p>");

		display("<p>",Pet .': '. $row[$i+4] . "</p>");
  		display("<p>",Price .': '. $row[$i+5] . "</p>");


	

	
            }
		display("</div>","\n");
	}
    } else {
        echo "0 results";
    }

    mysqli_close($conn);
    
    // ==========================================
    function display($tag , $value) {
        echo $tag . $value ;
    }
?>