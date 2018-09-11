package com.neu.cxl.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.ResultSort;

public interface ResourceDAO {
	
	public ArrayList<Resource> selectMovie() throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public Resource selectMovieById(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> selectMovieByNameKeyword(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> selectMovieByType(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> selectMovieByYear(String s) throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> selectMovieByScore(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> selectMovieByActor(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
	public ArrayList<Resource> sortMovieByScore(ResultSort resultsort) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> sortMovieByYear(ResultSort resultsort) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Resource> sortMovieByReviewNum(ResultSort resultsort) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Resource> selectMovieSortByScore() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Resource> selectMovieSortByReviewNum() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	public  ArrayList<Resource> selectMovie(ResultSort resultsort) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	public ArrayList<Actor> selectActorByMovieId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Director> selectDirectorByMovieId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Resource> selectMovieByActorId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Resource> selectMovieByDirectorId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	public ArrayList<Actor> selectActorById(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Director> selectDirectorById(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
