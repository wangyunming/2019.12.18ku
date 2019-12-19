package com.haoyin.image.demo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {
 

    @RequestMapping("/hello")
    public String welcome(Model model) {
    	model.addAttribute("time", new Date());
        return "demo";
    }

}