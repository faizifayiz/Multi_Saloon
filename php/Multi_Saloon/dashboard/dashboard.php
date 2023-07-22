<?php
error_reporting(0);
$status=$_REQUEST['status'];
if ($status == "logout")
{
    session_start();
    session_unset();
    session_destroy();
	header("location:../login/login.php");
}
?>
<?php
include("../common/menu.php");
	
?>


    <style>
#right
{
	
float:right;	
color:#333;
font-size:12px;
}
</style>

<style>
#right
{
	
float:right;	
color:#333;
font-size:12px;
}
.userd
{
color:#333;	
}
.red
{
background:#FFECF4;
padding:10px;	
}


#right
{
	
float:right;	
color:#333;
font-size:12px;
}
.userd
{
color:#333;	
}
.red
{
background:#F36;
padding:10px;	
}
.table
{
margin-bottom:10px;
background:#E6F4FF;	
}
.sep
{
height:30px;
background:#666;	
}
</style>
       


        <div class="content" >
            <div class="container-fluid">
             
                    <div class="col-md-12" style="opacity:90%">
                        
                            <div class="header">
                                                             
                            </div>
                            <div class="content all-icons">
                                <div class="row" style=" /*background-image: url(Bugs.jpg);*/ ">
								
								
								<?php
								if($_SESSION['type']=='admin')
								{
								?>
								
								<div class="font-icon-list col-lg-3 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../user_tbl/select.php">    <div class="font-icon-detail" ><i class="pe-7s-user"></i>
                                    <b>  <input type="text" value="View Users" style="color:#000000; background-color:#FFF">
                                    </div></a>
                                  </div>
								
								<div class="font-icon-list col-lg-3 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../saloon/select.php">    <div class="font-icon-detail" ><i class="pe-7s-user"></i>
                                    <b>  <input type="text" value="View Shops" style="color:#000000; background-color:#FFF">
                                    </div></a>
                                  </div>
								  
								  <div class="font-icon-list col-lg-3 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../saloons/form.php">    <div class="font-icon-detail" ><i class="pe-7s-user"></i>
                                    <b>  <input type="text" value="Add Shops" style="color:#000000; background-color:#FFF">
                                    </div></a>
                                  </div>
								  
								   <div class="font-icon-list col-lg-3 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../feedback/select.php">    <div class="font-icon-detail" ><i class="pe-7s-user"></i>
                                    <b>  <input type="text" value="Feedback" style="color:#000000; background-color:#FFF">
                                    </div></a>
                                  </div>
								  
							 
						
								<?php
								}elseif($_SESSION['type']=='Owner')
								{
								?>
                                           
                              
                                <div class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../appointment_tbl/select.php">    <div class="font-icon-detail" ><i class="pe-7s-user"></i>
                                    <b>  <input type="text" value="APPONTMENTS" style="color:#000000; background-color:#FFF">
                                    </div></a>
                                  </div>
                                   <div class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../package/select.php">    <div class="font-icon-detail"><i class="pe-7s-user"></i>
                                      <input type="text" value="PACKAGES" style="color:#000000"></b>
                                    </div></a>
                                  </div>
								  
								  <div class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../feedback/select.php">    <div class="font-icon-detail"><i class="pe-7s-ribbon"></i>
                                      <b ><input type="text" value="FEEDBACKS" style="color:#000000"></b>
                                    </div></a>
                                  </div>
								  
								  
								 <div class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../services/select.php">    <div class="font-icon-detail"><i class="pe-7s-ribbon"></i>
                                      <b ><input type="text" value="SERVICES" style="color:#000000"></b>
                                    </div></a>
                                  </div>
								  
								   <div class="font-icon-list col-lg-2 col-md-3 col-sm-4 col-xs-6 col-xs-6">
                                <a href="../stylists/select.php">    <div class="font-icon-detail"><i class="pe-7s-ribbon"></i>
                                      <b ><input type="text" value="STYLISTS" style="color:#000000"></b>
                                    </div></a>
                                  </div>

								 <?php
								}
								?>

                                  

                                </div>

                            </div>
                        </div>
                    </div>

                </div>
                
            </div>
        </div>
    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="../assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="../assets/js/bootstrap-checkbox-radio-switch.js"></script>

	<!--  Charts Plugin -->
	<script src="../assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="../assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="../assets/js/light-bootstrap-dashboard.js"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="../assets/js/demo.js"></script>

	

</html>
