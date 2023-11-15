<?php
$servername = "localhost";
$username = "root";
$password = "";
$database_name = "project";
$port = 3308;

// Create MySQL connection from PHP to MySQL server
$connection = new mysqli($servername, $username, $password, $database_name, $port);

// Check connection
if ($connection->connect_error) {
    die("MySQL connection failed: " . $connection->connect_error);
}

// Check if ID and Student_id parameters are set in the URL
if (isset($_GET["ID"], $_GET["Student_id"])) {
    // $ID = $_GET["ID"]; // get ID value from HTTP GET
    // $Student_id = $_GET["Student_id"]; // get Student_id value from HTTP GET
    $ID = $_GET["ID"]; // get ID value from HTTP GET
    $Student_id = $_GET["Student_id"]; // get Student_id value from HTTP GET

    // Insert data into the database
    $sql = "INSERT INTO fingerprintdata (ID, Student_id) VALUES ($ID, $Student_id)";

    if ($connection->query($sql) === TRUE) {
        echo "New record created successfully\n";
    } else {
        echo "Error: " . $sql . " => " . $connection->error . "\n";
    }
} else {
    echo "ID or Student_id is not set in the HTTP request\n";
}

// Display data from the table
$sql = "SELECT * FROM fingerprintdata";
$result = $connection->query($sql);

if ($result->num_rows > 0) {
    echo "Data from the 'fingerprintdata' table:\n";
    while ($row = $result->fetch_assoc()) {
        echo "ID: " . $row["ID"] . " - Student_id: " . $row["Student_id"] . "\n";
    }
} else {
    echo "No data in the 'fingerprintdata' table\n";
}

$connection->close();
?>
