package com.neu.cxl.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;

public interface UserDAO {
	public int userRegister(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
	public User findUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public User checkUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public User selectInfo(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public int updateInfo(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public int updatePassword(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
}
