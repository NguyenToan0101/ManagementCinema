package cinema.management;


import cinema.model.Auditorium;
import cinema.model.Movie;
import cinema.model.MovieList;
import cinema.model.Ticket;
import cinema.model.Utils;
import cinema.view.Menu;
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
    Auditorium auditorium;

    public StaffController() {
        moviesList = new MovieList();
        ticket = new Ticket();
        auditorium = new Auditorium();
    }

    @Override
    public void execute(int choice) {

    }

    public void subMenuTask() {

        String[] subMenuCustom = {"Add new movie", "See list of movie", "See empty seat ", "Delete movie ", "Quit"};
        Menu subMenuCus = new Menu("Task Menu", subMenuCustom) {

            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                    {
                        try {
                            moviesList.addMovie();
                        } catch (ParseException ex) {
                            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        break;


                    case 2:
                        moviesList.getAllMovies(moviesList.getMovieList());
                        break;
                    case 3:
                         auditorium.displaceSeats();
                        break;
                    case 4:
                         deleteMovie();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }

        };
        subMenuCus.run();
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

}