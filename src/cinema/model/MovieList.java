/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class MovieList {

    private ArrayList<Movie> movieList;

    public MovieList() {
        movieList = new ArrayList<>();

    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    public boolean isEmptyList() {
        return movieList.isEmpty();
    }

    public void addNew(Movie mv) {
        movieList.add(mv);
    }

    public void readFile(String filename) {
        String stf;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((stf = br.readLine()) != null) {
                String[] b = stf.split(":");
                if (b.length == 5) {
                    try {
                        addNew(new Movie(b[0], b[1], b[2], b[3], b[4]));
                    } catch (Exception e) {
                        System.out.println("Error reading staff list file" + e.getMessage());
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(StaffList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Movie movie : movieList) {
                bw.write(movie.getTitle() + ":" + movie.getDirector() + ":" + movie.getMovieDuration() + ":" + movie.getGenre() + ":" + movie.getPremiereDate());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void getAllMovies(ArrayList<Movie> movieList) {
        System.out.println("-------------------------------| List Of Staff |-------------------------------");
        if (movieList.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            for (Movie movie : movieList) {
            }
            System.out.println(movieList + "\n");
            System.out.println("---------------------------------------------------------------------------");
        }
    }

    public void addMovie() throws ParseException {
        String title = formatName(Utils.getValue("Enter movie name: "));
        String director = formatName(Utils.getValue("Enter director name: "));
        String movieDuration = Utils.getValue("Enter movie duration: ");
        String genre = Utils.getValue("Enter genre: ");
        String premiereDate = Utils.getValue("Enter date of birth(dd/MM/yyyy): ");;

        Movie newSMovie = new Movie(title, director, movieDuration, genre, premiereDate);

    }

    public void sortMovieByTitle() {

        movieList.sort(Comparator.comparing(Movie::getTitle));
    }

    public void sortMovieByDirector() {

        movieList.sort(Comparator.comparing(Movie::getDirector));
    }

    public void sortMovieByMovieDuration() {

        movieList.sort(Comparator.comparing(Movie::getMovieDuration));
    }

    public void sortMovieByGenre() {

        movieList.sort(Comparator.comparing(Movie::getGenre));
    }

    public void sortMovieByPremiereDate() {

        Collections.sort(movieList);
    }

    public ArrayList<Movie> searchStaff(Predicate<Movie> mv) {
        ArrayList<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movieList) {
            if (mv.test(movie)) {
                searchResults.add(movie);
            }
        }
        return searchResults;
    }

    public static String formatName(String name) {

        name = name.replaceAll("[^a-zA-Z]", " ");

        name = name.replaceAll("\\s+", " ");

        String[] words = name.split("\\s+");

        StringBuilder norm = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                String capital = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                norm.append(capital).append(" ");
            }

        }
        return norm.toString().trim();
    }
}
