/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.service;

import java.util.List;

import com.mwc.database.user.Member;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public interface MemberService {

  public void addMember(Member member);

  public List<Member> getMembersByUser(User user);

  public Member getMember(User user, String name);

  public void deleteMember(long memberId);

  public Member updateMember(Member member);

  public Member getMember(long memberId);

}
