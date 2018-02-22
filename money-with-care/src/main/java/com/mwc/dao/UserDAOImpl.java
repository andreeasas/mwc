
package com.mwc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mwc.common.util.Utils;
import com.mwc.database.user.User;

@Repository
public class UserDAOImpl implements UserDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void addUser(User user) {
    user.setPassword(Utils.encrypt(user.getPassword()));
    sessionFactory.getCurrentSession().saveOrUpdate(user);
  }

  //	@SuppressWarnings("unchecked")
  //	public List<User> getAllUsers() {
  //		return sessionFactory.getCurrentSession().createQuery("from User").list();
  //	}

  public void deleteUser(long userId) {
    User user = sessionFactory.getCurrentSession().load(User.class, userId);
    if (user != null) {
      this.sessionFactory.getCurrentSession().delete(user);
    }
  }

  public User updateUser(User user) {
    sessionFactory.getCurrentSession().update(user);
    return user;
  }

  public User getUser(String username, String password) {
    Query query = sessionFactory.getCurrentSession().createNamedQuery(User.USER_BY_NAME_AND_PASS);
    query.setParameter("user", username);
    query.setParameter("pass", Utils.encrypt(password));
    return (User) query.uniqueResult();
  }

  //	public User getUser(long userId) {
  //		return sessionFactory.getCurrentSession().get(User.class, userId);
  //	}

}
