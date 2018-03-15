
package com.mwc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mwc.common.util.OracleDatabase;
import com.mwc.common.util.Utils;
import com.mwc.database.user.User;

@Repository
public class UserDAOImpl implements UserDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void addUser(User user) {
    /** --- ENCRYPT THE USER'S PASSWORD --- */
    user.setPassword(Utils.encrypt(user.getPassword()));

    /** --- CREATE DEFAULT CATEGORIES FOR USER --- */
    OracleDatabase oracleDb = OracleDatabase.getInstance();
    oracleDb.createCategoriesForUser(user, oracleDb.getDefaultCategories());

    sessionFactory.getCurrentSession().saveOrUpdate(user);
  }

  @Override
  public void deleteUser(long userId) {
    User user = sessionFactory.getCurrentSession().load(User.class, userId);
    if (user != null) {
      this.sessionFactory.getCurrentSession().delete(user);
    }
  }

  @Override
  public User updateUser(User user) {
    sessionFactory.getCurrentSession().update(user);
    return user;
  }

  @Override
  public User getUser(String username, String password) {
    Query query = sessionFactory.getCurrentSession().createNamedQuery(User.USER_BY_NAME_AND_PASS);
    query.setParameter("user", username);
    query.setParameter("pass", Utils.encrypt(password));
    return (User) query.uniqueResult();
  }

  @Override
  public User getUser(long userId) {
    return sessionFactory.getCurrentSession().get(User.class, userId);
  }

}
