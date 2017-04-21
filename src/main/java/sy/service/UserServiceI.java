package sy.service;

import java.util.List;
import java.util.Map;

import sy.model.User;
import sy.model.UserRole;

public interface UserServiceI {
	public User getUserById(String id);
	public List<UserRole>  getAll();
	public List<UserRole>  getAllLeftJoin();
	public List<UserRole>  getAllUserLeftjoinRole();

}
