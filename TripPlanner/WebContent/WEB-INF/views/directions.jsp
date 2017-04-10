<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Google Maps</title>
</head>
<body>
	
	<div id="map" style="width:100%;height:400px;"></div>
	<!-- <div id="directionsPanel" style="float:right;width:30%;height 100%"></div> -->


	<script async defer
    src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAYBpc3Ve0q2PjngqgyaXU9pG_VuxhWtks&callback=initMap">
    </script>
	<script>
	var result;

	function initMap() {
	  var map = new google.maps.Map(document.getElementById('map'), {
	    zoom: 4,
	    center: {lat: 20.5937, lng: 78.9629}  // India
	  });

      var contextPath = "${pageContext.request.contextPath}";

	  var directionsDisplay = new google.maps.DirectionsRenderer({
	    draggable: true,
	    map: map
	  });
	   var directionsService = new google.maps.DirectionsService();

        directionsDisplay.setMap(map);
      //  directionsDisplay.setPanel(document.getElementById("directionsPanel"));

		  $.ajax({
		    //url: 'http://localhost:8080/spring-mvc-file-upload/rest/cont/upload',
		    url : contextPath+"/"+"cities?state=20",
		    contentType: 'JSON',
		    type: 'GET',
		    success: function(data){
		    
		        	console.log(data);
	    	console.log(typeof data);
	    	result =  data;
	    	alert(result);
	    	console.log(typeof result);
	    	
	   //    directionsDisplay.setDirections(result)
		    }
		  }); 

  
        var request = {
            origin: 'DELHI',
            destination: 'KHAJURAHO',
            travelMode: google.maps.DirectionsTravelMode.DRIVING
        };
        directionsService.route(request, function(response, status) {
            if(status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
            }
        });
    
   


	/* 	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	console.log(this.responseText);
	    	console.log(typeof this.responseText);
	    	result = JSON.parse(this.responseText);
	    	alert(result);
	    	console.log(typeof result);
	        directionsDisplay.setDirections(result);
			
	    }
	  };
	  xhttp.open("GET", "http://localhost:9080/TripPlanner/directions", true);
	  xhttp.send(); */
      alert("done");
	}
	</script>
</body>
</html>
