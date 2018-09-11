package com.neu.cxl.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.neu.cxl.DAO.ReviewDAO;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.Utils.Utils;

public class ReviewDAOImpl implements ReviewDAO{
	private Connection conn=null;
	private Statement smt=null;
	private ResultSet rs=null;
	private PreparedStatement pre=null;

	@Override
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		String sql="select * from douban_review  where reviewuser=? order by reviewtime desc limit 10";
		Review r=new Review();
		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		
		pre.setString(1,user.getUserName());
		return Utils.toListReview((pre.executeQuery()));

	}

	@Override
	public int deleteReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="delete from douban_review where reviewid=?";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,review.getReviewId());

		int n=pre.executeUpdate();

		this.conn.close();
		return n;
	}

	@Override
	public int publishReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="insert into  douban_review (reviewid,reviewuser,reviewmovieid,reviewmoviename,reviewgoodcount,reviewtime,reviewcontent,reviewscore) "
				+ "values(?,?,?,?,?,?,?,?)";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,review.getReviewId());
		pre.setString(2,review.getReviewUser());
		pre.setString(3,review.getReviewMovieId());
		pre.setString(4,review.getReviewMovieName());
		pre.setString(5,"0");
		pre.setString(6,review.getReviewTime());
		pre.setString(7,review.getReviewContent());
		pre.setString(8, review.getReviewScore());

		int n=pre.executeUpdate();

		this.conn.close();
		return n;

	}

	@Override
	public int addReviewGoodCount(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="update douban_review set reviewgoodcount=reviewgoodcount+1 where reviewid=?";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,review.getReviewId());

		int n=pre.executeUpdate();

		this.conn.close();
		return n;

	}

	@Override
	public ArrayList<Review> selectReview(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql="select * from douban_review  where reviewmovieid=? order by reviewtime desc limit 10";
		Review r=new Review();
		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		
		pre.setString(1,s);
		return Utils.toListReview((pre.executeQuery()));

	}
	

}
