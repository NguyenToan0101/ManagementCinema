/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.io.BufferedReader;

import java.io.FileReader;

import java.util.ArrayList;


/**
 *
 * @author ADMIN
 */
public class ShowtimesList {
    ArrayList<Showtimes> showtimesList;

    public ShowtimesList() {
        showtimesList = new ArrayList();

        loadData("ShowtimesList.txt");
    }

      public void loadData(String file) {
        
        
        
        String data;
        try ( BufferedReader readFile = new BufferedReader(new FileReader(file))) {
            while ((data = readFile.readLine()) != null) {
               
                
               try {
                    showtimesList.add(new Showtimes(data));  
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error"+ex);
        }
    }
    
    public ArrayList<Showtimes> getShowtimesList() {
        return showtimesList;
    }

    public void setShowtimesList(ArrayList<Showtimes> showtimesList) {
        this.showtimesList = showtimesList;
    }
    
    
    
}
