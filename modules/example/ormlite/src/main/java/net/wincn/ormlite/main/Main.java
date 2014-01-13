package net.wincn.ormlite.main;

import java.sql.SQLException;

import net.wincn.ormlite.model.AccountWithOrmLite;
import net.wincn.ormlite.model.AccountWithPersistence;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Main {
	public static void main(String[] args) throws SQLException {
		String databaseUrl = "jdbc:sqlite:mem.db";
		ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
		// JdbcPooledConnectionSource connectionSource = new JdbcPooledConnectionSource(databaseUrl);
		// connectionSource.setMaxConnectionAgeMillis(5 * 60 * 1000);
		saveOrmLite(connectionSource);
		savePersistence(connectionSource);
		connectionSource.close();
	}

	public static void saveOrmLite(ConnectionSource connectionSource) throws SQLException {
		Dao<AccountWithOrmLite, String> accountDao = DaoManager.createDao(connectionSource, AccountWithOrmLite.class);
		TableUtils.dropTable(connectionSource, AccountWithOrmLite.class, true);
		TableUtils.createTable(connectionSource, AccountWithOrmLite.class);// 创建表

		AccountWithOrmLite account = new AccountWithOrmLite("葛方帅", "123456");
		account.setFirstName("ge");
		account.setLastName("fangshuai");
		accountDao.create(account);

		// Account account1 = new Account("葛方帅", "123456");//测试唯一
		// accountDao.create(account1);

		AccountWithOrmLite account2 = new AccountWithOrmLite("张方帅", "123456");
		account2.setFirstName("zhang");
		account2.setLastName("fangshuai");
		accountDao.create(account2);

	}

	public static void savePersistence(ConnectionSource connectionSource) throws SQLException {
		Dao<AccountWithPersistence, String> accountDao = DaoManager.createDao(connectionSource,
				AccountWithPersistence.class);
		TableUtils.dropTable(connectionSource, AccountWithPersistence.class, true);
		TableUtils.createTable(connectionSource, AccountWithPersistence.class);// 创建表

		AccountWithPersistence account = new AccountWithPersistence();
		account.setName("葛方帅");
		account.setPassword("12345678");
		account.setFirstName("ge");
		account.setLastName("fangshuai");
		accountDao.create(account);

		// Account account1 = new Account("葛方帅", "123456");//测试唯一
		// accountDao.create(account1);

		AccountWithPersistence account2 = new AccountWithPersistence();
		account2.setName("张方帅");
		account2.setPassword("123456");
		account2.setFirstName("zhang");
		account2.setLastName("fangshuai");
		accountDao.create(account2);
	}
}
