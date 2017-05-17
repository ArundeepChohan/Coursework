<?php
    $servername = "j43.ca";
    $username = $_POST["name"];
    $password = $_POST["pwd"];
    $dbname = "p2030_p2030";

    // Create connection
    $conn = mysqli_connect($servername, 'p2030_p2030', '12345' , $dbname);
    // Check connection
   if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }

    $sql = "SELECT permissions FROM login where name='" . $username . "' and password = '" . $password . "'";
    $result = mysqli_query($conn, $sql) or die("Query: ($sql) [problem]");
    $fields = mysqli_num_fields($result);

    if (mysqli_num_rows($result) > 0) {

	        while($row = mysqli_fetch_row($result)) {
            for ($i=0; $i < $fields; $i++) {
                display($row[$i]);
            }
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