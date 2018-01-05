<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>

<html lang="en">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta charset="utf-8">
<title>Sailor - Bootstrap 3 corporate template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="Bootstrap 3 template for corporate business" />
<!-- css -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/cubeportfolio.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  
<!-- Theme skin -->
<link id="t-colors" href="skins/default.css" rel="stylesheet" />

	<!-- boxed bg -->
	<link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />

</head>
<body>


<div id="wrapper">
	<!-- start header -->
	<header>
			<div class="top">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<ul class="topleft-info">
								<li><i class="fa fa-phone"></i>
								</li>
							</ul>
						</div>
						<div class="col-md-6">
						<div id="sb-search" class="sb-search">
							<form>
								<input class="sb-search-input" placeholder="Enter your search term..." type="text" value="" name="search" id="search">
								<input class="sb-search-submit" type="submit" value="">
								<span class="sb-icon-search" title="Click to start searching"></span>
							</form>
						</div>
						</div>
						<div class="col-md-2">
							<ul class="topleft-info">
								<li>Hello <a href="#" data-toggle="modal" data-target="#logOut" style="color:green"><span class=" glyphicon glyphicon-user" style="color:green"></span></a><c:out value="${customer.personalInformation.name}" /></li>
								<!--li><a href="#" data-toggle="modal" data-target="#myModal" style="color:green"><span class="glyphicon glyphicon-log-in" style="color:green"></span> Login</a></li-->
							</ul>							
						</div>																
					</div>
				</div>
			</div>				        
	</header>
	<!-- end header -->	
	<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-md-8">			    
                <form action="entry" method="post" role="form" class="contactForm">
                   <!-- <input type="text" name="txt" placeholder="MyText"/> -->				   
					
					<!-- <> -->
					
					<table class="table table-striped">
						<thead>      						
    					</thead>
    					<tbody  style="text-align: left;">
    						<tr>
								<td></td>
								<td></td>
								<td>
									<b>Entery</b>
								</td>
								<td>
									<b>Date :</b>
								</td>
								<td>
									<b><input type="text" name="entryDate" class="datepicker" maxlength="0" size="12"></b>
								</td>
							</tr>
							<tr>
								<td>
								</td>
								<td>
									<b>Breakfast</b>
								</td>
								<td>
									<b>Lunch</b>
								</td>
								<td>
									<b>Dinner</b>
								</td>
								<td>
									<b>Extra</b>
								</td>
							</tr>
							<tr>
								<td>
									<b>New Entry :</b>
								</td>
								<td>
									<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
										<input type="checkbox" name="food1"  style="left:20px">
									</div>
								</td>
								<td>
									<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
										<input type="checkbox" name="food2"   style="left:20px">
									</div>
								</td>
								<td>
									<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
										<input type="checkbox" name="food3"  style="left:20px">
									</div>
								</td>								
								<td style="margin-bottom: 0px;margin-top: 0px;padding-bottom: 0px;padding-top: 0px;" width="15%" height="10px">
									<div class="form-group" style="margin-bottom: 0px;margin-top: 0px;padding-bottom: 0px;padding-top: 0px;">								
										<input type="text" name="extra" class="form-control" id="usr" style="width:90px">
									</div>
								</td>								
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>
									<input type="submit" name="submit" value="Submit"/>
								</td>
							</tr>
    					</tbody>
					</table>
										
					<table class="table table-striped" >
    					<thead>      						
    					</thead>
    					<tbody  style="text-align: left;">
    						<tr>
								<td>
									<b>Dues : </b>
								</td>									
								<td>
									<b><c:out value="${dues}" /></b>
								</td>
								<td>
									<b>Current :</b>
								</td>
								<td>
									<b><c:out value="${paid}" /></b>
								</td>
								<td>
									<input type="text" class="datepicker" maxlength="0" size="12">
								</td>
							</tr>
    					</tbody>
    				</table>
				   			
				   	<!-- <Data Table> -->
				   										
					<table class="table table-striped" >
    					<thead>
      						<tr>
        						<th style="text-align: left;width:15%">Date</th>
        						<th style="text-align: left;width:15%">Breakfast</th>
        						<th style="width:20%;text-align: left;width:15%;">Lunch</th>
								<th style="text-align: left;width:15%">Dinner</th>
								<th style="text-align: left;width=15%">Extra</th>
      						</tr>
    					</thead>
						<tbody>
							<c:forEach items="${list}" var="cust">
        						<tr>
									<td>
										<c:out value="${cust.customerFsMappingView.date}" />
									</td>
									<td>
										<c:if test="${cust.customerFsMappingView.isAvailability eq true}">										
											<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
												<input type="checkbox" value="" checked="checked" style="left:20px" disabled="disabled">
											</div>
										</c:if>
										<c:if test="${cust.customerFsMappingView.isAvailability eq false}">										
											<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
												<input type="checkbox" value="" style="left:20px">
											</div>
										</c:if>
									</td>
									<td>
										<c:if test="${cust.customerFsMappingView.isAvailability eq true}">
											<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
												<input type="checkbox" value="" checked="checked" style="left:20px" disabled="disabled">
											</div>
										</c:if>
										<c:if test="${cust.customerFsMappingView.isAvailability eq false}">
											<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
												<input type="checkbox" value="" style="left:20px">
											</div>
										</c:if>
									</td>
									<td>
										<c:if test="${cust.customerFsMappingView.isAvailability eq true}">
											<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
												<input type="checkbox" value="" checked="checked" style="left:20px" disabled="disabled">
											</div>
										</c:if>
										<c:if test="${cust.customerFsMappingView.isAvailability eq false}">
											<div class="checkbox" style="margin-bottom: 0px;margin-top: 0px;text-align: left;">
												<input type="checkbox" value="" style="left:20px">
											</div>
										</c:if>
									</td>
									<td style="margin-bottom: 0px;margin-top: 0px;padding-bottom: 0px;padding-top: 0px;" width="15%" height="10px">
										<div class="form-group" style="margin-bottom: 0px;margin-top: 0px;padding-bottom: 0px;padding-top: 0px;">								
											<input type="text" class="form-control" id="usr" style="width:90px">
										</div>
									</td>
      							</tr>	      							
      						</c:forEach> 
      						<tr>
								<td></td>
								<td></td>
								<td></td>
								<td>
									<b>Current :</b>
								</td>
								<td>
									<b><c:out value="${paid}" /></b>
								</td>
							</tr>
							
      					</tbody>
     				</table>    				
                </form>         
			</div>
		</div>
	</div>	
	<div class="container">
		<ul class="pager">
			<li class="previous"><a href="#">Previous</a></li>
			<li class="next"><a href="AfterLogin2.html">Next</a></li>
		</ul>
	</div>

	</section>
	
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.appear.js"></script>
<script src="js/stellar.js"></script>
<script src="js/classie.js"></script>
<script src="js/uisearch.js"></script>
<script src="js/jquery.cubeportfolio.min.js"></script>
<script src="js/google-code-prettify/prettify.js"></script>
<script src="js/animate.js"></script>
<script src="https://maps.google.com/maps/api/js?sensor=true"></script>
<script src="js/custom.js"></script>
<script>
jQuery(document).ready(function( $ ) {
    
    //Google Map
    var get_latitude = $('#google-map').data('latitude');
    var get_longitude = $('#google-map').data('longitude');

    function initialize_google_map() {
        var myLatlng = new google.maps.LatLng(get_latitude, get_longitude);
        var mapOptions = {
            zoom: 14,
            scrollwheel: false,
            center: myLatlng
        };
        var map = new google.maps.Map(document.getElementById('google-map'), mapOptions);
        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map
        });
    }
    google.maps.event.addDomListener(window, 'load', initialize_google_map);
    
});
</script>

  <script src="js/jquery-ui.js"></script>

<script src="contactform/contactform.js"></script>

  <script>
  $( ".datepicker" ).datepicker({minDate: -5});
  $(".datepicker").datepicker("setDate", new Date());
  </script>
  
  <script>
  $( ".datepicker" ).datepicker({minDate: -5});
  $(".datepicker").datepicker("setDate", new Date());
  </script>
	
</body>
</html>