<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>My Calculator</title>
<script type="text/javascript" src="index.js"></script>
<style>
#int-group {
	display: none;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="text-center text-danger bg-dark">
				<!--<h1>Date Time Calculator</h1>-->
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 "></div>
			<div class="col-md-8 ">
				<div class="card bg-light" style="border-style: solid; padding: 10px;margin-top: 10vh;">
					<div class="text-center text-white mb-5  bg-primary" style="border-radius: 5px;font-size: 2rem" >
                  <span>Date Time Calculator</span>
                </div>
					<form class="" method="POST" action="/calculate">
						<div class="form-group">
							<label for="operation">Select operation:</label>
							 <select
								class="form-control" id="operation" name="operation" onchange="showDiv(this)">
								<option value="addDates">Add given two dates</option>
								<option value="subtractDates">Calculate number of days
									between dates</option>
								<option value="addDays">Add n days to given date</option>
								<option value="subtractDays">Subtract n days from given date</option>
								<option value="findDayOfTheWeek">Find which day it is based on date</option>
								<option value="getWeekNumber">Get week number based on date</option>
								<option value="checkLeap">Check leap year</option>
							</select>
						</div>
						<div class="form-group" id="date-group1">
							<label class="control-label" for="date1">Enter Date 1</label> <input
								type="date" name="date1" id="date1" max="3000-12-31"
								min="1000-01-01" class="form-control" required>
						</div>
						<div class="form-group" id="date-group2">
							<label class="control-label" for="date2">Enter Date 2</label> <input
								type="date" name="date2" id="date2" max="3000-12-31"
								min="1000-01-01" class="form-control">
						</div>
						<div class="form-group" id="int-group">
							<label class="control-label" for="data">Enter number of
								days</label> <input type="number" name="data" id="data"
								class="form-control">
						</div>


						<div class="text-center"><button type="submit" class="btn btn-primary btn-lg">Calculate</button></div>
					</form>
					<div class="text-center mt-2 bg-primary text-white" style="border-radius: 5px;">
						<h3>Result: ${result }</h3>
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