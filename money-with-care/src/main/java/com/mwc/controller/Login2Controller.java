/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mwc.database.user.User;
import com.mwc.service.UserService;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Controller
public class Login2Controller {

  private static final Logger logger = Logger.getLogger(LoginController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/login2")
  public String login(@ModelAttribute("userModelAttr") User user) {

    System.out.println("user: " + user.getUsername() + ", pass: " + user.getPassword());

    User dbUser = null;
    if (user.getUsername() != null && user.getPassword() != null) {
      dbUser = userService.getUser(user.getUsername(), user.getPassword());
    }

    if (dbUser != null) {
      logger.info("logged user: " + dbUser.getId());
    } else {
      logger.info("logged user not found");
    }

    return "login";
  }

}