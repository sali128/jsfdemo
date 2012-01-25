package entity;


public class Movie {
	enum GENRE {THRILLER,COMEDY}
	private GENRE genre;
	private String title;
	private int yearOfProduction;
	
	
	public Movie(GENRE genre, String title, int year) {
		this.genre = genre;
		this.title = title;
		this.yearOfProduction = year;
	}
	public GENRE getGenre() {
		return genre;
	}
	public void setGenre(GENRE genre) {
		this.genre = genre;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
}
