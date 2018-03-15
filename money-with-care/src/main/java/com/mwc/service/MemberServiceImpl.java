/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwc.dao.MemberDAO;
import com.mwc.database.user.Member;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

  @Autowired
  private MemberDAO memberDAO;

  public void setMemberDAO(MemberDAO memberDAO) {
    this.memberDAO = memberDAO;
  }

  @Override
  @Transactional
  public void addMember(Member member) {
    memberDAO.addMember(member);
  }

  @Override
  @Transactional
  public List<Member> getMembersByUser(User user) {
    return memberDAO.getMembersByUser(user);
  }

  @Override
  public Member getMember(User user, String name) {
    return memberDAO.getMember(user, name);
  }

  @Override
  @Transactional
  public void deleteMember(long memberId) {
    memberDAO.deleteMember(memberId);
  }

  @Override
  public Member updateMember(Member member) {
    return memberDAO.updateMember(member);
  }

  @Override
  public Member getMember(long memberId) {
    return memberDAO.getMember(memberId);
  }

}
