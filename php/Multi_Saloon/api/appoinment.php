<?php

include("connection.php");

//$sid = $_POST['id'];
$shop_id=$_POST['shop_id'];
$type = $_POST['service'];
$amount = $_POST['amount'];
$time = $_POST['time'];
$date = $_POST['appointmentDate'];



$sql ="INSERT INTO appoinment (shop_id,service,amount,time,date) VALUES ('$shop_id','$type','$amount','$time','$date')";


if(mysqli_query($con,$sql)){
	
	echo "success";
}
else{
	
	echo "failed";
}


?>