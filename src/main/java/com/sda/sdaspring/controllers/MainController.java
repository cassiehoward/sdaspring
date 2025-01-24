package com.sda.sdaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class MainController {

    //@GetMapping("/hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String sayHi(@RequestParam(name = "name", required = false) String firstName,
                        @RequestParam(name = "number", required = false, defaultValue = "13") Integer favoriteNumber) {
        return "Hi " + (Objects.isNull(firstName) ? "friend" : firstName) +
                ", your favorite number is " + favoriteNumber;
    }
}
