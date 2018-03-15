/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.common.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mwc.common.consts.CategoryConsts;
import com.mwc.common.consts.HouseConsts;
import com.mwc.database.expense.Category;
import com.mwc.database.internationalization.MonetaryUnit;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Repository
public class OracleDatabase implements Database {

  private static OracleDatabase instance;

  private OracleDatabase() {
  }

  public static OracleDatabase getInstance() {
    if (instance == null) {
      instance = new OracleDatabase();
    }
    return instance;
  }

  public static final String[] DEFAULT_CATEGORIES;
  public static final String[] DEFAULT_HOUSE_SUBCATEGORIES;

  static {
    DEFAULT_CATEGORIES = new String[] { //
      CategoryConsts.COMMUNICATION, //
      CategoryConsts.DEBT, //
      CategoryConsts.EDUCATION, //
      CategoryConsts.FOOD, //
      CategoryConsts.HOUSE, //
      CategoryConsts.PERSONAL, //
      CategoryConsts.RECREATION, //
      CategoryConsts.TRANSPORT //
    };

    DEFAULT_HOUSE_SUBCATEGORIES = new String[] { //
      HouseConsts.BILLS, //
      HouseConsts.EQUIPMENT, //
      HouseConsts.MAINTENANCE //
    };
  }

  @Override
  public String[] getDefaultCategories() {
    return DEFAULT_CATEGORIES;
  }

  @Override
  public String[] getDefHouseSubcateg() {
    return DEFAULT_HOUSE_SUBCATEGORIES;
  }

  @Override
  public long convertCurrencyToReference(long value, MonetaryUnit current, MonetaryUnit reference) {
    // TODO Auto-generated method stub
    return 0;
  }

  /**
   * @param user
   * @param subcategoriesName
   * @return list of {@link Category}
   */
  @Override
  public List<Category> createCategoriesForUser(User user, String[] subcategoriesName) {
    List<Category> categories = new ArrayList<Category>();
    for (String categName : subcategoriesName) {
      categories.add(new Category(categName, null, user, null));
    }
    // categories will be automatically saved when saving the user
    if (user != null) {
      user.setCategories(categories);
    }
    return categories;
  }

  @Override
  public List<Category> createSubCategories(Category parent, String[] categoriesName) {
    List<Category> subcategories = new ArrayList<Category>();
    for (String categName : categoriesName) {
      subcategories.add(new Category(categName, parent, parent.getUser(), null));
    }
    // subcategories will be automatically saved when saving the categories
    if (parent != null) {
      parent.setSubcategories(subcategories);
    }
    return subcategories;
  }

  @Override
  public <T> T getWithAssociation(Session session, long id, String association) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <T> T getWithAssociation(Session session, long id, List<String> associations) {
    // TODO Auto-generated method stub
    return null;
  }

}
