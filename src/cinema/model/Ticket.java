/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Ticket {
    private String customerName;
    private LocalDateTime purchaseDay;
    private long ticketPrice;
    private ShowtimesAndAuditorium showtimesAndAuditorium;
    private ArrayList<Seat> seats;

    public Ticket(String customerName, LocalDateTime purchaseDay, long ticketPrice, ShowtimesAndAuditorium showtimesAndAuditorium, ArrayList<Seat> seats) {
        this.customerName = customerName;
        this.purchaseDay = purchaseDay;
        this.ticketPrice = ticketPrice;
        this.showtimesAndAuditorium = showtimesAndAuditorium;
        this.seats = seats;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getPurchaseDay() {
        return purchaseDay;
    }

    public void setPurchaseDay(LocalDateTime purchaseDay) {
        this.purchaseDay = purchaseDay;
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public ShowtimesAndAuditorium getShowtimesAndAuditorium() {
        return showtimesAndAuditorium;
    }

    public void setShowtimesAndAuditorium(ShowtimesAndAuditorium showtimesAndAuditorium) {
        this.showtimesAndAuditorium = showtimesAndAuditorium;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Ticket{" + "customerName=" + customerName + ", purchaseDay=" + purchaseDay + ", ticketPrice=" + ticketPrice + ", showtimesAndAuditorium=" + showtimesAndAuditorium + ", seats=" + seats + '}';
    }
    
}
