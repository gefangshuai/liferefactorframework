package net.wincn.mybatis.mapper;

import java.util.List;
import java.util.Map;

import net.wincn.mybatis.model.User;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

	public User getUserByID(@Param("id") Integer userId);

	public List<User> listUsers(@Param("name") String name);

	public void addUser(User user);

	public List<Map<String, Object>> listUsersAndRoles();
	
	public void updateUser(User user);
}