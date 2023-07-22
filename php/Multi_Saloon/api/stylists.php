<?php

include("connection.php");

//$uid=$_REQUEST['uid'];

//$uid="2";

$sql = "Select * from stylists ";
$result = mysqli_query($con,$sql);

if(mysqli_num_rows($result) > 0){

	while($row = mysqli_fetch_assoc($result)){

	    $ress = mysqli_query($con,"SELECT * FROM saloon_tbl WHERE id = '$row[shop_id]'");
		$roww = mysqli_fetch_assoc($ress);

       

		$data['data'][] = array('id'=>$row['id'],'name' => $row['name'], 'specialization' => $row['specialization'],'shop_name' => $roww['shop_name'],'place' => $roww['place']);

		
	}
	echo json_encode($data);
}

else{
	echo"failed";
}

?>