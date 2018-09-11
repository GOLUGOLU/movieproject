package com.neu.cxl.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.ActorToMovie;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.DirectorToMovie;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;

public interface AdminService {
	
	public boolean deleteMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean updateMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean addActor(Actor actor) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public boolean addDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean addMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean addCorrespondence(ActorToMovie at) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean addCorrespondence(DirectorToMovie dt) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean deleteReview(Review review) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<User> findAllUser() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Resource> selectMovie() throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

	public ArrayList<User> selectActor(Actor actor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<User> selectDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException; 
	public boolean deleteActor(Actor actor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean deleteDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean updateActor(Actor actor) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public boolean updateDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;

	public ArrayList<Actor> selectActorByNameKeyword(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<Director> selectDirectorByNameKeyword(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;

	public ArrayList<Actor> selectActor() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Director> selectDirector() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
