package com.neu.cxl.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.DAOImpl.ReviewDAOImpl;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.Service.ReviewService;

public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDAOImpl reviewDAOImpl=new ReviewDAOImpl();
	@Override
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
			return reviewDAOImpl.selectReview(user);
	}

	@Override
	public boolean deleteReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
			if(reviewDAOImpl.deleteReview(review)>0)
			{
				return true;
			}
			else 
				{
					return false;
				}
			
	}

	@Override
	public boolean publishReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	if(reviewDAOImpl.publishReview(review)>0)
	{
		return true;
	}
	else 
		{
			return false;
		}
	}

	@Override
	public boolean addReviewGoodCount(Review review)throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(reviewDAOImpl.addReviewGoodCount(review)>0)
		{
			return true;
		}
		else 
			{
				return false;
			}
	}

	@Override
	public ArrayList<Review> selectReview(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return reviewDAOImpl.selectReview(s);
	}

}
