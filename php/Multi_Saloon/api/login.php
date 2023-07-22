 <?php
include("connection.php");

$email=$_POST['email'];
$password=$_POST['password'];

//$email="fz@gmail.com";
//$password="777";

$sql ="SELECT * FROM register where email='$email' and password='$password'";

//echo $sql;

$result = mysqli_query($con,$sql);


if(mysqli_num_rows($result)>0){
	
	$row=mysqli_fetch_assoc($result);	
	$data[]=array('id'=> $row['id'],'name'=> $row['name']);  
	
	echo json_encode($data);

}
else{
	echo "failed";
}


?>