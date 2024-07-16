/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema.management;

import cinema.model.MovieList;

import cinema.view.Menu;
import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class ManagementCinema extends Menu {

    MovieList movieList;

    CustomerController customerController;
    AdminController adminController;
  StaffController staffController;

    static String[] mainMenu = {"ADMIN", "STAFF", "CUSTOMER", "EXIT"};

    public ManagementCinema() throws IOException {
        super("|WHO ARE YOU?|", mainMenu);

        this.movieList = new MovieList();

        customerController = new CustomerController();
        adminController = new AdminController();
  staffController = new StaffController();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                adminController.subMenuAdmin();
               
                break;
            case 2:
                // Handle Staff actions if needed
                staffController.subMenuTask();
                break;
            case 3:
                subMenuCustomer();
                break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public void subMenuCustomer() {

        String[] subMenuCustom = {"Test", "See list of movie", "Book ticket", "Quit"};
        Menu subMenuCus = new Menu("Menu Customer", subMenuCustom) {

            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
//                        

                        break;

                    case 2:
                        movieList.getAllMovies(movieList.getMovieList());
                        break;
                    case 3:
                        customerController.ticketBooking();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }

        };
        subMenuCus.run();
    }

    public static void main(String[] args) throws IOException {
        ManagementCinema managementCinema = new ManagementCinema();
        managementCinema.run();
    }

}
