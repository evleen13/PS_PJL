<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<link href="https://fonts.googleapis.com/css?family=Quicksand"
	rel="stylesheet">
<title>My Calculator</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="text-center text-danger bg-dark">
				<h1>Calculator</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 "></div>
			<div class="col-md-8 ">
				<div style="border-style: solid; padding: 10px;">
					<form class="" method="POST" action="/calculate">
						<div class="form-group">
							<label class="control-label" for="number1">Number 1:</label> <input
								type="number" class="form-control" id="number1" name="number1"
								placeholder="Enter Number 1" required>
						</div>
						<div class="form-group">
							<label for="operation">Select operation:</label> <select
								class="form-control" id="operation" name="operation" required>
								<option value="add">+</option>
								<option value="sub">-</option>
								<option value="multiply">*</option>
								<option value="divide">/</option>
							</select>
						</div>
						<div class="form-group">
							<label class="control-label" for="number2">Number 2:</label> <input
								type="number" class="form-control" id="number2" name="number2"
								placeholder="Enter Number 2" required>
						</div>
						<button type="submit" class="btn btn-primary btn-lg">Calculate</button>
					</form>
					<div class="text-center">
						<p>Result:</p>
						<h1>${result }</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>