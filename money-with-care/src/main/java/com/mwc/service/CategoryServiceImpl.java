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

import com.mwc.dao.CategoryDAO;
import com.mwc.database.expense.Category;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDAO categoryDAO;

  public void setCategoryDAO(CategoryDAO categoryDAO) {
    this.categoryDAO = categoryDAO;
  }

  @Override
  @Transactional
  public void addCategory(Category category) {
    categoryDAO.addCategory(category);
  }

  @Override
  @Transactional
  public List<Category> getCategoriesByUser(User user) {
    return categoryDAO.getCategoriesByUser(user);
  }

  @Override
  public Category getCategory(User user, String name) {
    return categoryDAO.getCategory(user, name);
  }

  @Override
  @Transactional
  public void deleteCategory(long categoryId) {
    categoryDAO.deleteCategory(categoryId);
  }

  @Override
  public Category updateCategory(Category category) {
    return categoryDAO.updateCategory(category);
  }

  @Override
  public Category getCategory(long categoryId) {
    return categoryDAO.getCategory(categoryId);
  }

}
