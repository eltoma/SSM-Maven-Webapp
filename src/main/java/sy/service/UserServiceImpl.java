package sy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserMapper;
import sy.model.User;
import sy.model.UserRole;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserRole> getAll() {
		return userMapper.getAll();
	}

	@Override
	public List<UserRole> getAllLeftJoin() {
		return userMapper.getAllLeftJoin();
	}

	@Override
	public List<UserRole> getAllUserLeftjoinRole() {
		return userMapper.getAllUserLeftjoinRole();
	}

}
