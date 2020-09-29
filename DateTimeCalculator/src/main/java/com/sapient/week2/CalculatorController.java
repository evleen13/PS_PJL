package com.sapient.week2;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

	@RequestMapping(path = "/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public String calculate(DateTimeCalculator calculator, ModelMap model) {

		// add two dates
		if (calculator.getOperation().equals("addDates")) {
			LocalDate result;
			result = calculator.addDates();
			model.addAttribute("result", result);
		}

		// subtract two dates(get no of days between)
		if (calculator.getOperation().equalsIgnoreCase("subtractDates")) {
			String result;
			result = calculator.subtractDates();
			model.addAttribute("result", result);
		}

		// add n days
		if (calculator.getOperation().equalsIgnoreCase("addDays")) {
			LocalDate result;
			result = DateTimeCalculator.addDays(calculator.getDate1(), Integer.parseInt(calculator.getData()));
			model.addAttribute("result", result);
		}
		if (calculator.getOperation().equalsIgnoreCase("subtractDays")) {
			LocalDate result;
			result = DateTimeCalculator.subtractDays(calculator.getDate1(), Integer.parseInt(calculator.getData()));
			model.addAttribute("result", result);
		}
		if (calculator.getOperation().equalsIgnoreCase("findDayOfTheWeek")) {
			DayOfWeek dayOfTheWeek = DateTimeCalculator.findDayOfTheWeek(calculator.getDate1());
			model.addAttribute("result",dayOfTheWeek);
		}
		if (calculator.getOperation().equalsIgnoreCase("getWeekNumber")) {
			long weekNumber = DateTimeCalculator.getWeekNumber(calculator.getDate1());
			model.addAttribute("result", weekNumber);
		}
		if (calculator.getOperation().equalsIgnoreCase("checkLeap")) {
			String result = DateTimeCalculator.checkLeap(calculator.getDate1());
			model.addAttribute("result", result);
		}
		// return "redirect:/";
		return "index";
	}
}
