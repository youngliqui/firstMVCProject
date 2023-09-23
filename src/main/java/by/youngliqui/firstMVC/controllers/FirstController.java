package by.youngliqui.firstMVC.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("GoodBye! " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int a,
                                 @RequestParam(value = "b", required = false) int b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model) {


        switch (action) {
            case "multiplication" -> model.addAttribute("result", a * b);
            case "addition" -> model.addAttribute("result", a + b);
            case "subtraction" -> model.addAttribute("result", a - b);
            case "division" -> {
                if (b == 0) {
                    model.addAttribute("result", "Error!");
                } else {
                    model.addAttribute("result", a / (double) b);
                }
            }
        }

        return "first/calculator";
    }
}
