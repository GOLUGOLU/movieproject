package com.neu.cxl.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.neu.cxl.DAO.UserDAO;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.Utils.Utils;

public class UserDAOImpl implements UserDAO {
	private Connection conn=null;
	private Statement smt=null;
	private ResultSet rs=null;
	private PreparedStatement pre=null;
	
	//注册
	public int userRegister(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		
		String sql="insert into  douban_user (userid,username,password,sex,age,phone,email,role) "
				+ "values(?,?,?,?,?,?,?,?)";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,user.getUserId());
		pre.setString(2,user.getUserName());
		pre.setString(3,user.getPassword());
		pre.setString(4,user.getSex());
		pre.setString(5,user.getAge());
		pre.setString(6,user.getPhone());
		pre.setString(7,user.getEmail());
		pre.setString(8,"普通会员");
		int n=pre.executeUpdate();

		this.conn.close();
		return n;
	}
	
	//查找用户(登录检查)
	public User findUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		String sql = "select * from douban_user where username=? and password=?";
		User u = new User();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, user.getUserName());
		pre.setString(2, user.getPassword());
		rs = pre.executeQuery();// 无参数
		if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息，就将结果集中的信息封装到User对象中.
		
		u.setUserName(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setSex(rs.getString("sex"));
		u.setAge(rs.getString("age"));
		u.setPhone(rs.getString("phone"));
		u.setEmail(rs.getString("email"));
		u.setIntroduction(rs.getString("introduction"));
		u.setRole(rs.getString("role"));
		}
		this.conn.close();
		return u;
	}
	
	
	//查看资料
	public User selectInfo(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		String sql = "select * from douban_user where username=? ";
		User u = new User();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, user.getUserName());
		rs = pre.executeQuery();// 无参数
		if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息，就将结果集中的信息封装到User对象中.
		u.setUserName(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setAge(rs.getString("age"));
		u.setEmail(rs.getString("email"));
		u.setPhone(rs.getString("phone"));
		u.setSex(rs.getString("sex"));
		u.setRole(rs.getString("role"));
		}
		this.conn.close();
		return u;
	}
	
	//修改资料
	public int updateInfo(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		String sql = "update douban_user set sex=?,age=?,phone=?,email=?,introduction=? where username=? ";
		User u = new User();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, user.getSex());
		pre.setString(2, user.getAge());
		pre.setString(3, user.getPhone());
		pre.setString(4, user.getEmail());
		pre.setString(5, user.getIntroduction());
		pre.setString(6, user.getUserName());

		int n = pre.executeUpdate();// 无参数
		/*if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息，就将结果集中的信息封装到User对象中.
		//u.setUserName(rs.getString("username"));
		//u.setPassword(rs.getString("password"));
		u.setAge(rs.getString("age"));
		u.setEmail(rs.getString("email"));
		u.setPhone(rs.getString("phone"));
		u.setSex(rs.getString("sex"));
		u.setIntroduction(rs.getString("introduction"));
		}*/
		this.conn.close();
		return n;
	}

	@Override
	public User checkUser(User user)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_user where username=? ";
		User u = new User();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, user.getUserName());
		rs = pre.executeQuery();// 无参数
		if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息，就将结果集中的信息封装到User对象中.
		
		u.setUserName(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setSex(rs.getString("sex"));
		u.setAge(rs.getString("age"));
		u.setPhone(rs.getString("phone"));
		u.setEmail(rs.getString("email"));
		u.setIntroduction(rs.getString("introduction"));
		u.setRole(rs.getString("role"));
		}
		this.conn.close();
		return u;
	}
	
	public int updatePassword(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		String sql = "update douban_user set password=? where username=? ";
		//User u = new User();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, user.getPassword());
		pre.setString(2, user.getUserName());

		int n = pre.executeUpdate();// 无参数
		/*if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息，就将结果集中的信息封装到User对象中.
		//u.setUserName(rs.getString("username"));
		//u.setPassword(rs.getString("password"));
		u.setAge(rs.getString("age"));
		u.setEmail(rs.getString("email"));
		u.setPhone(rs.getString("phone"));
		u.setSex(rs.getString("sex"));
		u.setIntroduction(rs.getString("introduction"));
		}*/
		this.conn.close();
		return n;
	}

	}
	
	
