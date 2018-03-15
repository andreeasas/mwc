/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.common.util;

import java.util.List;

import org.hibernate.Session;

import com.mwc.database.expense.Category;
import com.mwc.database.internationalization.MonetaryUnit;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

public interface Database {

  public long convertCurrencyToReference(long value, MonetaryUnit current, MonetaryUnit reference);

  public String[] getDefaultCategories();

  public String[] getDefHouseSubcateg();

  public List<Category> createCategoriesForUser(User user, String[] subcategoriesName);

  public List<Category> createSubCategories(Category parent, String[] categoriesName);

  public <T> T getWithAssociation(Session session, final long id, String association);

  public <T> T getWithAssociation(Session session, final long id, List<String> associations);

}
