package com.mvn.user.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * The type User.
 */
@Table(name = "user")
public class User {

	@Id
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column
	private Integer age;
	@Column
	private Date birthday;

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday + '}';
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id
	 *            the id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name
	 *            the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets age.
	 *
	 * @param age
	 *            the age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets birthday.
	 *
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets birthday.
	 *
	 * @param birthday
	 *            the birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
