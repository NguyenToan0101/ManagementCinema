package cinema.model;

import cinema.view.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StaffList {
    private List<Staff> staffList;
    Utils until = new Utils();

    public StaffList(String filename) {
        this.staffList = new ArrayList<>();
        try {
            readFromFile(filename);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    // Read data from file
    public void readFromFile(String filename) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(", ");
            Staff staff = new Staff(
                data[0],
                data[1],
                sdf.parse(data[2]),
                data[3],
                Integer.parseInt(data[4]),
                data[5],
                data[6],
                Double.parseDouble(data[7])
            );
            this.addStaff(staff);
        }
        br.close();
    }

    // Add new staff ensuring no duplicate ID or IdentityCardNumber
    public boolean addStaff(Staff staff) {
        for (Staff s : staffList) {
            if (s.getId().equals(staff.getId()) || s.getIdentityCardNumber().equals(staff.getIdentityCardNumber())) {
                return false;
            }
        }
        staffList.add(staff);
        return true;
    }

    // Search staff by any criteria
  public void searchByCriteria() {
        Scanner scanner = new Scanner(System.in);
        String[] searchArr = {"ID", "Name", "Date of Birth", "Gender", "Day Working", "Identity Card Number", "Position", "Salary", "Exit"};
        Menu searchMenu = new Menu("Search Staff", searchArr) {
            @Override
            public void execute(int choice) {
                boolean found = false;
                String value = "";
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getId().equalsIgnoreCase(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Enter Name: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getName().equalsIgnoreCase(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (sdf.format(staff.getDateOfBirth()).equalsIgnoreCase(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter Gender: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getGender().equalsIgnoreCase(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Enter Day Working: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getDayWorking() == Integer.parseInt(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 6:
                        System.out.print("Enter Identity Card Number: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getIdentityCardNumber().equalsIgnoreCase(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 7:
                        System.out.print("Enter Position: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getPosition().equalsIgnoreCase(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 8:
                        System.out.print("Enter Salary: ");
                        value = scanner.nextLine();
                        for (Staff staff : staffList) {
                            if (staff.getSalary() == Double.parseDouble(value)) {
                                System.out.println("Found: " + staff);
                                found = true;
                            }
                        }
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                if (!found) {
                    System.out.println("NOT FOUND");
                }
            }
        };
        searchMenu.run();
    }

 public void sortByCriteria() {
        Scanner scanner = new Scanner(System.in);
        String[] sortArr = {"ID", "Name", "Date of Birth", "Gender", "Day Working", "Identity Card Number", "Position", "Salary", "Exit"};
        Menu sortMenu = new Menu("Sort Staff", sortArr) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        staffList.sort(Comparator.comparing(Staff::getId));
                        break;
                    case 2:
                        staffList.sort(Comparator.comparing(Staff::getName));
                        break;
                    case 3:
                        staffList.sort(Comparator.comparing(Staff::getDateOfBirth));
                        break;
                    case 4:
                        staffList.sort(Comparator.comparing(Staff::getGender));
                        break;
                    case 5:
                        staffList.sort(Comparator.comparingInt(Staff::getDayWorking));
                        break;
                    case 6:
                        staffList.sort(Comparator.comparing(Staff::getIdentityCardNumber));
                        break;
                    case 7:
                        staffList.sort(Comparator.comparing(Staff::getPosition));
                        break;
                    case 8:
                        staffList.sort(Comparator.comparingDouble(Staff::getSalary));
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
                System.out.println("Staff list sorted by " + sortArr[choice - 1]);
            }
        };
        sortMenu.run();
    }

    // Write data to file
    public void writeToFile(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Staff staff : staffList) {
            bw.write(
                staff.getId() + ", " +
                staff.getName() + ", " +
                sdf.format(staff.getDateOfBirth()) + ", " +
                staff.getGender() + ", " +
                staff.getDayWorking() + ", " +
                staff.getIdentityCardNumber() + ", " +
                staff.getPosition() + ", " +
                staff.getSalary()
            );
            bw.newLine();
        }
        bw.close();
    }

    // Other utility methods
    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }


}
