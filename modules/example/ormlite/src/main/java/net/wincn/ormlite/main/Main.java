package net.wincn.ormlite.main;

import java.sql.SQLException;

import net.wincn.ormlite.model.Account;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class Main {
	public static void main(String[] args) throws SQLException {
		String databaseUrl = "jdbc:sqlite:mem.db";
		ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

		Dao<Account, String> accountDao = DaoManager.createDao(connectionSource, Account.class);
		TableUtils.createTable(connectionSource, Account.class);
		
		Account account = new Account("葛方帅","123456");
		accountDao.create(account);
		
		connectionSource.close();
	}
}
