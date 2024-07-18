package cinema.management;


import cinema.model.AuditoriumList;
import cinema.model.Movie;
import cinema.model.MovieList;
import static cinema.model.MovieList.formatName;
import cinema.model.ShowtimesList;
import cinema.model.Ticket;
import cinema.model.Utils;
import cinema.view.Menu;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class StaffController extends Menu {

    MovieList moviesList;
    Ticket ticket;
    ShowtimesList showtimeList;
    AuditoriumList auditoriumList;
    public StaffController() {
        moviesList = new MovieList();
        ticket = new Ticket();
        
        showtimeList = new ShowtimesList();
        auditoriumList = new AuditoriumList();
    }

    @Override
    public void execute(int choice) {

    }

    public void subMenuTask() {

        String[] subMenuCustom = {"Add new movie", "See list of movie", "Create showtime ", "Delete movie ", "Back to main menu","Quit"};
        Menu subMenuCus = new Menu("Task Menu", subMenuCustom) {

            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                    {
                        try {
                            moviesList.addMovie(addMovie());
                        } catch (ParseException ex) {
                            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;


                    case 2:
                        moviesList.getAllMovies(moviesList.getMovieList());
                        break;
                    case 3:
                         createShowtime();
                        break;
                    case 4:
                         deleteMovie();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                         ManagementCinema managementCinema = null;
                    try {
                        managementCinema = new ManagementCinema();
                    } catch (IOException ex) {
                        Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        managementCinema.run();
break;
                    case 6 :
                        System.out.println("Exit!");
                        System.exit(0);
                }
            }

        };
        subMenuCus.run();
    }
    
     public Movie addMovie() throws ParseException {
        String title = formatName(Utils.getValue("Enter movie name: "));
        String director = formatName(Utils.getValue("Enter director name: "));
        String movieDuration = Utils.getValue("Enter movie duration: ");
        String genre = Utils.getValue("Enter genre: ");
        String premiereDate = Utils.getValue("Enter date of birth(dd/MM/yyyy): ");;

        return new Movie(title, director, movieDuration, genre, premiereDate);

    }

    public void deleteMovie() {
        String[] choiceSearch = {"Delete by name", "Delete by movie duration", "Delete by director", "Delete by preier date", "Press 9 to exit search menu"};

        Menu deleMenu = new Menu("-------------------|Delete Movie |--------------------", choiceSearch) {
            @Override
            public void execute(int ch) {
                ArrayList<Movie> searchResult = new ArrayList<>();
                switch (ch) {
                    case 1: {
                        String name = Utils.getValue("Enter name to delete: ");
                        searchResult = moviesList.searchMovie(st -> st.getTitle().equals(name));
                        moviesList.deleteMovie((p) -> p.getTitle().equals(name));
                    }
                    break;
                    case 2: {
                        String m = Utils.getValue("Enter Movie to delete: ");
                        searchResult = moviesList.searchMovie(st -> st.getMovieDuration().equals(m));
                        moviesList.deleteMovie((p) -> p.getMovieDuration().equals(m));
                    }
                    break;
                    case 3:
                        String md = Utils.getValue("Enter Director to delete: ");
                        searchResult = moviesList.searchMovie(st -> st.getDirector().equals(md));
                        moviesList.deleteMovie((p) -> p.getDirector().equals(md));

                        break;
                    case 4:
                        String pd = Utils.getValue("Enter movie preire date to delete: ");
                        searchResult = moviesList.searchMovie(st -> st.getPremiereDate().equals(pd));
                        moviesList.deleteMovie((p) -> p.getPremiereDate().equals(pd));

                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                if (searchResult.isEmpty()) {
                    System.out.println("No results found.");
                } else {
                    System.out.println("Successfull!");
                }
            }
        };
        deleMenu.run();
    }
    
    public void createShowtime(){
        
        Utils.displayList("List movie", moviesList.getMovieList());
        int selectMovie = Utils.getNumber("Choose a movie by entering the corresponding number: ",
                String.format("Invalid value.Please select again ( 1 - %d)", moviesList.getMovieList().size()), 
                1, moviesList.getMovieList().size(), Integer::parseInt);

       
        Utils.displayList("List showtimes:", showtimeList.getShowtimesList());
        int selectTimesChoiceS1 = Utils.getNumber("\nHow many times do you wanna choice showtime ", "Invalid value", Integer::parseInt);
        ArrayList<Integer> listChoiceShowtime = new ArrayList();
        for (int i = 0; i < selectTimesChoiceS1; i++) {
            int selectShowtime = Utils.getNumber("Choose a showtime by entering the correspoding number : ",
                String.format("Invalid value.Please select again ( 1 - %d)", showtimeList.getShowtimesList().size()),
                1, showtimeList.getShowtimesList().size(), Integer::parseInt);
            listChoiceShowtime.add(selectShowtime-1);
        }
        System.out.println("Auditorium valid");
         Utils.displayList("List auditorium:", auditoriumList.getAuditoriumList());
        
        int selectTimesChoiceS2 = Utils.getNumber("\nHow many times do you wanna choice auditorium", "Invalid value", Integer::parseInt);
        ArrayList<Integer> listChoiceAudi = new ArrayList();
        for (int i = 0; i < selectTimesChoiceS2; i++) {
            int selectAuditorium = Utils.getNumber("Choose an auditorium by entering the correspoding number : ",
                String.format("Invalid value.Please select again ( 1 - %d)", auditoriumList.getAuditoriumList().size()), 
                1, auditoriumList.getAuditoriumList().size(), Integer::parseInt);
            listChoiceAudi.add(selectAuditorium-1);
        }
        
        ticket.initializeDataByStaff(selectMovie-1,listChoiceShowtime,listChoiceAudi);
        System.out.println("Add showtime succesful!");
         
         
    }

   
}