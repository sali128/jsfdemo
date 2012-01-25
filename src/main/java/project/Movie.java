package project;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Movie {

	public String name;
	public MovieType movieType;
	public int releaseYear;
	public int price;
	public boolean cleanBox;
	public boolean backup;
	public String movieBoxColor;
	
	public String movieTypeString;

	public Movie(String name, MovieType movieType, int releaseYear, int price) {
		this.name = name;
		this.movieType = movieType;
		this.releaseYear = releaseYear;
		this.price = price;
		this.cleanBox = true;
		this.backup = false;
		this.movieBoxColor = "white";

		this.movieTypeString = movieTypeString;
	}
/*
	public void printMovie() {
		System.out.println("Name: " + name + "\tMovie type: " + movieType
				+ "\tRelease year: " + releaseYear + "\tPrice: " + price);
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	@Min(1950)
	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Min(0)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isCleanBox() {
		return cleanBox;
	}

	public void setCleanBox(boolean cleanBox) {
		this.cleanBox = cleanBox;
	}

	public boolean isBackup() {
		return backup;
	}

	public void setBackup(boolean backup) {
		this.backup = backup;
	}

	public String getMovieBoxColor() {
		return movieBoxColor;
	}

	public void setMovieBoxColor(String movieBoxColor) {
		this.movieBoxColor = movieBoxColor;
	}

	public String getMovieTypeString() {
		return movieTypeString;
	}

	public void setMovieTypeString(String movieTypeString) {
		this.movieTypeString = movieTypeString;
	}

}
