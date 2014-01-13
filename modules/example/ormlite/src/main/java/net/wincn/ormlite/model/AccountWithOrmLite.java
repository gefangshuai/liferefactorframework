package net.wincn.ormlite.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 使用ormlite注解的model
 * 
 * @author gefangshuai
 * 
 */
@DatabaseTable(tableName = "accounts_ormlite")
public class AccountWithOrmLite {
	/**
	 * id
	 */
	@DatabaseField(id = true)
	private Integer id;
	/**
	 * 唯一
	 */
	@DatabaseField(unique = true)
	private String name;

	@DatabaseField(canBeNull = false)
	private String password;

	@DatabaseField(defaultValue = "1")
	private String valid;

	@DatabaseField
	private String email;

	/**
	 * 组合唯一
	 * 
	 * @see lastName
	 */
	@DatabaseField(uniqueCombo = true)
	private String firstName;

	/**
	 * 组合唯一
	 * 
	 * @see firstName
	 */
	@DatabaseField(uniqueCombo = true)
	private String lastName;

	/**
	 * 不持久化到数据库中
	 */
	@DatabaseField(persisted = false)
	private String desc;

	public AccountWithOrmLite() {

	}

	public AccountWithOrmLite(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getValid() {
		return valid;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

}
