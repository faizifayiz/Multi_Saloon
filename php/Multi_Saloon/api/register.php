<?php

include("connection.php");

$name = $_POST['name'];
$email = $_POST['email'];
$password = $_POST['password'];
$phone = $_POST['phone'];
$gender = $_POST['gender'];


$sql ="INSERT INTO register (name,email,password,phone,gender) VALUES ('$name','$email','$password','$phone','$gender')";

if(mysqli_query($con,$sql)){
	
	echo "success";
}
else{
	
	echo "failed";
}


?>