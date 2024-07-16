package cinema.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StaffList {

    private ArrayList<Staff> staffList;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public StaffList() {
        this.staffList = new ArrayList<>();
        try {
            readFromFile("Input.txt");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public void addNewStaff(Staff st) {
        staffList.add(st);
    }

    public void readFromFile(String filename) throws IOException, ParseException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 8) {
                    System.err.println("Invalid data format in input file: " + line);
                    continue;
                }
                Staff staff = new Staff(
                        data[0].trim(), // ID
                        data[1].trim(), // Name
                        sdf.parse(data[2].trim()), // Date of Birth
                        data[3].trim(), // Gender
                        Integer.parseInt(data[4].trim()), // Day Working
                        data[5].trim(), // Identity Card Number
                        data[6].trim(), // Position
                        Double.parseDouble(data[7].trim()) // Salary
                );
                this.addStaff(staff);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
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

    // Sort staff by any criteria
    public void sortByCriteria(int choice) {
        Comparator<Staff> comparator = createComparator(choice);
        if (comparator != null) {
            staffList.sort(comparator);
        }
    }

    private Comparator<Staff> createComparator(int choice) {
        switch (choice) {
            case 1:
                return Comparator.comparing(Staff::getId);
            case 2:
                return Comparator.comparing(Staff::getName);
            case 3:
                return Comparator.comparing(Staff::getDateOfBirth);
            case 4:
                return Comparator.comparing(Staff::getGender);
            case 5:
                return Comparator.comparingInt(Staff::getDayWorking);
            case 6:
                return Comparator.comparing(Staff::getIdentityCardNumber);
            case 7:
                return Comparator.comparing(Staff::getPosition);
            case 8:
                return Comparator.comparingDouble(Staff::getSalary);
            default:
                return null;
        }
    }

    // Search staff by any criteria
    public List<Staff> searchByCriteria(int choice, String value) {
        Predicate<Staff> predicate = createPredicate(choice, value);
        return staffList.stream().filter(predicate).collect(Collectors.toList());
    }

    private Predicate<Staff> createPredicate(int choice, String value) {
        switch (choice) {
            case 1:
                return staff -> staff.getId().equalsIgnoreCase(value);
            case 2:
                return staff -> staff.getName().equalsIgnoreCase(value);
            case 3:
                return staff -> sdf.format(staff.getDateOfBirth()).equalsIgnoreCase(value);
            case 4:
                return staff -> staff.getGender().equalsIgnoreCase(value);
            case 5:
                return staff -> String.valueOf(staff.getDayWorking()).equals(value);
            case 6:
                return staff -> staff.getIdentityCardNumber().equalsIgnoreCase(value);
            case 7:
                return staff -> staff.getPosition().equalsIgnoreCase(value);
            case 8:
                return staff -> String.valueOf(staff.getSalary()).equals(value);
            default:
                return staff -> false;
        }
    }

    // Write data to file
    public void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Backup_Staff.txt"))) {
            for (Staff staff : staffList) {
                writer.println(staff.toString()); // Sử dụng phương thức toString() của Staff
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
