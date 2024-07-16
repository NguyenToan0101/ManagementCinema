/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Showtimes {
   
    private LocalDateTime showtimes;
    private ArrayList<Auditorium> auditoriums;
 private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("EEEE,dd/MM/yyyy,h:mm a");
    public Showtimes(String showtimes) {
        this.showtimes = LocalDateTime.parse(showtimes,FORMATTER);
        this.auditoriums = new ArrayList();
    }

    

    public LocalDateTime getShowtimes() {
        return showtimes;
    }
    
    public void setShowtimes(LocalDateTime showtimes) {
        this.showtimes = showtimes;
    }

    public ArrayList<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void addAuditoriums(Auditorium auditoriums) {
        this.auditoriums.add(auditoriums);
    }
    
//    public LocalDateTime getHour(){
//        return showtimes.getHour();
//    }

    @Override
    public String toString() {
        return this.showtimes.format(FORMATTER);
    }
   
    

   
  

    
    
    
    
    
    
}
