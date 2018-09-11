package com.neu.cxl.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.neu.cxl.Entity.ResultSort;
import com.neu.cxl.DAO.ResourceDAO;
import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Utils.Utils;

public class ResourceDAOImpl implements ResourceDAO{

	private Connection conn=null;
	private Statement smt=null;
	private ResultSet rs=null;
	private PreparedStatement pre=null;
	
	
	@SuppressWarnings("unchecked")
	@Override
	//首页显示电影
	public ArrayList<Resource> selectMovie() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			String sql = "select * from douban_resource ";
			this.conn = Utils.getConn();
			smt=conn.createStatement();	
			return Utils.toListResource((smt.executeQuery(sql)));
		
}

	@SuppressWarnings("unchecked")
	@Override
	
	public ArrayList<Resource> selectMovieByNameKeyword(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
	
		String sql = "select * from douban_resource where moviename like ?";
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+s+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieByType(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where movietype like ?";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+s+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieByYear(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where movieyear like ?";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+s+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieByScore(String s) throws  SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where avgscore > ?";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieByActor(String s) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where movieactorid like ?";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+s+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> sortMovieByScore(ResultSort resultsort) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where ? like ? order by avgscore desc";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, resultsort.getSelectType());
		pre.setString(2, "%"+resultsort.getKeyword()+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> sortMovieByYear(ResultSort resultsort) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_resource where ? like ? order by movieyear desc";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, resultsort.getSelectType());
		pre.setString(2, "%"+resultsort.getKeyword()+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> sortMovieByReviewNum(ResultSort resultsort) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where ? like ? order by moviereviewnumber desc";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, resultsort.getSelectType());
		pre.setString(2, "%"+resultsort.getKeyword()+"%");
		return Utils.toListResource((pre.executeQuery()));
	}

	//高分推荐
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieSortByScore() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_resource desc avgscore";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListResource((smt.executeQuery(sql)));
	}
	//热度排行榜
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieSortByReviewNum() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_resource order by moviereviewnumber desc  limit 10";
		this.conn = Utils.getConn();
		smt=conn.createStatement();	
		return Utils.toListResource((smt.executeQuery(sql)));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovie(ResultSort resultsort) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_resource where ? like ? ";
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, resultsort.getSelectType());
		
		pre.setString(2, "%"+resultsort.getKeyword()+"%");
		return Utils.toListResource((pre.executeQuery()));
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Resource selectMovieById(String s)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sql = "select * from douban_resource where movieid = ?";
		Resource r = new Resource();
		this.conn = Utils.getConn();
		
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		rs = pre.executeQuery();
		if(rs.next())
		{
		r.setMovieId(s);
		r.setMovieName(rs.getString("moviename"));
		r.setAvgScore(rs.getString("avgscore"));
		r.setMovieArea(rs.getString("moviearea"));
		r.setMovieDescription(rs.getString("moviedescription"));
		r.setMovieImgUrl(rs.getString("movieimgurl"));
		r.setMovieReviewNumber(rs.getString("moviereviewnumber"));
		r.setMovieType(rs.getString("movietype"));
		r.setMovieYear(rs.getString("movieyear"));
		r.setMovieActor(rs.getString("movieactorid"));
		r.setMovieLanguage(rs.getString("movielanguage"));
		//r.setMovieDirector(rs.getString("moviedirector"));
		r.setMovieTime(rs.getString("movietime"));
		r.setMovieUrl(rs.getString("movieurl"));
		
		}
		this.conn.close();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Actor> selectActorByMovieId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_actor where actorid in (select actorid from douban_actortomovie where movieid = ?)";
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListActor((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Director> selectDirectorByMovieId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from douban_director where directorid in (select directorid from douban_directortomovie where movieid = ?)";
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListDirector((pre.executeQuery()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Resource> selectMovieByActorId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from douban_resource where movieid in (select movieid from douban_actortomovie where actorid = ?)";
	
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListResource((pre.executeQuery()));
	}

	@Override
	public ArrayList<Resource> selectMovieByDirectorId(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String sql = "select * from douban_resource where movieid in (select movieid from douban_directortomovie where directorid = ?)";
		
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListResource((pre.executeQuery()));
	}

	@Override
	public ArrayList<Actor> selectActorById(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from douban_actor where actorid = ?";
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListActor((pre.executeQuery()));
	}

	@Override
	public ArrayList<Director> selectDirectorById(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from douban_director where directorid = ?";
		//Resource r = new Resource();
		this.conn = Utils.getConn();
		pre = conn.prepareStatement(sql);
		pre.setString(1, s);
		return Utils.toListDirector((pre.executeQuery()));
	}



}
