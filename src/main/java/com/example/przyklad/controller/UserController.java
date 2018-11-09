package com.example.przyklad.controller;

import com.example.przyklad.component.User;
import com.example.przyklad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    UserRepository ur;
@Autowired
    public UserController(UserRepository ur) {
        this.ur = ur;
    }
    @GetMapping("/printUsers")
    @ResponseBody
    public String printList(){
    List<User>users = ur.getUsers();
    String list = "";
        for (User user : users) {
            list+=user.toString();
            list+="<br>";
        }
        return list;
    }
    @GetMapping("/addUser")
    @ResponseBody
    public void addUser(HttpServletRequest request){
        List<User>users = ur.getUsers();
        String name = request.getParameter("firstName");
        String surname = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        users.add(new User(name,surname,age));
    }

}
