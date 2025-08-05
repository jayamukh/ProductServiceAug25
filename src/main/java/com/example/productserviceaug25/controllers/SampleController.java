package com.example.productserviceaug25.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{times}")
    public String SayHello(@PathVariable String name, @PathVariable int times) {

        String s = "";

        for(int i = 0; i < times; i++)
        {
            s += "Hello " + name + "! <br>";
        }
        return s;
    }

    @GetMapping("/hi")
    public String SayHi()
    {
        return "Hi Scaler jaya";
    }
}
