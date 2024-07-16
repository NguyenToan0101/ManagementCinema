package cinema.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Staff {

    private String id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private int dayWorking;
    private String identityCardNumber;
    private String position;
    private double salary;

    public Staff(String id, String name, Date dateOfBirth, String gender, int dayWorking, String identityCardNumber, String position, double salary) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.dayWorking = dayWorking;
        this.identityCardNumber = identityCardNumber;
        this.position = position;
        this.salary = salary;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDayWorking() {
        return dayWorking;
    }

    public void setDayWorking(int dayWorking) {
        this.dayWorking = dayWorking;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        return salary * dayWorking;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Staff{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", dateOfBirth=" + sdf.format(dateOfBirth)
                + ", gender='" + gender + '\''
                + ", dayWorking=" + dayWorking
                + ", identityCardNumber='" + identityCardNumber + '\''
                + ", position='" + position + '\''
                + ", salary=" + salary
                + '}';
    }

}
