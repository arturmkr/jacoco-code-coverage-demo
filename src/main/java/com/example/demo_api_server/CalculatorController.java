package com.example.demo_api_server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        return num1 + num2;
    }

    @GetMapping("/multiple")
    public int multiple(@RequestParam int num1, @RequestParam int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int num1, @RequestParam int num2) {
       if (num2 == 0) {
           throw new ArithmeticException("Divide by zero");
       } else {
           return num1 / num2;
       }
    }
}
