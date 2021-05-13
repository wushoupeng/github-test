package com.intouch.ssm.controller;

import com.intouch.ssm.domain.User;
import com.intouch.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "LoginForm";
    }
    @PostMapping("/login")
    public String handleLogin(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                              Model model, HttpServletRequest request){
        if (bindingResult.hasErrors()){
            return "LoginForm";
        }
        User validUser = userService.login(user.getEmail());
        //错误
        if (validUser==null || validUser.getPassword().equals(user.getPassword())){
            String errorMessage ="错误";
            model.addAttribute("errorMessage",errorMessage);
        }
        validUser.setLastLoginTime(System.currentTimeMillis());
        //获取ip
        String remoteIp = request.getRemoteAddr();
        validUser.setLastLoginIp(remoteIp);
        userService.modifyUser(validUser);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("validUser",validUser);
        return "UserInfo";
    }
    @GetMapping("/logout")
    public String handleLogout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("validUser");

        session.invalidate();

        return "redirct:/user/form";
    }
}
