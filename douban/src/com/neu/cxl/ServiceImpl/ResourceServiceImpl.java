package com.neu.cxl.ServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.DAOImpl.ResourceDAOImpl;
import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.ResultSort;
import com.neu.cxl.Service.ResourceService;

public class ResourceServiceImpl implements ResourceService{

	private ResourceDAOImpl resourceDAOImpl=new ResourceDAOImpl();
	@Override
	public ArrayList<Resource> selectMovie()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.selectMovie();
	}

	@Override
	public ArrayList<Resource> selectMovieByNameKeyword(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.selectMovieByNameKeyword(s);
	}

	@Override
	public ArrayList<Resource> selectMovieByType(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.selectMovieByType(s);
	}

	@Override
	public ArrayList<Resource> selectMovieByYear(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.selectMovieByYear(s);
	}

	@Override
	public ArrayList<Resource> selectMovieByScore(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.selectMovieByScore(s);
	}

	@Override
	public ArrayList<Resource> selectMovieByActor(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.selectMovieByActor(s);
	}

	@Override
	public ArrayList<Resource> sortMovieByScore(ResultSort resultsort)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.sortMovieByScore(resultsort);
	}

	@Override
	public ArrayList<Resource> sortMovieByYear(ResultSort resultsort)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return resourceDAOImpl.sortMovieByYear(resultsort);
	}

	@Override
	public ArrayList<Resource> sortMovieByReviewNum(ResultSort resultsort)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		return resourceDAOImpl.sortMovieByReviewNum(resultsort);
	}

	@Override
	public ArrayList<Resource> selectMovieSortByScore()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return resourceDAOImpl.selectMovieSortByScore();
	}

	@Override
	public ArrayList<Resource> selectMovieSortByReviewNum() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return resourceDAOImpl.selectMovieSortByReviewNum();
	}

	@Override
	public ArrayList<Resource> selectMovie(ResultSort resultsort) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		return resourceDAOImpl.selectMovie(resultsort);
	}

	@Override
	public Resource selectMovieById(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return resourceDAOImpl.selectMovieById(s);
	}

	@Override
	public ArrayList<Actor> selectActorByMovieId(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return resourceDAOImpl.selectActorByMovieId(s);
	}

	@Override
	public ArrayList<Director> selectDirectorByMovieId(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return resourceDAOImpl.selectDirectorByMovieId(s);
	}

	@Override
	public ArrayList<Resource> selectMovieByActorId(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return resourceDAOImpl.selectMovieByActorId(s);
	}

	@Override
	public ArrayList<Resource> selectMovieByDirectorId(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return resourceDAOImpl.selectMovieByDirectorId(s);
	}

	@Override
	public ArrayList<Actor> selectActorById(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return resourceDAOImpl.selectActorById(s);
	}

	@Override
	public ArrayList<Director> selectDirectorById(String s)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return resourceDAOImpl.selectDirectorById(s);
	}

}
