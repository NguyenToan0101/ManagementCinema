/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class AuditoriumList {

     ArrayList<Auditorium> auditoriumList;

    public AuditoriumList() {
        
        auditoriumList = new ArrayList();
        auditoriumList.add(new Auditorium("Room1"));
        auditoriumList.add(new Auditorium("Room2"));
        auditoriumList.add(new Auditorium("Room3"));
        auditoriumList.add(new Auditorium("Room4"));
        auditoriumList.add(new Auditorium("Room5"));
        
    }

    public ArrayList<Auditorium> getAuditoriumList() {
        return auditoriumList;
    }
    
 
    
}
