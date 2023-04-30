package org.example.springBootApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {
    @Value("${hello}")
    private String message;

    @GetMapping
    public String showHello(){
        System.out.println(message);
        return "/first/hello";
    }
}
