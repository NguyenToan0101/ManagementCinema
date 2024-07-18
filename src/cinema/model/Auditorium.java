/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;



import java.util.LinkedHashMap;


/**
 *
 * @author ADMIN
 */
public class Auditorium {
    private String nameRoom ;
    private LinkedHashMap<String, Boolean> seats;
     

    public Auditorium(String nameRoom) {
        this.seats = new LinkedHashMap();
        this.nameRoom = nameRoom;
        
        
        initializeSeats();
    }

    public Auditorium() {
        
    }
    
    
    private void initializeSeats(){
        
        String[] rows = {"A","B","C","D","E"};
        int seatsPerRow = 15;
    
        for(String row : rows){
            for (int i = 1; i <= seatsPerRow; i++) {
                
                seats.put(row + i, Boolean.FALSE);
            }
    }
    }

    public String getNameRoom() {
        return nameRoom;
    }

    

    public LinkedHashMap<String, Boolean> getSeats() {
        return seats;
    }
     


    public void setSeats(LinkedHashMap<String, Boolean> seats) {
        this.seats = seats;
    }
    
    public boolean bookSeat(String seat){
        if(seats.containsKey(seat)){
            seats.put(seat, Boolean.TRUE);
            return true;
        }
        return false;
    }
    public boolean bookedSeat(String seat){
        for(String i : seats.keySet()){
            if(i.equalsIgnoreCase(seat) && (seats.get(i) == true) ){
                
                 return true;
            }
        }
        
       return false;
    }
    
    
    public void displaceSeats(){
        System.out.println("Seats status ( x = booked ,C,D is seat VIP ) : "
                + "\n---------------------Screen----------------------");
        
        seats.forEach((String seat, Boolean status) -> {
            String check ;
            if(status){
                check = "x";
            }else{
                check = "";
            }
            
            System.out.print(seat + check+ "  " );
            if(seat.endsWith("15")){
                System.out.println();
            }
        });

       
       
    }
    
    

    @Override
    public String toString() {
        return nameRoom;
    }
    
    


        
        
    }
    
    

