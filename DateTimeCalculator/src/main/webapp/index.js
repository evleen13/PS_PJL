function showDiv(select) {
	
	//these two require 1 date and 1 data field
	if ((select.value == "addDays") || (select.value == "subtractDays")) {
		document.getElementById('int-group').style.display = "block";
		document.getElementById('date-group2').style.display = "none";
		document.getElementById("data").required = true;
		document.getElementById("date2").required = false;
	}
	//these two require 2 dates
	else if ((select.value == "addDates") || select.value == "subtractDates") {
		document.getElementById('date-group2').style.display = "block";
		document.getElementById('int-group').style.display = "none";
		document.getElementById("date2").required = true;
		document.getElementById("data").required = false;
	}
	else if ((select.value == "findDayOfTheWeek") || select.value == "getWeekNumber" || select.value=="checkLeap") {
		document.getElementById('date-group2').style.display = "none";
		document.getElementById('int-group').style.display = "none";
		document.getElementById("date2").required = false;
		document.getElementById("data").required = false;
	}
} 