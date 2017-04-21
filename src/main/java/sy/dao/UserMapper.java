package sy.dao;

import java.util.List;
import java.util.Map;

import sy.model.User;
import sy.model.UserRole;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<UserRole>  getAll();
	List<UserRole>  getAllLeftJoin();
	List<UserRole>  getAllUserLeftjoinRole();
}