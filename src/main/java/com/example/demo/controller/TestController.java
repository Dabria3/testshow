package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@RestController
@Controller
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ResponseBody
    public String ok() {
        //welcome to here,this is the demo show from Dabria
        return "Today is "+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @RequestMapping("/user/select")
    @ResponseBody
    public User select(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        User user = userService.selectUserInfo(userId);
        return user;
    }


    @RequestMapping("/user/selectOne/{userId}")
    @ResponseBody
    public User selectOne(@PathVariable("userId") String userId) {
        User user = userService.selectUserInfo(userId);
        return user;
    }

    @GetMapping("touser")
    public String toUserInsert(HttpServletRequest request) {
        return "userInsert";
    }

    @PostMapping("user/insert")
    @ResponseBody
    public Map<String,String> userInsert(HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("userName"));
        int a = userService.save(user);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message","游戏结束");
        return map;
    }

    @GetMapping("/user/selectAll")
    public String selectOne(Model model) {
        model.addAttribute("time", new Date());
        model.addAttribute("message", "hello");
        return "index";
    }

}