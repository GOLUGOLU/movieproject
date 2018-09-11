package com.neu.cxl.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;



public class Utils {
	
	//鑾峰彇鏁版嵁搴撹繛鎺�
	public static Connection getConn() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
	Connection conn = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	String url="jdbc:mysql://localhost:3306/movie";
	String username="root";
	String password="123456";
	conn=DriverManager.getConnection(url,username,password);		

	return conn;
	}

	//resultSet杞珹rrayList
	public static ArrayList toListUser(ResultSet rs) throws SQLException
	{
		ArrayList list=new ArrayList();
		while(rs.next())
		{
		User u=new User();
		u.setUserName(rs.getString("username"));
		u.setSex(rs.getString("sex"));
		list.add(u);
		}
		return list;
		}	
	
	public static ArrayList toListResource(ResultSet rs) throws SQLException
	{
		ArrayList list=new ArrayList();
		while(rs.next())
		{
		Resource r=new Resource();
		r.setMovieId(rs.getString("movieid"));
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
		list.add(r);
		}
		return list;
		}
	
	
	
	public static ArrayList toListReview(ResultSet rs) throws SQLException
	{
		ArrayList list=new ArrayList();
		while(rs.next())
		{
		Review r=new Review();
		r.setReviewId(rs.getString("reviewid"));
		r.setReviewUser((rs.getString("reviewuser")));
		r.setReviewContent(rs.getString("reviewcontent"));
		r.setReviewGoodCount(rs.getString("reviewgoodcount"));
		r.setReviewMovieName(rs.getString("reviewmoviename"));
		r.setReviewTime(rs.getString("reviewtime"));
		r.setReviewMovieId(rs.getString("reviewmovieid"));
		r.setReviewScore(rs.getString("reviewscore"));
		list.add(r);
		}
		return list;
		}	
	
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
       
      }
	
	public static ArrayList toListActor(ResultSet rs) throws SQLException
	{
		ArrayList list=new ArrayList();
		while(rs.next())
		{
		Actor r=new Actor();
		r.setActorId(rs.getString("actorid"));
		r.setActorWork(rs.getString("actorwork"));
		r.setActorBirthday(rs.getString("actorbirthday"));
		r.setActorBorned(rs.getString("actorborned"));
		r.setActorIntroduction(rs.getString("actorintroduction"));
		r.setActorName(rs.getString("actorname"));
		r.setActorSex(rs.getString("actorsex"));
		r.setActorSign(rs.getString("actorsign"));
		r.setActorPhoto(rs.getString("actorphoto"));
		list.add(r);
		}
		return list;
		}	
	
	public static ArrayList toListDirector(ResultSet rs) throws SQLException
	{
		ArrayList list=new ArrayList();
		while(rs.next())
		{
		Director r=new Director();
		r.setDirectorId(rs.getString("directorid"));
		r.setDirectorWork(rs.getString("directorwork"));
		r.setDirectorBirthday(rs.getString("directorbirthday"));
		r.setDirectorBorned(rs.getString("directorborned"));
		r.setDirectorIntroduction(rs.getString("directorintroduction"));
		r.setDirectorName(rs.getString("directorname"));
		r.setDirectorSex(rs.getString("directorsex"));
		r.setDirectorSign(rs.getString("directorsign"));
		r.setDirectorPhoto(rs.getString("directorphoto"));
		list.add(r);
		}
		return list;
		}	
	
	public static boolean sendcode(String phone,String code) throws IOException
	{
		String codestr=URLEncoder.encode("#code#="+code,"utf-8");
		URL url=new URL("http://v.juhe.cn/sms/send?mobile="+phone+"&tpl_id=90713&tpl_value="+codestr+
				"&key=7dcf58361bde6e84e748997a2773f88a");
		URLConnection connection=url.openConnection();
		connection.connect();
	
		BufferedReader buff=new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8")); 
			
		StringBuffer buffer=new StringBuffer();
		String lineData=null;
		while((lineData=buff.readLine())!=null)
		{
			buffer.append(lineData);
		}
		buff.close();
		if(buffer.toString().indexOf("\"error_code\":0")>=0)
		{
			return true;
		}
	
		return false;
		
	}
}
