<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<meta charset="UTF-8">
	<title>Google Maps</title>
</head>
<body>
	
	<div id="map" style="float:right;width:30%;height:100%"></div>
	<!-- <div id="directionsPanel" style="float:right;width:30%;height 100%"></div> -->


	<script async defer
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyA1n7IZ2qQVXWFivgYlKg6NPvJA2LLYNI4&callback=initMap">
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
		    url : contextPath+"/"+"cities?state=20&origin=Delhi",
		    contentType: 'JSON',
		    type: 'GET',
		    success: function(data){

		    	/*console.log(data);
		    	console.log(typeof data);*/
		    	result =  data;
		    	/*alert(result);
		    	console.log(typeof result);
		    	console.log(result[0]);*/

	   //    directionsDisplay.setDirections(result)
	   var waypts = []
	   for (var i = result.length - 1; i >= 1; i--) {
	   	waypts.push({
	   		location: result[i],
	   		stopover: true
	   	});
	   }
	   var request = {
	   	origin: result[0],
	   	destination: result[0],
	   	waypoints:waypts,
	   	optimizeWaypoints: true,
	   	travelMode: google.maps.DirectionsTravelMode.DRIVING
	   };
	   directionsService.route(request, function(response, status) {
	   	if(status == google.maps.DirectionsStatus.OK) {
	   		directionsDisplay.setDirections(response);
	   	}
	   });

	}
}); 

      /*alert("done");*/
  }

  </script>
</body>
</html>
