package com.neu.cxl.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;

public interface ReviewService {
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean deleteReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean publishReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean addReviewGoodCount(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	
	public ArrayList<Review> selectReview(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}