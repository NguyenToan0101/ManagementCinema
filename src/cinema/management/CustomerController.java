/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.management;

import cinema.model.Auditorium;
import cinema.model.Movie;
import cinema.model.MovieList;
import cinema.model.Showtimes;
import cinema.model.Utils;
import cinema.model.Ticket;
import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 *
 * @author ADMIN
 */
public class CustomerController {

    MovieList moviesList;
    Ticket ticket;
   
    public CustomerController() {
        moviesList = new MovieList();
        ticket = new Ticket();
        
    }

    public void ticketBooking() {
        System.out.println("You are : \n"
                + "1.Adult\n"
                + "2.Student\n"
                + "3.Children, elders\n"
                + "4.Member\n");
        int selectTypePerson = Utils.getNumber("Select your type : ", "Invalid value\nPlease input (1-3)",
                0, 4, Integer::parseInt);
        ArrayList<Movie> movies = new ArrayList();

        ticket.initializeData(movies);
        movies = Utils.removeDuplicates(movies);
    Utils.displayList("List of movie", movies);
//Select Movie ( Just select movie 1 and movie 2 (Demo) )
        int selectMovie = Utils.getNumber("Choose a movie by entering the corresponding number: ",
                String.format("Invalid value.Please select again ( 1 - %d)", movies.size()), 1, movies.size(), Integer::parseInt);

        Movie selectedMovie = movies.get(selectMovie - 1);
        
ArrayList<Showtimes> showtime = selectedMovie.getShowtimes();
    showtime = Utils.removeDuplicates(showtime);
    Utils.displayList("Available the show times of " + selectedMovie.getTitle() + ":", showtime);
    
//Select showtime of each movie
        int selectShowtime = Utils.getNumber("Choose a showtime by entering the correspoding number : ",
                String.format("Invalid value.Please select again ( 1 - %d)", showtime.size()), 1, showtime.size(), Integer::parseInt);
        Showtimes selectedShowtime = showtime.get(selectShowtime - 1);

        ArrayList<Auditorium> auditoriums = selectedShowtime.getAuditoriums();
        auditoriums = Utils.removeDuplicates(auditoriums);
Utils.displayList("Available the auditorium of " + selectedShowtime.getShowtimes() + ":", auditoriums);
//Select auditorium of each showtime
        int selectAuditorium = Utils.getNumber("Choose an auditorium by entering the correspoding number : ",
                String.format("Invalid value.Please select again ( 1 - %d)", auditoriums.size()), 1, auditoriums.size(), Integer::parseInt);
        Auditorium selectedAuditorium = auditoriums.get(selectAuditorium - 1);

        System.out.println("Available the seat of " + selectedAuditorium.getNameRoom() + ":");
        selectedAuditorium.displaceSeats();

// Select seat of each auditorium
        String selectSeat = Utils.getStringID("\nChoose seat :", "Invalid value.Please select again(A-E and 1-15)"
                + "\nEx: A2, B12, etc...", "[A-E]([1-9]|1[0-5])");
        boolean check = false;
        while (!check) {
            if (!selectedAuditorium.bookedSeat(selectSeat)) {
                System.out.println("Seat " + selectSeat + " has been successfully booked");
                selectedAuditorium.bookSeat(selectSeat);
                check = true;
            } else {
                System.out.println("Failed to book seat " + selectSeat + ". It may already be booked or invalid.");
                selectSeat = Utils.getStringID("\nChoose seat :", "Invalid value.Please select again(A-E and 1-15)"
                        + "\nEx: A2, B12, etc...", "[A-E]([1-9]|1[0-5])");
            }
        }

        double price = (double) ticket.calculateTicketPrice(selectSeat, selectTypePerson, selectedShowtime.getShowtimes(), selectedShowtime.getShowtimes());


    ticket.displayBill(selectedMovie.getTitle(),selectedMovie.getMovieDuration(), selectedShowtime.getShowtimes(), selectSeat, selectSeat, price);

    }
}
