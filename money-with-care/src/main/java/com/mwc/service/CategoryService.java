/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.service;

import java.util.List;

import com.mwc.database.expense.Category;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public interface CategoryService {

  public void addCategory(Category category);

  public List<Category> getCategoriesByUser(User user);

  public Category getCategory(User user, String name);

  public void deleteCategory(long categoryId);

  public Category updateCategory(Category category);

  public Category getCategory(long categoryId);

}
