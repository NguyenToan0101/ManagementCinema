package cinema.model;

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

public class StaffList {
    private List<Staff> staffList;

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

    
    public boolean addStaff(Staff staff) {
        for (Staff s : staffList) {
            if (s.getId().equals(staff.getId()) || s.getIdentityCardNumber().equals(staff.getIdentityCardNumber())) {
                return false;
            }
        }
        staffList.add(staff);
        return true;
    }

   
    public List<Staff> searchByCriteria(String criteria, String value) {
        List<Staff> result = new ArrayList<>();
        for (Staff staff : staffList) {
            switch (criteria.toLowerCase()) {
                case "id":
                    if (staff.getId().equalsIgnoreCase(value)) result.add(staff);
                    break;
                case "name":
                    if (staff.getName().equalsIgnoreCase(value)) result.add(staff);
                    break;
                case "dateofbirth":
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    if (sdf.format(staff.getDateOfBirth()).equalsIgnoreCase(value)) result.add(staff);
                    break;
                case "gender":
                    if (staff.getGender().equalsIgnoreCase(value)) result.add(staff);
                    break;
                case "dayworking":
                    if (staff.getDayWorking() == Integer.parseInt(value)) result.add(staff);
                    break;
                case "identitycardnumber":
                    if (staff.getIdentityCardNumber().equalsIgnoreCase(value)) result.add(staff);
                    break;
                case "position":
                    if (staff.getPosition().equalsIgnoreCase(value)) result.add(staff);
                    break;
                case "salary":
                    if (staff.getSalary() == Double.parseDouble(value)) result.add(staff);
                    break;
                default:
                    break;
            }
        }
        return result;
    }

   
    public void sortByCriteria(String criteria) {
        switch (criteria.toLowerCase()) {
            case "id":
                staffList.sort(Comparator.comparing(Staff::getId));
                break;
            case "name":
                staffList.sort(Comparator.comparing(Staff::getName));
                break;
            case "dateofbirth":
                staffList.sort(Comparator.comparing(Staff::getDateOfBirth));
                break;
            case "gender":
                staffList.sort(Comparator.comparing(Staff::getGender));
                break;
            case "dayworking":
                staffList.sort(Comparator.comparingInt(Staff::getDayWorking));
                break;
            case "identitycardnumber":
                staffList.sort(Comparator.comparing(Staff::getIdentityCardNumber));
                break;
            case "position":
                staffList.sort(Comparator.comparing(Staff::getPosition));
                break;
            case "salary":
                staffList.sort(Comparator.comparingDouble(Staff::getSalary));
                break;
            default:
                break;
        }
    }

    
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


    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public String toString() {
        return "StaffList{" +
                "staffList=" + staffList +
                '}';
    }
}
