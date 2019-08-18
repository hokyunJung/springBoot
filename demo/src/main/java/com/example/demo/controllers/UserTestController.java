package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entitiys.AdsUser;
import com.example.demo.models.DetailsUser;
import com.example.demo.services.UserService;

@Controller
public class UserTestController {
	
	@Autowired
	UserService userService;
 
    @GetMapping("/test")
    public ModelAndView getUser(ModelAndView model) {
        //User user = new User("kkaok", "하하", "web") ;
        //model.addObject("user", user);
        model.setViewName("test");
        return model;
    }
    
    @GetMapping("/test2")
    public ModelAndView test2(ModelAndView model) {
        //model.addObject("user", user);
        model.setViewName("test2");
        return model;
    }
    
    @RequestMapping("/login")
    public String login()
    {
    	return
    		"login";
    }
    
    @RequestMapping("/main")
    public ModelAndView main(@AuthenticationPrincipal DetailsUser detailsUser)
    {
    	System.out.println(detailsUser.getAuthorities().toString());
    	ModelAndView mv = new ModelAndView();
    	
    	mv.addObject("detailsUser", detailsUser);
    	mv.setViewName("main");
    	return
    			mv;
    }

    @RequestMapping("/create")
    public String create()
    {
    	return
    		"create";
    }
    
    @RequestMapping("/createProcessing")
    public ModelAndView createProcessing(@RequestParam("id") String id,
    		@RequestParam("pw") String pw)
    {
    	ModelAndView mv = new ModelAndView();
    	userService.createProcessing(id, pw);
    	mv.setViewName("/main");
    	return mv;
    }
    

}
