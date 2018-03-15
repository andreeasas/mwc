/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Controller
public class CategoryController {

  private static final Logger log = Logger.getLogger(CategoryController.class);

  public CategoryController() {
    log.info("CategoryController() called");
  }

  //  @Autowired
  //  private CategoryService categoryService;

  //  @RequestMapping(value = "/listMembers", method = RequestMethod.GET)
  //  public ModelAndView listMembers(@ModelAttribute User user) {
  //    User dbUser = userService.getUser(user.getId());
  //    List<Member> members = memberService.getMembersByUser(dbUser);
  //    ModelAndView model = new ModelAndView();
  //    model.addObject("listMembers", members);
  //    model.setViewName("membersForm");
  //    return model;
  //  }

}
