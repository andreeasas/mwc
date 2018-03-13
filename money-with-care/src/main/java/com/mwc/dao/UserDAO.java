
package com.mwc.dao;

import com.mwc.database.user.User;

public interface UserDAO {

  public void addUser(User user);

  //	public List<User> getAllUsers();

  public void deleteUser(long userId);

  public User updateUser(User user);

  public User getUser(String username, String password);

  public User getUser(long userId);
}
