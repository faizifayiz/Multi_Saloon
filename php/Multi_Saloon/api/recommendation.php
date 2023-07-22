<?php

include("connection.php");
set_time_limit(0);
error_reporting(0);

//$lName = $_REQUEST['lName'];
//$sid = $_REQUEST['uid	'];

$shop_name = $_REQUEST['shop_name'];

//echo "location Name".$lName;


	$myfile = fopen("input.txt", "w") or die("Unable to open file!");
	//$txt = $_REQUEST['id'];
	fwrite($myfile, $lName);
	fclose($myfile);
	
	$python = `python recom_final.py`;
	//echo "<pre>".$python."</pre>";

?>

	
<!DOCTYPE html>
<html lang="en">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>Recommended Salons</h2>
  
  <?php
	$myfile = fopen("result.txt", "r") or die("Unable to open file!");
	$a=fread($myfile,filesize("result.txt"));
	fclose($myfile);
	//echo $a;

	$bb=trim($a, "[");
	$bb=trim($bb, "]");
	$b=explode(",",$bb);
	$i = 0;
	foreach ($b as $value) {

	//echo $value."<br>";

	$x= $x."id=$value OR ";

	//echo $x;
	}

	$sel1="select * from saloon_tbl  where $x id='1000000'";
	//echo $sel1;
	$res1=mysqli_query($con,$sel1);
	while($row1=mysqli_fetch_array($res1))
	{
	?>
	
  <div class="card" style="width:350px">
    <img class="card-img-top" src="../saloon/uploads/<?php echo $row1['image']; ?>" alt="Card image" style="width:100%">
	<?php echo $row1['shop_name']; ?>
<br>
	<?php echo $row1['place']; ?><br>
	
	<?php echo $row1['phone']; ?>
	
    <div class="card-body" style="background-color: lavenderblush;">
     
    </div>
  </div>
  <br>
  
  <?php
	}
	?>
  
  
  
</div>

</body>
</html>