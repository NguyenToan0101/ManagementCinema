/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author ADMIN
 */
public class Ticket {

    MovieList moviesList;
    ShowtimesList showtimesList;
    AuditoriumList auditoriumList;
    Movie movie;
    public Ticket() {
        moviesList = new MovieList();
        showtimesList = new ShowtimesList();
        auditoriumList = new AuditoriumList();
        movie =  new Movie();
    }

    public Movie getMovie() {
        return movie;
    }

// Example of initialization movie 1 and movie 2
    public void initializeData(ArrayList<Movie> movieList) {
        Movie movieS1 = moviesList.getMovieList().get(0);

        Movie movieS2 = moviesList.getMovieList().get(1);
        Auditorium auditoriumS1 = auditoriumList.getAuditoriumList().get(0);
        Auditorium auditoriumS2 = auditoriumList.getAuditoriumList().get(1);
        Auditorium auditoriumS3 = auditoriumList.getAuditoriumList().get(2);
        Auditorium auditoriumS4 = auditoriumList.getAuditoriumList().get(3);
    
        
        auditoriumS1.bookSeat("D2");
        auditoriumS1.bookSeat("B12");
        auditoriumS1.bookSeat("E2");
        auditoriumS1.bookSeat("D7");

        
        auditoriumS2.bookSeat("A2");
        auditoriumS2.bookSeat("D6");
        auditoriumS2.bookSeat("C15");
        auditoriumS2.bookSeat("A5");

        auditoriumS3.bookSeat("A1");
        auditoriumS3.bookSeat("C6");
        auditoriumS3.bookSeat("A15");
        auditoriumS3.bookSeat("D12");

        auditoriumS4.bookSeat("D1");
        auditoriumS4.bookSeat("E6");
        auditoriumS4.bookSeat("D15");
        auditoriumS4.bookSeat("D14");

        

        Showtimes showtimesS1 = showtimesList.getShowtimesList().get(0);
        showtimesS1.addAuditoriums(auditoriumS1);
        showtimesS1.addAuditoriums(auditoriumS3);

        Showtimes showtimesS2 = showtimesList.getShowtimesList().get(1);
        showtimesS2.addAuditoriums(auditoriumS2);
        showtimesS2.addAuditoriums(auditoriumS3);
        
        Showtimes showtimesS3 = showtimesList.getShowtimesList().get(2);
        showtimesS3.addAuditoriums(auditoriumS4);
        showtimesS3.addAuditoriums(auditoriumS1);
        
        Showtimes showtimesS4 = showtimesList.getShowtimesList().get(3);
        showtimesS4.addAuditoriums(auditoriumS2);
        showtimesS4.addAuditoriums(auditoriumS4);

        movieS1.addShowtimes(showtimesS2);
        movieS1.addShowtimes(showtimesS1);

        movieS2.addShowtimes(showtimesS4);
        movieS2.addShowtimes(showtimesS3);

        movieList.add(movieS1);
        movieList.add(movieS2);
//        if(movie != null){
//            movieList.add(movie);
//        }
    }

    public void initializeDataByStaff(int selectMovie, ArrayList<Integer> selectShowtime, ArrayList<Integer> selectAuditorium) {
        movie = moviesList.getMovieList().get(selectMovie );

        for (Integer showtime : selectShowtime) {
            movie.addShowtimes(showtimesList.getShowtimesList().get(showtime));
            for (Integer auditorium : selectAuditorium) {
                showtimesList.getShowtimesList().get(showtime).addAuditoriums(auditoriumList.getAuditoriumList().get(auditorium));
            }
        }
        

        

    }

    public double calculateTicketPrice(String seatType, int typePerson, LocalDateTime dateOfWeek, LocalDateTime hourOfday) {
        double price = 0;
        double TAX = 0.05;
        if (hourOfday.getHour() >= 8 && hourOfday.getHour() < 12) {
            if (isSpecialDay(dateOfWeek)) {
                switch (typePerson) {
                    case 1:
                        price = 60000;
                        break;
                    case 2:
                        price = 45000;
                        break;
                    case 3:
                        price = 50000;
                        break;
                }
            } else if (dateOfWeek.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
                price = 45000;
            } else {
                switch (typePerson) {
                    case 1:
                        price = 70000;
                        break;
                    case 2:
                        price = 70000;
                        break;
                    case 3:
                        price = 60000;
                        break;
                }
            }

        } else if (hourOfday.getHour() >= 12 && hourOfday.getHour() < 18) {
            if (isSpecialDay(dateOfWeek)) {
                switch (typePerson) {
                    case 1:
                        price = 70000;
                        break;
                    case 2:
                        price = 45000;
                        break;
                    case 3:
                        price = 50000;
                        break;
                }
            } else if (dateOfWeek.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {

                price = 45000;
            } else {
                switch (typePerson) {
                    case 1:
                        price = 80000;
                        break;
                    case 2:
                        price = 80000;
                        break;
                    case 3:
                        price = 60000;
                        break;
                }
            }
        } else if (hourOfday.getHour() >= 18 && hourOfday.getHour() < 24) {
            if (isSpecialDay(dateOfWeek)) {
                switch (typePerson) {
                    case 1:
                        price = 80000;
                        break;
                    case 2:
                        price = 45000;
                        break;
                    case 3:
                        price = 60000;
                        break;

                }
            } else if (dateOfWeek.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {

                price = 50000;
            } else {
                switch (typePerson) {
                    case 1:
                        price = 90000;
                        break;
                    case 2:
                        price = 90000;
                        break;
                    case 3:
                        price = 70000;
                        break;
                }
            }
        } else {
            
            return 0;
        }

        //Member
        if (typePerson == 4) {
            price = 45000;
        }
        //Seat type
        if (seatType.contains("A") || seatType.contains("B") || seatType.contains("E")) {
            //Normal seat
            return price + price* TAX;
        } else {
            //VIP seat
            return price + 5000 + TAX*(price + 5000);
        }

    }

    private boolean isSpecialDay(LocalDateTime dateOfWeek) {
        return dateOfWeek.getDayOfWeek().equals(DayOfWeek.MONDAY)
                || dateOfWeek.getDayOfWeek().equals(DayOfWeek.TUESDAY)
                || dateOfWeek.getDayOfWeek().equals(DayOfWeek.THURSDAY);
    }

    //Format money follow format VND
    public String formatCurrency(double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return formatter.format(price);
    }

    
    public void displayBill( String nameMovie,String movieDuration, LocalDateTime showtime, String auditorium, String seat,double price){
        System.out.println("         Theater entrance card\n" +"Booking time: "+LocalDateTime.now());
        System.out.println("===========================================\n"+nameMovie +"\nShowtime: "+ showtime + "     " + movieDuration + "min");
        System.out.println("Seat: " + seat + "\n===========================================");
        System.out.println("Bill : " + formatCurrency(price) + "\n");
        
        
    }
   

}
