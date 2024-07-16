package cinema.management;

import cinema.model.Staff;
import cinema.model.StaffList;
import cinema.model.Utils;
import cinema.view.Menu;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController extends Menu {

    StaffList staffList;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public AdminController() {
        this.staffList = new StaffList();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                displayStaff();
                break;
            case 2:
                addStaff();
                break;
            case 3:
                searchStaff();
                break;
            case 4:
                sortStaff();
                break;
            case 5: {
                try {
                    returnToMainMenu();
                } catch (IOException ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public void subMenuAdmin() {
        String[] subMenuOptions = {"Display Staff", "Add Staff", "Search Staff", "Sort Staff", "Back to Previous Menu"};
        Menu subMenuAdmin = new Menu("Admin Menu", subMenuOptions) {
            @Override
            public void execute(int choice) {
                AdminController.this.execute(choice);
            }
        };
        subMenuAdmin.run();
    }

    public void displayStaff() {
        ArrayList<Staff> staff = staffList.getStaffList();
        if (staff.isEmpty()) {
            System.out.println("Empty List.");
        } else {
            System.out.println("-------------------------------| List Of Staff |-------------------------------");
            for (Staff st : staff) {
                System.out.println(st);
            }
            System.out.println("---------------------------------------------------------------------------");
        }
    }

    public void addStaff() {
        String id = Utils.getStringID("Enter ID: ", "Invalid ID format!", "\\w+");
        String name = Utils.getString("Enter Name: ");
        String dob;
        do {
            dob = Utils.getValue("Enter Date of Birth (dd/MM/yyyy): ");
        } while (!Utils.isValidDate(dob));
        String gender = Utils.getString("Enter Gender: ");
        int dayWorking = Utils.getNumber("Enter Day Working: ", "Invalid number!", Integer::parseInt);
        String identityCardNumber = Utils.getStringID("Enter Identity Card Number: ", "Invalid Identity Card Number format!", "\\w+");
        String position = Utils.getString("Enter Position: ");
        double salary = Utils.getNumber("Enter Salary: ", "Invalid number!", Double::parseDouble);

        try {
            Staff staff = new Staff(id, name, sdf.parse(dob), gender, dayWorking, identityCardNumber, position, salary);
            if (staffList.addStaff(staff)) {
                System.out.println("Staff added successfully.");
                // Tính toán và hiển thị lương của nhân viên vừa thêm vào
                System.out.println("Salary: " + staff.calculateSalary());
            } else {
                System.out.println("Staff with the same ID or Identity Card Number already exists.");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void searchStaff() {
        String[] searchArr = {"ID", "Name", "Date of Birth", "Gender", "Day Working", "Identity Card Number", "Position", "Salary"};
        System.out.println("Search by:");
        for (int i = 0; i < searchArr.length; i++) {
            System.out.println((i + 1) + ". " + searchArr[i]);
        }
        int choice = Utils.getNumber("Enter choice: ", "Invalid choice!", 1, searchArr.length, Integer::parseInt);
        String value = Utils.getValue("Enter " + searchArr[choice - 1] + ": ");

        staffList.searchByCriteria(choice, value).forEach(System.out::println);
    }

    public void sortStaff() {
        String[] sortArr = {"ID", "Name", "Date of Birth", "Gender", "Day Working", "Identity Card Number", "Position", "Salary"};
        System.out.println("Sort by:");
        for (int i = 0; i < sortArr.length; i++) {
            System.out.println((i + 1) + ". " + sortArr[i]);
        }
        int choice = Utils.getNumber("Enter choice: ", "Invalid choice!", 1, sortArr.length, Integer::parseInt);

        staffList.sortByCriteria(choice);
        displayStaff();
    }

    private void returnToMainMenu() throws IOException {
        System.out.println("Returning to main menu...");
        ManagementCinema mainMenu = new ManagementCinema();
        mainMenu.run();
    }
}
