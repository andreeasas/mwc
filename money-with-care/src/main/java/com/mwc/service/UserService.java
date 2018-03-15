
package com.mwc.service;

import com.mwc.database.user.User;

public interface UserService {

  public void addUser(User user);

  public void deleteUser(long userId);

  public User getUser(long userId);

  public User getUser(String username, String password);

  public User updateUser(User user);

}
