
package com.mwc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mwc.database.expense.Category;
import com.mwc.database.user.Member;
import com.mwc.database.user.User;
import com.mwc.model.UserDto;
import com.mwc.service.CategoryService;
import com.mwc.service.MemberService;
import com.mwc.service.UserService;

@Controller
public class LoginController {

  private static final Logger logger = Logger.getLogger(LoginController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private MemberService memberService;

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login(@ModelAttribute("userModelAttr") UserDto userDto) {
    ModelAndView model = new ModelAndView();
    model.addObject(userDto);
    model.setViewName("login");
    return model;
  }

  @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
  public ModelAndView checkUser(@ModelAttribute UserDto userDto, HttpSession session) {

    System.out.println("user: " + userDto.getUsername() + ", pass: " + userDto.getPassword());

    User user = null;
    if (userDto.getUsername() != null && userDto.getPassword() != null) {
      user = userService.getUser(userDto.getUsername(), userDto.getPassword());
    }

    if (user != null) {
      logger.info("logged user: " + user.getId());
      session.setAttribute("user", user);

      ModelAndView model = new ModelAndView();
      model.addObject(user);

      List<Member> members = memberService.getMembersByUser(user);
      model.addObject("listMembers", members);

      List<Category> categories = categoryService.getCategoriesByUser(user);
      logger.info(categories);
      categories.forEach(categ -> {
        logger.info(categ.getSubcategories().size());
        if (categ.getSubcategories().size() > 0) {
          categ.getSubcategories().forEach(subcateg -> {
            logger.info(subcateg.getName());
          });
        }
      });
      model.addObject("categories", categories);

      model.setViewName("membersForm");
      return model;
    }

    return new ModelAndView("login");
  }

}
