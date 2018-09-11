package com.neu.cxl.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;

public interface ReviewDAO {
	
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int deleteReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int publishReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int addReviewGoodCount(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Review> selectReview(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
