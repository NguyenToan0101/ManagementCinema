/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Movie implements Comparable<Movie> {

    private String title;
    private String director;
    private String movieDuration;
    private String genre;
    private Date premiereDate;
    private ArrayList<Showtimes> showtimes;
    private static final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public Movie(String title, String director, String movieDuration, String genre, String premiereDate) throws ParseException {
        this.title = title;
        this.director = director;
        this.movieDuration = movieDuration;
        this.genre = genre;
        setPremiereDate(premiereDate);
        this.showtimes = new ArrayList();
    }

    public Movie() {

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

    public ArrayList<Showtimes> getShowtimes() {
        return showtimes;
    }

    public void addShowtimes(Showtimes showtimes) {
        this.showtimes.add(showtimes);
    }

    public void setPremiereDate(String premiereDate) throws ParseException {

        this.premiereDate = date.parse(premiereDate);
    }

    @Override
    public String toString() {
        return String.format("| %-25s | %-20s | %-8s | %-18s | %-10s | ", title, director, movieDuration,genre, date.format(premiereDate));
    }

    @Override
    public int compareTo(Movie o) {
        return o.getPremiereDate().compareTo(this.getPremiereDate());
    }

}
