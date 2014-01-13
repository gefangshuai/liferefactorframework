package net.wincn.ormlite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author gefangshuai
 * 
 */
@Entity(name = "accounts_persistence")
public class AccountWithPersistence {
	/**
	 * id
	 */
	@Id
	private Integer id;
	/**
	 * 唯一
	 */
	@Column(unique = true)
	private String name;

	@Column(nullable = false)
	private String password;
	
	@Column
	private String valid;
	
	@Column
	private String email;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	private String desc;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getValid() {
		return valid;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDesc() {
		return desc;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
