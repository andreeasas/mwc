/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mwc.database.expense.Category;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Repository
public class CategoryDAOImpl implements CategoryDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public void addCategory(Category category) {
    sessionFactory.getCurrentSession().saveOrUpdate(category);
  }

  @Override
  @Transactional
  @SuppressWarnings("unchecked")
  public List<Category> getCategoriesByUser(User user) {
    Query query = sessionFactory.getCurrentSession().createNamedQuery(Category.CATEGORY_BY_USER);
    query.setParameter("user", user);
    @SuppressWarnings("unchecked")
    List<Category> categories = query.list();
    // fetch subcategories
    categories.forEach(categ -> {
      categ.getSubcategories().size();
    });
    return categories;
  }

  @Override
  @Transactional
  public Category getCategory(User user, String name) {
    Query query = sessionFactory.getCurrentSession().createNamedQuery(Category.CATEGORY_BY_USER_AND_NAME);
    query.setParameter("user", user);
    query.setParameter("name", name);
    return (Category) query.uniqueResult();
  }

  @Override
  @Transactional
  public void deleteCategory(long categoryId) {
    Category category = sessionFactory.getCurrentSession().load(Category.class, categoryId);
    if (category != null) {
      sessionFactory.getCurrentSession().delete(category);
    }
  }

  @Override
  public Category updateCategory(Category category) {
    sessionFactory.getCurrentSession().update(category);
    return category;
  }

  @Override
  public Category getCategory(long categoryId) {
    //      Category category = sessionFactory.getCurrentSession().get(Category.class, categoryId);
    //      Session session = sessionFactory.getCurrentSession();
    //      List categories = session.createCriteria(Category.class)//
    //        .list();
    //        .setFetchMode(associationPath, mode)//

    return sessionFactory.getCurrentSession().get(Category.class, categoryId);

  }

}
