/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema.management;

import cinema.model.StaffList;
import cinema.view.Menu;

/**
 *
 * @author ADMIN
 */
public class ManagementCinema extends Menu{
    
    static String title = "Your position";
    static String[] arr = {"ADMIN", "STAFF", "CUSTOMER", "EXIT"};
    

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                
                break;               
            case 2:  
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void main(String[] args) {
              ManagementCinema mm = new ManagementCinema ();
        mm.run();
    }
    
    
 
}
