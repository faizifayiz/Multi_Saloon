<?php

include("connection.php");

$uid = $_POST['uid'];
$sid = $_POST['sid'];
$rating = $_POST['rating'];


$sql = "INSERT INTO rating_tbl(uid,shop_id,rating) VALUES ('$uid','$sid','$rating')";
 //echo $sql;

if(mysqli_query($con,$sql))
{
	echo"success";
}
else{
	echo"failed";
}

?>