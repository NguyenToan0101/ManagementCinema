/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Movie {
    private String title;
    private String director;
    private int movieDuration;
    private String genre;
    private Date premiereDate;

    public Movie(String title, String director, int movieDuration, String genre, Date premiereDate) {
        this.title = title;
        this.director = director;
        this.movieDuration = movieDuration;
        this.genre = genre;
        this.premiereDate = premiereDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", director=" + director + ", movieDuration=" + movieDuration + ", genre=" + genre + ", premiereDate=" + premiereDate + '}';
    }
    
   
    
}
