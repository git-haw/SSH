package top.haw358.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by haw on 17-6-7.
 */
//@Controller
public class IndexController {

//    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
