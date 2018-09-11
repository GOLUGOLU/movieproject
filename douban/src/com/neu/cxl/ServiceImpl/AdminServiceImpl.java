package com.neu.cxl.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.DAOImpl.AdminDAOImpl;
import com.neu.cxl.DAOImpl.UserDAOImpl;
import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.ActorToMovie;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.DirectorToMovie;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.Service.AdminService;

public class AdminServiceImpl implements AdminService{

	private AdminDAOImpl adminDAOImpl=new AdminDAOImpl();
	
	@Override
	public boolean deleteMovie(Resource resource)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		if(adminDAOImpl.deleteMovie(resource)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateMovie(Resource resource)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.updateMovie(resource)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean addActor(Actor actor)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(adminDAOImpl.addActor(actor)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean addDirector(Director director)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.addDirector(director)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean addMovie(Resource resource)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.addMovie(resource)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean addCorrespondence(ActorToMovie at)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.addCorrespondence(at)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean addCorrespondence(DirectorToMovie dt)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.addCorrespondence(dt)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteReview(Review review)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.deleteReview(review)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public ArrayList<User> findAllUser()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		return adminDAOImpl.findAllUser();
	}

	@Override
	public ArrayList<Review> selectReview(User user)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return adminDAOImpl.selectReview(user);
	}

	@Override
	public ArrayList<Resource> selectMovie()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		return adminDAOImpl.selectMovie();
	}

	@Override
	public ArrayList<User> selectActor(Actor actor)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return adminDAOImpl.selectActor(actor);
	}

	@Override
	public ArrayList<User> selectDirector(Director director)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return adminDAOImpl.selectDirector(director);
	}

	@Override
	public boolean deleteActor(Actor actor)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.deleteActor(actor)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteDirector(Director director)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.deleteDirector(director)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateActor(Actor actor)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if(adminDAOImpl.updateActor(actor)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateDirector(Director director)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(adminDAOImpl.updateDirector(director)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public ArrayList<Actor> selectActorByNameKeyword(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return adminDAOImpl.selectActorByNameKeyword(s);	}

	@Override
	public ArrayList<Director> selectDirectorByNameKeyword(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return adminDAOImpl.selectDirectorByNameKeyword(s);	
	}

	@Override
	public ArrayList<Actor> selectActor() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return adminDAOImpl.selectActor();
	}

	@Override
	public ArrayList<Director> selectDirector() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return adminDAOImpl.selectDirector();
	}

}
