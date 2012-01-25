package services;


import java.io.IOException;
import java.sql.*;
import java.util.*;

import project.*;


public class PersonMovieDBManager {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addMovieToPersonStmt;
	private PreparedStatement deleteAllPersonMovieStmt;
	private PreparedStatement deleteAllMovieFromPersonStmt;
	private PreparedStatement getMoviePersonStmt;

	public PersonMovieDBManager() 
	{
		try 
		{
			
			conn = DriverManager
					.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

			stmt = conn.createStatement();
			boolean personTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);

			while (rs.next()) 
			{
				if ("PersonMovie".equalsIgnoreCase(rs.getString("TABLE_NAME"))) 
				{
					personTableExists = true;
					break;
				}
			}

			if (!personTableExists) 
			{
				stmt.executeUpdate("CREATE TABLE personMovie(person_id int, movie_id int, CONSTRAINT person_id_fk FOREIGN KEY (person_id) REFERENCES person (id), CONSTRAINT movie_id_fk FOREIGN KEY (movie_id) REFERENCES movie (id))");
			}
			
			addMovieToPersonStmt = conn.prepareStatement("INSERT INTO personMovie (person_id, movie_id) VALUES (?, ?)");
			
			deleteAllMovieFromPersonStmt = conn.prepareStatement("DELETE FROM personMovie WHERE person_id = ?");
			
			deleteAllPersonMovieStmt = conn.prepareStatement("DELETE FROM personMovie");
			
			getMoviePersonStmt = conn.prepareStatement("SELECT Movie.name, Movie.movieType, Movie.releaseYear, Movie.price FROM Movie, PersonMovie WHERE person_id = ? and movie_id = Movie.id");

		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}
	
	
	public void addMovieToPerson(List<Integer> listPersonId, List<Integer> listMovieId) 
	{
		try 
		{
			for (Integer personID : listPersonId)
			{
				for (Integer movieID : listMovieId)
				{
					addMovieToPersonStmt.setInt(1, personID);
					addMovieToPersonStmt.setInt(2, movieID);
					addMovieToPersonStmt.executeUpdate();
				}
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	
	public void deleteAllMovieFromPerson (List<Integer> listPersonId) 
	{
		try 
		{
			for (Integer personID : listPersonId)
			{
					deleteAllMovieFromPersonStmt.setInt(1, personID);
					deleteAllMovieFromPersonStmt.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	
	public void deleteAllPersonMovie () 
	{
		try 
		{
				deleteAllPersonMovieStmt.executeUpdate();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	/*
	public List<Movie> getPersonMovie (List<Integer> listPersonId)
	{
		List<Movie> Movies = new ArrayList<Movie>();
		try 
		{
			for (Integer personID : listPersonId)
			{
				getMoviePersonStmt.setInt(1, personID);
				ResultSet rs = getMoviePersonStmt.executeQuery();
				while (rs.next()) 
				{
					MovieType movieType = null;
					if (rs.getString("movieType").equals("Action"))
						movieType = MovieType.Action;
					if (rs.getString("movieType").equals("Adventure"))
						movieType = MovieType.Adventure;
					if (rs.getString("movieType").equals("Shooter"))
						movieType = MovieType.Thriller;
					if (rs.getString("movieType").equals("Fighting"))
						movieType = MovieType.Fighting;
					if (rs.getString("movieType").equals("Strategy"))
						movieType = MovieType.Strategy;
					if (rs.getString("movieType").equals("Sport"))
						movieType = MovieType.Sport;
					if (rs.getString("movieType").equals("Racing"))
						movieType = MovieType.Racing;
						
					Movies.add(new Movie(rs.getString("name"),movieType,rs.getInt("releaseYear"),rs.getInt("price")));
				}
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return Movies;
	}
	*/

	

}
