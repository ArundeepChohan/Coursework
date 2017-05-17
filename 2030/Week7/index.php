<html>
    <head>
         <style>
            table, tr, td, th, div { border: 1px dashed saddlebrown; }
             textarea , div { width: 300px ; height: 200px; }
        </style>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script>
            function ajaxWay() {
       
               // syntax: $.post(URL,data,callback);
               $.post("dbConnect4.php",
                    {
                        host: $("#host").val(),
                        name: $("#login").val(),
                        pwd: $("#pwd").val(),
                        db: $("#db").val(),
                        query: "Select country_id, country from country "
                    }
                    , display
                );
             
            }
            
            function display(dataFromtheServer) {
                $("#result tbody > tr").remove();
                $("#result tbody").append(dataFromtheServer);
            }
        </script>
    </head>
    <body>
        Host : <input type="text" id="host"><p></p>
        Login : <input type="text" id="login"><p></p>
        Password : <input type="password" id="pwd"><p></p>
        Database : <input type="text" id="db"><p></p>
        <button onclick="ajaxWay()">Query</button><p></p>
        <table id="result">
            <thead>
                <th>Country ID</th><th>Country Name</th>
            </thead>
            <tbody>
            </tbody>
        </table>
    </body> 
</html>
