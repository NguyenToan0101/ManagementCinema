/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Staff {
    private int id;
    private String name;
    private Date birthDate;
    private String gender;
    private int dayWorking;
    private String IdentityCardNumber;
    private String position;
    private long salary;

    public Staff(int id, String name, Date birthDate, String gender, int dayWorking, String IdentityCardNumber, String position, long salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.dayWorking = dayWorking;
        this.IdentityCardNumber = IdentityCardNumber;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirhtDate(Date birthDate) {
        this.birthDate = birthDate;
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
        return IdentityCardNumber;
    }

    public void setIdentityCardNumber(String IdentityCardNumber) {
        this.IdentityCardNumber = IdentityCardNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", name=" + name + ", dateOfBirth=" + birthDate + ", gender=" + gender + ", dayWorking=" + dayWorking + ", IdentityCardNumber=" + IdentityCardNumber + ", position=" + position + ", salary=" + salary + '}';
    }
    
    
    
}
