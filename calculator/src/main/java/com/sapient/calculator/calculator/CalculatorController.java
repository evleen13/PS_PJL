package com.sapient.calculator.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

	@RequestMapping(path = "/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public String calculate(@ModelAttribute("calc") CalculatorDao calculator, ModelMap model) {
		double result = 0;
		if (calculator.getOperation().equalsIgnoreCase("add")) {
			result = calculator.getNumber1() + calculator.getNumber1();
		}
		if (calculator.getOperation().equalsIgnoreCase("subtract")) {
			result = calculator.getNumber1() - calculator.getNumber2();
		}
		if (calculator.getOperation().equalsIgnoreCase("multiply")) {
			result = calculator.getNumber1() * calculator.getNumber2();
		}
		if (calculator.getOperation().equalsIgnoreCase("divide")) {
			result = calculator.getNumber1() / calculator.getNumber2();
		}
		model.addAttribute("result", result);
		return "index";
	}
}
