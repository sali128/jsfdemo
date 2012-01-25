package project;

import java.util.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Client {

	String name;
	List<Movie> listOfMovie = new ArrayList<Movie>();
	Date dateOfBirth = new Date();

	public Client(String name, Date dateOfBirth) {
		this.name = name;
		this.listOfMovie = new ArrayList<Movie>();
		this.dateOfBirth = dateOfBirth;
	}
	
	@Size(min = 1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getListOfMovie() {
		return listOfMovie;
	}

	public void setListOfMovie(List<Movie> listOfMovie) {
		this.listOfMovie = listOfMovie;
	}

	@Past
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
