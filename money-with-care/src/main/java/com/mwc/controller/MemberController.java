/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mwc.database.user.Member;
import com.mwc.database.user.User;
import com.mwc.service.MemberService;
import com.mwc.service.UserService;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Controller
public class MemberController {

  private static final Logger logger = Logger.getLogger(MemberController.class);

  public MemberController() {
    logger.info("MemberController() called");
  }

  @Autowired
  private MemberService memberService;

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/listMembers", method = RequestMethod.GET)
  public ModelAndView listMembers(@ModelAttribute User user) {
    User dbUser = userService.getUser(user.getId());
    List<Member> members = memberService.getMembersByUser(dbUser);
    ModelAndView model = new ModelAndView();
    model.addObject("listMembers", members);
    model.setViewName("membersForm");
    return model;
  }

  @RequestMapping(value = "/newMember", method = RequestMethod.GET)
  public ModelAndView newMember() {
    Member member = new Member();
    ModelAndView model = new ModelAndView();
    model.addObject("member", member);
    model.setViewName("memberForm");
    return model;
  }

  @RequestMapping(value = "/saveMember", method = RequestMethod.POST)
  public ModelAndView saveMember(@ModelAttribute Member member, HttpSession session) {
    member.setDbUser((User) session.getAttribute("user"));
    logger.info(member);
    if (member.getId() == 0) {
      memberService.addMember(member);
    } else {
      memberService.updateMember(member);
    }
    return new ModelAndView("redirect:/login.html");

    //    ModelAndView model = new ModelAndView();
    //    model.setViewName("redirect:/listMembers.html");
    //    model.addObject(session.getAttribute("user"));
    //    return model;
  }

  @RequestMapping(value = "/deleteMember", method = RequestMethod.GET)
  public ModelAndView deleteMember(HttpServletRequest request) {
    long memberId = Long.parseLong(request.getParameter("id"));
    memberService.deleteMember(memberId);
    return new ModelAndView("redirect:/login.html");

    //    ModelAndView model = new ModelAndView();
    //    model.setViewName("redirect:/listMembers.html");
    //    model.addObject(session.getAttribute("user"));
    //    return model;
  }

  @RequestMapping(value = "/editMember", method = RequestMethod.GET)
  public ModelAndView editMember(HttpServletRequest request) {
    long memberId = Long.parseLong(request.getParameter("id"));
    Member member = memberService.getMember(memberId);
    ModelAndView model = new ModelAndView();
    model.addObject("member", member);
    model.setViewName("memberForm");
    return model;
  }

}
