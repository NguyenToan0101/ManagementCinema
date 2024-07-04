/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

/**
 *
 * @author ADMIN
 */
public class Seat {
    private String row;
    private int numberOfRow;

    public Seat(String row, int numberOfRow) {
        this.row = row;
        this.numberOfRow = numberOfRow;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    @Override
    public String toString() {
        return "Seat{" + "row=" + row + ", numberOfRow=" + numberOfRow + '}';
    }
    
}
