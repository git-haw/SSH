package top.haw358.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.haw358.demo.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haw on 17-6-6.
 */
//@Controller
public class AuthController {

//    @RequestMapping("/loginPage")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        /*Map<String, Object> data = new HashMap<String, Object>();
        data.put("error", false);
        data.put("logout", false);
        modelAndView.addObject("param", data);*/

        return modelAndView;
    }
}
