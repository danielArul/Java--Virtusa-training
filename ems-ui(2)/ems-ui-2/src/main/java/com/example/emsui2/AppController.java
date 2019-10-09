package com.example.emsui2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
    public String homePage(Model m){
        String str=new String();
        str="thilina";
        m.addAttribute("var",str);
        return "home";
    }
}
