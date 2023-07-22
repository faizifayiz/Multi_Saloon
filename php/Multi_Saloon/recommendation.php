<?php
include("header.php");
include("connection.php");
//error_reporting(0);
$uid=$_REQUEST['sid'];
//echo $uid;

?>


 <center><h3 style="background-color:#120606;color:#fff;padding:15px"><b>Recommendation <b></h3></center>
 
    
    
                              <?php

                                $sel="select * from saloon_tbl where shop_id=$uid"; 
                                $res=mysqli_query($con,$sel);
                                while($row=mysqli_fetch_array($res))
                                {
									$res1=mysqli_query($con,"SELECT * FROM register WHERE id= '$row[u_id]'");
									$row1=mysqli_fetch_array($res1);
									
									$res2=mysqli_query($con,"SELECT * FROM tbl_order WHERE station_id= '$row[station_id]'");
									$row2=mysqli_fetch_array($res2);
									
									$res3=mysqli_query($con,"SELECT * FROM fuel_station WHERE id= '$row[station_id]'");
									$row3=mysqli_fetch_array($res3);
									
									
                        
                            ?>
                            <div class="well" style="margin: 20px; margin-bottom: -15px;" >
                                

                               <label style="margin-right:20px">User Name : </label><?php echo $row1['name']; ?><br>
                               <label style="margin-right:20px">Amount    : </label><?php echo $row['amount']; ?><br>
							   <label style="margin-right:20px">Fuel type : </label><?php echo $row2['fuel']; ?><br>
                               <label style="margin-right:20px">Fuel Station: </label><?php echo $row3['station_name']; ?><br>
                               <label style="margin-right:20px">Date      : </label><?php echo $row2['date']; ?><br>
                            
                                
                      
                             </div> 
                             <br> <br>


                            <?php
                                }
                            ?>