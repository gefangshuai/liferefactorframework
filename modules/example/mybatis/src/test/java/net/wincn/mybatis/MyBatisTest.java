package net.wincn.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.wincn.mybatis.mapper.UserMapper;
import net.wincn.mybatis.model.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisTest {

	/**
	 * 测试mybatis的配置文件加载及简单查询
	 * 
	 * @throws IOException
	 */
	@Test
	public void testConfig() throws IOException {
		SqlSession session = getSession();

		User user = (User) session.selectOne("net.wincn.mybatis.mapper.UserMapper.getUserByID", 1);
		System.out.println(user);
		closeSession(session);
	}

	@Test
	public void testInterface() throws IOException {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.getUserByID(1);
		List<User> users = mapper.listUsers("%g%");

		System.out.println(user);
		System.out.println(users.size());

		// 插入用户
		User user1 = new User();
		user1.setId(new Random(100).nextInt());
		user1.setName("shuai");
		user1.setEmail("gefangshuai@163.com");
		
//		mapper.addUser(user1);
		session.commit();

		// 查询map结果集
		List<Map<String, Object>> resultMap = mapper.listUsersAndRoles();
		
		//修改用户
		User user2 = new User();
		user2.setId(1);
		user2.setName("ge fang shuai");
		user2.setEmail("shuai@163.com");
		
		mapper.updateUser(user2);
		session.commit();
		closeSession(session);
	}

	private void closeSession(SqlSession session) {
		session.close();
	}

	private SqlSession getSession() throws IOException {
		return getSessionFactory().openSession();
	}

	private SqlSessionFactory getSessionFactory() throws IOException {
		Reader reader = Resources.getResourceAsReader("config/Configuration.xml");
		return new SqlSessionFactoryBuilder().build(reader);
	}
}
