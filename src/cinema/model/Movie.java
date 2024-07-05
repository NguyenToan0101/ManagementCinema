/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Movie implements Comparable<Movie>{
    private String title;
    private String director;
    private String movieDuration;
    private String genre;
    private Date premiereDate;

    public Movie(String title, String director, String movieDuration, String genre, String premiereDate) throws ParseException {
        this.title = title;
        this.director = director;
        this.movieDuration = movieDuration;
        this.genre = genre;
        setPremiereDate(premiereDate);
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

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
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

    public void setPremiereDate(String premiereDate) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        this.premiereDate = date.parse(premiereDate);
    }



    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", director=" + director + ", movieDuration=" + movieDuration + ", genre=" + genre + ", premiereDate=" + premiereDate + '}';
    }

    @Override
    public int compareTo(Movie o) {
        return o.getPremiereDate().compareTo(this.getPremiereDate());
    }
    
   
    
}
