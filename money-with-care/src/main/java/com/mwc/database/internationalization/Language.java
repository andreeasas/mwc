/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.database.internationalization;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Entity
public class Language implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private String langId;

  public Language() {
  }

  public Language(String langId) {
    super();
    this.langId = langId;
  }

  public String getLangId() {
    return langId;
  }

  public void setLangId(String langId) {
    this.langId = langId;
  }

}
