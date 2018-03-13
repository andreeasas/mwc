/*
 * Copyright (c) 2018 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.mwc.database.expense;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.mwc.database.user.Member;
import com.mwc.database.user.User;

/**
 * @author <a href="mailto:andreeasas12@gmail.com">asas</a>
 * @version $Revision: $, $Date: $, $Author: $
 */

@Entity
public class Category {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categ_gen")
  @SequenceGenerator(initialValue = 1, sequenceName = "seq_gen_categories", name = "categ_gen")
  private long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne
  private Category parent;

  @OneToMany( //
      mappedBy = "parent", //
      cascade = { CascadeType.ALL } //
  )
  private List<Category> subcategories;

  @ManyToOne
  private User user;

  @ManyToOne
  private Member member;

  public Category() {
  }

  public Category(String name, Category parent, User user, Member member) {
    super();
    this.name = name;
    this.parent = parent;
    this.user = user;
    this.member = member;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category getParent() {
    return parent;
  }

  public void setParent(Category parent) {
    this.parent = parent;
  }

  public List<Category> getSubcategories() {
    return subcategories;
  }

  public void setSubcategories(List<Category> subcategories) {
    this.subcategories = subcategories;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

}
