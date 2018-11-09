package com.example.przyklad.controller;

import com.example.przyklad.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/testy")
public class PrintMessageController {
MessageService ms;
@Autowired
    public PrintMessageController(MessageService ms) {
        this.ms = ms;
    }

    @GetMapping("/test1")
    @ResponseBody
public String printIt(HttpServletRequest request){
    String ip = request.getRemoteAddr();
    return ms.printMessage()+" "+(ip);
    }
    @GetMapping("/params")
    @ResponseBody
    public String getInfo(HttpServletRequest request){
    String name = request.getParameter("name");
    return "Cześć "+name;
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request){
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    if("abc".equals(name)&&"xyz".equals(password))
        return "redirect:success.html";
    else
        return "redirect:error.html";

    }
}
