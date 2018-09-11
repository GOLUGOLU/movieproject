package com.neu.cxl.Service;

import java.sql.SQLException;

import com.neu.cxl.Entity.User;

public interface UserService {
	public boolean register(User user) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;
	public User login(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public User selectInfo(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean updateInfo(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	public User checkUser(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean updatePassword(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	

}
