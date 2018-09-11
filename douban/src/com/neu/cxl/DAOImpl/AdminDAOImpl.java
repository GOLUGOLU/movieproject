package com.neu.cxl.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.neu.cxl.DAO.AdminDAO;
import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.ActorToMovie;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.DirectorToMovie;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.Utils.Utils;

public class AdminDAOImpl implements AdminDAO{
	
	private Connection conn=null;
	private Statement smt=null;
	private ResultSet rs=null;
	private PreparedStatement pre=null;

	@Override
	public int deleteMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "delete from douban_resource where movieid=?";
		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,resource.getMovieId());
		int n=pre.executeUpdate();
		this.conn.close();
		return n;
	}

	@Override
	public int updateMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "update douban_resource set moviename=?,avgscore=?,movietype=?,movieimgurl=?,moviereviewnumber=?,moviedescription=?,moviearea=?,movieyear=?,movietime=?,movielanguage=?,movieurl=?"
				+"where movieid=? ";
		//Resource r= new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, resource.getMovieName());
		pre.setString(2, resource.getAvgScore());
		pre.setString(3, resource.getMovieType());
		pre.setString(4, resource.getMovieImgUrl());
		pre.setString(5, resource.getMovieReviewNumber());
		pre.setString(6, resource.getMovieDescription());
		pre.setString(7, resource.getMovieArea());
		pre.setString(8, resource.getMovieYear());
		pre.setString(9, resource.getMovieTime());
		pre.setString(10, resource.getMovieLanguage());
		pre.setString(11, resource.getMovieUrl());
		pre.setString(12,resource.getMovieId());
		int n = pre.executeUpdate();// 无参数
		/*if (rs.next()) { // 如果可以next,代表查找到了这个用户的信息
		r.setMovieName(rs.getString("moviename"));
		r.setAvgScore(rs.getString("avgscore"));
		r.setMovieType(rs.getString("movietype"));
		r.setMovieImgUrl(rs.getString("movieimgurl"));
		r.setMovieReviewNumber(rs.getString("moviereviewnumber"));
		r.setMovieDescription(rs.getString("moviedescrption"));
		r.setMovieArea(rs.getString("moviearea"));
		r.setMovieYear(rs.getString("movieyear"));
		r.setMovieTime(rs.getString("movietime"));
		r.setMovieLanguage(rs.getString("movielanguage"));
		r.setMovieUrl(rs.getString("movieurl"));
		
		}*/
		this.conn.close();
		return n;
	}

	@Override
	public int addMovie(Resource resource) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="insert into  douban_resource (movieid,moviename,avgscore,movietype,movieimgurl,"
				+ "moviedescription,moviereviewnumber,moviearea,movieyear,movietime,movielanguage,movieurl)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,resource.getMovieId());
		pre.setString(2,resource.getMovieName());
		pre.setString(3,resource.getAvgScore());
		pre.setString(4,resource.getMovieType());
		pre.setString(5,resource.getMovieImgUrl());
		pre.setString(6,resource.getMovieDescription());
		pre.setString(7,"0");
		pre.setString(8,resource.getMovieArea());
		pre.setString(9,resource.getMovieYear());
		pre.setString(10,resource.getMovieTime());
		pre.setString(11,resource.getMovieLanguage());
		pre.setString(12,resource.getMovieUrl());
		int n=pre.executeUpdate();
		this.conn.close();
		return n;
	}

	//查找所有用户并以列表形式返回
	
		@SuppressWarnings("unchecked")
	public ArrayList<User> findAllUser() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException
		{
			this.conn = Utils.getConn();
			String sql="select * from douban_user";
			smt=conn.createStatement();	
			return Utils.toListUser((smt.executeQuery(sql)));
		
	}
		//查看用户评论
	public ArrayList<Review> selectReview(User user) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="select * from douban_review  where reviewuser=? order by reviewtime desc";
		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		
		pre.setString(1,user.getUserName());
		return Utils.toListReview((pre.executeQuery()));

		}

		@Override
	public int addActor(Actor actor) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			String sql="insert ignore into  douban_actor (actorid,actorname,actorsex,actorsign,actorbirthday,actorwork,actorborned,actorphoto,actorintroduction)"
					+ "values(?,?,?,?,?,?,?,?,?)";

			this.conn=Utils.getConn();
			pre=conn.prepareStatement(sql);
			pre.setString(1,actor.getActorId());
			pre.setString(2,actor.getActorName());
			pre.setString(3,actor.getActorSex());
			pre.setString(4,actor.getActorSign());
			pre.setString(5,actor.getActorBirthday());
			pre.setString(6,actor.getActorWork());
			pre.setString(7,actor.getActorBorned());
			pre.setString(8,actor.getActorPhoto());
			pre.setString(9,actor.getActorIntroduction());
			int n=pre.executeUpdate();
			this.conn.close();
			return n;
		}

		@Override
	public int addDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			String sql="insert ignore into  douban_director (directorid,directorname,directorsex,directorsign,directorbirthday,directorwork,directorborned,directorphoto,directorintroduction)"
					+ "values(?,?,?,?,?,?,?,?,?)";

			this.conn=Utils.getConn();
			pre=conn.prepareStatement(sql);
			pre.setString(1,director.getDirectorId());
			pre.setString(2,director.getDirectorName());
			pre.setString(3,director.getDirectorSex());
			pre.setString(4,director.getDirectorSign());
			pre.setString(5,director.getDirectorBirthday());
			pre.setString(6,director.getDirectorWork());
			pre.setString(7,director.getDirectorBorned());
			pre.setString(8,director.getDirectorPhoto());
			pre.setString(9,director.getDirectorIntroduction());
			int n=pre.executeUpdate();
			this.conn.close();
			return n;
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
	public int addCorrespondence(ActorToMovie at) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="insert into  douban_actortomovie (actorid,movieid) values(?,?)";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,at.getActorId());
		pre.setString(2,at.getResourceId());
		int n=pre.executeUpdate();
		this.conn.close();
		return n;
	}

	@Override
	public int addCorrespondence(DirectorToMovie dt) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql="insert into  douban_directortomovie (directorid,movieid) values(?,?)";

		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,dt.getDirectorId());
		pre.setString(2,dt.getResourceId());
		int n=pre.executeUpdate();
		this.conn.close();
		return n;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovie() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource ";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListResource((smt.executeQuery(sql)));
	}

	@Override
	public ArrayList<User> selectActor(Actor actor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_actor ";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListActor((smt.executeQuery(sql)));
	}

	@Override
	public ArrayList<User> selectDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_director ";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListDirector((smt.executeQuery(sql)));
	}

	@Override
	public int deleteActor(Actor actor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "delete from douban_actor where actorid=?";
		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,actor.getActorId());
		int n=pre.executeUpdate();
		this.conn.close();
		return n;
	}

	@Override
	public int deleteDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "delete from douban_director where directorid=?";
		this.conn=Utils.getConn();
		pre=conn.prepareStatement(sql);
		pre.setString(1,director.getDirectorId());
		int n=pre.executeUpdate();
		this.conn.close();
		return n;
	}

	@Override
	public int updateActor(Actor actor) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "update douban_actor set actorname=?,actorsex=?,actorsign=?,actorbirthday=?,actorwork=?,actorborned=?,actorphoto=?,actorintroduction=?"
				+"where actorid=? ";
		
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, actor.getActorName());
		pre.setString(2, actor.getActorSex());
		pre.setString(3, actor.getActorSign());
		pre.setString(4, actor.getActorBirthday());
		pre.setString(5, actor.getActorWork());
		pre.setString(6, actor.getActorBorned());
		pre.setString(7, actor.getActorPhoto());
		pre.setString(8, actor.getActorIntroduction());
		pre.setString(9, actor.getActorId());
		
		int n = pre.executeUpdate();// 无参数
		this.conn.close();
		return n;
	}

	@Override
	public int updateDirector(Director director) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "update douban_director set directorname=?,directorsex=?,directorsign=?,directorbirthday=?,directorwork=?,directorborned=?,directorphoto=?,directorintroduction=?"
				+"where directorid=? ";
		
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, director.getDirectorName());
		pre.setString(2, director.getDirectorSex());
		pre.setString(3, director.getDirectorSign());
		pre.setString(4, director.getDirectorBirthday());
		pre.setString(5, director.getDirectorWork());
		pre.setString(6, director.getDirectorBorned());
		pre.setString(7, director.getDirectorPhoto());
		pre.setString(8, director.getDirectorIntroduction());
		pre.setString(9, director.getDirectorId());
		
		int n = pre.executeUpdate();// 无参数
		this.conn.close();
		return n;
	}

	@Override
	public ArrayList<Actor> selectActorByNameKeyword(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_actor where actorname like ?";
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+s+"%");
		return Utils.toListActor((pre.executeQuery()));
	}

	@Override
	public ArrayList<Director> selectDirectorByNameKeyword(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_director where directorname like ?";
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+s+"%");
		return Utils.toListDirector((pre.executeQuery()));
	}

	@Override
	public ArrayList<Actor> selectActor()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_actor ";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListActor((smt.executeQuery(sql)));
	}

	@Override
	public ArrayList<Director> selectDirector()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_director ";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListDirector((smt.executeQuery(sql)));
	}

}
