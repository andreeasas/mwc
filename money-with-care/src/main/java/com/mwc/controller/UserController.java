
package com.mwc.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mwc.database.user.User;
import com.mwc.service.UserService;

@Controller
public class UserController {

  private static final Logger logger = Logger.getLogger(UserController.class);

  public UserController() {
    logger.info("UserController() called");
  }

  @Autowired
  private UserService userService;

  //userForm defines: <form:form action="saveUser.html" method="post" modelAttribute="user">
  //	- action="saveUser.html" -> handled by the method annotated with @RequestMapping(value = "/saveUser"..). 
  //		.html resolved by web.xml -> <servlet-mapping> <url-pattern> 
  //	- method="post" -> send data to new action
  //	- modelAttribute="user" -> from model.addObject("user",...) = the attributeName for the object
  @RequestMapping(value = "/newUser", method = RequestMethod.GET)
  public ModelAndView newContact(ModelAndView model) {
    User user = new User();
    model.addObject("user", user);
    model.setViewName("userForm");
    return model;
  }

  @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
  public ModelAndView saveUser(@ModelAttribute User user) {
    if (user.getId() == 0) {
      userService.addUser(user); // save user
    } else {
      userService.updateUser(user); // update user
    }
    logger.info("user created: " + user.getUsername());
    return new ModelAndView("redirect:/login.html"); // on forward, redirect set url request
  }

}
