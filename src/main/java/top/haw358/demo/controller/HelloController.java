package top.haw358.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.haw358.demo.service.UserService;

/**
 * Created by haw on 17-5-13.
 */
@Controller
public class HelloController {
    private static Logger logger = Logger.getLogger(HelloController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/showView")
    public ModelAndView showView() {
        boolean isExists = userService.isExists("haw");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo");
        modelAndView.addObject("user", isExists);

        return modelAndView;
    }
}
