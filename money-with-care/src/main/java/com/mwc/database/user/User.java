
package com.mwc.database.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.mwc.common.util.Utils;

@Entity
@Table(name = "DBUSER", //
    uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) } //
)
@NamedQueries({ //
  @NamedQuery(name = User.USER_BY_NAME, query = "from User where username = :user"), //
  @NamedQuery(name = User.USER_BY_NAME_AND_PASS, query = "from User where username = :user and password = :pass"), //
  @NamedQuery(name = User.USER_ALL, query = "from User") //
})
public class User implements Serializable, Comparable<User> {
  private static final long serialVersionUID = 1L;

  public static final String USER_BY_NAME = "User.by.name";
  public static final String USER_BY_NAME_AND_PASS = "User.by.name.and.pass";
  public static final String USER_ALL = "User.all";

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
  @SequenceGenerator(initialValue = 1, sequenceName = "seq_gen_users", name = "gen")
  private long id;
  @Column(nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  private String lastName;

  //  @OneToMany( //
  //  mappedBy = "dbUser", //
  //  cascade = { CascadeType.ALL } //
  //  )
  //  private List<Member> members;

  //  @OneToMany( //
  //  mappedBy = "user", //
  //  cascade = { CascadeType.ALL } //
  //  )
  //  private List<Category> categories;

  public User() {
  }

  public User(String username, String password, String lastname) {
    super();
    this.username = username;
    this.password = Utils.encrypt(password);
    this.lastName = lastname;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //  public List<Member> getMembers() {
  //    return members;
  //  }
  //
  //  public void setMembers(List<Member> members) {
  //    this.members = members;
  //  }

  //  public List<Category> getCategories() {
  //    return categories;
  //  }
  //
  //  public void setCategories(List<Category> categories) {
  //    this.categories = categories;
  //  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (id != other.id)
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }

  public int compareTo(User o) {
    // TODO Auto-generated method stub
    return 0;
  }

}
