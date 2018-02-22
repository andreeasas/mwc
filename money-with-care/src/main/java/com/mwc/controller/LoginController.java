
package com.mwc.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mwc.database.user.User;
import com.mwc.model.UserDto;
import com.mwc.service.UserService;

@Controller
public class LoginController {

  private static final Logger logger = Logger.getLogger(LoginController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login")
  public String login(@ModelAttribute("userModelAttr") UserDto userDto) {

    System.out.println("user: " + userDto.getUsername() + ", pass: " + userDto.getPassword());

    User user = null;
    if (userDto.getUsername() != null && userDto.getPassword() != null) {
      user = userService.getUser(userDto.getUsername(), userDto.getPassword());
    }

    if (user != null) {
      logger.info("logged user: " + user.getId());
    } else {
      logger.info("logged user not found");
    }

    return "login";
  }

}
