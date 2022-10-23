package com.cydeo.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @RequestMapping("/info")
    public String carInfo(@RequestParam (value ="make", required = false,defaultValue = "Toyota") String make, Model model){

        model.addAttribute("make", make);

        return "car/car-info";
    }

    @RequestMapping("/info/{make}/{year}")
    public String carInfo2(@PathVariable String make,@PathVariable int year, Model model ){

        System.out.println(make);
        System.out.println(year);

        return "car/car-info";
    }
}
