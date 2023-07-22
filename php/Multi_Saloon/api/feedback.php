<?php

include("connection.php");

$uid = $_POST['uid'];
$shopname = $_POST['shop_name'];
$feedback = $_POST['feedback'];


$sql ="INSERT INTO feedback (user_id,feedback,shop_name) VALUES ('$uid','$feedback','$shopname')";

if(mysqli_query($con,$sql)){
	
	echo"success";
}
else{
	
	echo"failed";
}


?>