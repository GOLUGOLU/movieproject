package com.neu.cxl.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.DAOImpl.UserDAOImpl;
import com.neu.cxl.Entity.User;
import com.neu.cxl.Service.UserService;

public class UserServiceImpl implements UserService{
	
		private UserDAOImpl userDAOImpl=new UserDAOImpl();
		
		public boolean register(User user) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
		{
			if(userDAOImpl.userRegister(user)>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public User login(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			return userDAOImpl.findUser(user);
		}
		
		public User selectInfo(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
		{
			
			return userDAOImpl.selectInfo(user);
		}

		@Override
		public boolean updateInfo(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			if(userDAOImpl.updateInfo(user)>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		@Override
		public User checkUser(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			return userDAOImpl.checkUser(user);
		}

		@Override
		public boolean updatePassword(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			if(userDAOImpl.updatePassword(user)>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
	}



