package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@RequestParam("num1") double num1,
                                  @RequestParam("num2") double num2,
                                  @RequestParam("operator") String operator) {
        double result = 0;
        switch (operator) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
        }
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
