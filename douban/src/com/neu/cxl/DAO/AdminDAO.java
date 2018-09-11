package com.neu.cxl.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.ActorToMovie;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.DirectorToMovie;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;

public interface AdminDAO {
	public int deleteMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int updateMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int addActor(Actor actor) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public int addDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int addMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int addCorrespondence(ActorToMovie at) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int addCorrespondence(DirectorToMovie dt) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int deleteReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<User> findAllUser() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Resource> selectMovie() throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<User> selectActor(Actor actor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<User> selectDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException; 
	public int deleteActor(Actor actor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int deleteDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public int updateActor(Actor actor) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public int updateDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	
	public ArrayList<Actor> selectActorByNameKeyword(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Director> selectDirectorByNameKeyword(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

	public ArrayList<Actor> selectActor() throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Director> selectDirector() throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
}
