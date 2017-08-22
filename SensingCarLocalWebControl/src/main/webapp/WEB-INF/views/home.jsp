<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>Home</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
		function handleBtnultrasonicSensor(){
			var angle= $("#txtUltrasonicSensorAngle").val();
			$.ajax({
				
				url:"<%=application.getContextPath()%>/ultrasonicsensor",
				data:{"angle":angle},
				success: function(data){
					//var distance=data.distance;  // 해당 이름의 데이터를 얻음
					$("#spanultrasonicSensorDistance").text(data.distance);
				}
				
			});
			
		}
		
		function handleBtnGasSensor(){
			
		$.ajax({
				url:"<%=application.getContextPath()%>/gassensor",
				success: function(data){
					$("#spanGasSensor").text(data.gas);
				}
				
			});
		}
		
		</script>
</head>

<body>
	<h4>SensingCar Web Control</h4>
	<hr />
	[UltrasonicSensor 제어]
	<br />
	<input id="txtUltrasonicSensorAngle" type="number" />
	<button id="btnultrasonicSensor" class="btn btn-info"
		onclick="handleBtnultrasonicSensor()">거리측정</button>
	<span id="spanultrasonicSensorDistance"></span>cm


	<h4>[GasSensor]</h4>
	<button id="btnGasSensor" class="btn btn-info"
		onclick="handleBtnGasSensor()">가스측정</button>
	<span id="spanGasSensor"></span>/255
</body>
</html>






