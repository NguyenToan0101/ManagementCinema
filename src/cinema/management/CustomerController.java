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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

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


        for (int i = 0; i < moviesList.getMovieList().size(); i++) {
            System.out.println((i + 1) + "." + moviesList.getMovieList().get(i));

        }
//Select Movie ( Just select movie 1 and movie 2 (Demo) )
        int selectMovie = Utils.getNumber("Choose a movie by entering the corresponding number: ",
                String.format("Invalid value.Please select again ( 1 - %d)", movies.size()), 1, movies.size(), Integer::parseInt);

        Movie selectedMovie = movies.get(selectMovie - 1);

        System.out.println("Available the show times of " + selectedMovie.getTitle() + ":");

        ArrayList<Showtimes> showtime = selectedMovie.getShowtimes();
        for (int i = 0; i < showtime.size(); i++) {
            System.out.println((i + 1) + "." + showtime.get(i));
        }
//Select showtime of each movie
        int selectShowtime = Utils.getNumber("Choose a showtime by entering the correspoding number : ",
                String.format("Invalid value.Please select again ( 1 - %d)", showtime.size()), 1, showtime.size(), Integer::parseInt);
        Showtimes selectedShowtime = showtime.get(selectShowtime - 1);

        System.out.println("Available the auditorium of " + selectedShowtime.getShowtimes() + ":");
        ArrayList<Auditorium> auditoriums = selectedShowtime.getAuditoriums();
        for (int i = 0; i < auditoriums.size(); i++) {
            System.out.println((i + 1) + "." + auditoriums.get(i));
        }
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
        
        long price = (long) ticket.calculateTicketPrice(selectSeat, selectTypePerson, selectedShowtime.getShowtimes(), selectedShowtime.getShowtimes());
       
        if(price == -1){
            System.out.println("-------------------\nSorry.Invalid value hour of showtime\nPlease select again: ");
            ticketBooking();
        }else{
        System.out.printf("------------------------\nBill : " + ticket.formatCurrency(price) + "\n");}
        
        
    }
}
