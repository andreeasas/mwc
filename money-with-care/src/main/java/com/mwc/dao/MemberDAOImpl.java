
package com.mwc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mwc.database.user.Member;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Repository
public class MemberDAOImpl implements MemberDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void addMember(Member member) {
    sessionFactory.getCurrentSession().saveOrUpdate(member);
  }

  @SuppressWarnings("unchecked")
  public List<Member> getMembersByUser(User user) {
    Query query = sessionFactory.getCurrentSession().createNamedQuery(Member.MEMBER_BY_USER);
    query.setParameter("user", user);
    return query.list();
  }

  public Member getMember(User user, String name) {
    Query query = sessionFactory.getCurrentSession().createNamedQuery(Member.MEMBER_BY_USER_AND_NAME);
    query.setParameter("user", user);
    query.setParameter("name", name);
    return (Member) query.uniqueResult();
  }

  public void deleteMember(long memberId) {
    Member member = sessionFactory.getCurrentSession().load(Member.class, memberId);
    if (member != null) {
      sessionFactory.getCurrentSession().delete(member);
    }
  }

  public Member updateMember(Member member) {
    sessionFactory.getCurrentSession().update(member);
    return member;
  }

  public Member getMember(long memberId) {
    return sessionFactory.getCurrentSession().get(Member.class, memberId);
  }

}
