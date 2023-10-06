package com.z2xinyu.mvc.mybatis.controller;

import com.z2xinyu.mvc.mybatis.po.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Arnoer
 * @since 2022/10/8 10:07
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user, ModelAndView modelAndView, HttpSession session) {
        if(user != null && StringUtils.equals(user.getUsername(), "arnoer")) {
            session.setAttribute("session_user", user);
            modelAndView.addObject("username", user.getUsername());
            return "redirect:/items/index";
        }
        return "/login";
    }

}
