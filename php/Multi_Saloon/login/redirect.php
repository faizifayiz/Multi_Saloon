<?php
session_start();
include('../db/connectionI.php');
//$db_name="music"; // Database name 
$tbl_name="employee"; // Table name 

// Connect to server and select databse.


// username and password sent from form 
$myusername=$_POST['UserName']; 
$mypassword=$_POST['Password']; 


if(isset($_POST['login']))
{
//

if($myusername=="admin" and $mypassword="admin")
{
		$_SESSION['type']="admin";
header("location:../dashboard/dashboard.php");
}
elseif($_POST['type']=='Owner')
{
	
	
		$result = mysqli_query($con,"SELECT * FROM saloon_tbl WHERE email='$myusername' and password='$mypassword'");
		$cc= mysqli_num_rows($result);
		$r= mysqli_fetch_array($result);
		
		if($cc==1)
		{	
			$_SESSION['type']="Owner";
			$_SESSION['uid']=$r['id'];
			header("location:../dashboard/dashboard.php");
		}else{
header("location:login.php?a=error");
}
}

else
	{
		header("location:login.php?a=error");
	}
}

?>
 
 



