
package com.mwc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mwc.dao.UserDAO;
import com.mwc.database.user.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;

  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  @Transactional
  public void addUser(User user) {
    userDAO.addUser(user);
  }

  @Override
  @Transactional
  public void deleteUser(long userId) {
    userDAO.deleteUser(userId);
  }

  @Override
  public User getUser(long userId) {
    return userDAO.getUser(userId);
  }

  @Override
  public User updateUser(User user) {
    return userDAO.updateUser(user);
  }

  @Override
  public User getUser(String username, String password) {
    return userDAO.getUser(username, password);
  }

}
