/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author ADMIN
 */
public class Utils {

    private static Scanner sc = new Scanner(System.in);

    public static String getValue(String title) {

        System.out.println(title);
        return sc.nextLine().trim();
    }

    public static String getString(String inputMsg) {

        System.out.println(inputMsg);
        String data = sc.nextLine().trim();
        while (!data.matches("[a-zA-Z]+( [a-zA-Z]+)*$")) {
            System.out.println("Enter name again(A-Z): ");
            data = sc.nextLine().trim();
        }

        return data;

    }

    public static <T> T getNumber(String inputMsg, String error, Function<String, T> parser) {
        T value;
        while (true) {
            try {
                System.out.println(inputMsg);
                value = parser.apply(sc.nextLine().trim());
                return value;

            } catch (NumberFormatException e) {

                System.out.println(error);

            }

        }
    }

    public static <T extends Comparable<T>> T getNumber(String inputMsg, String error, T lowerBound, T upperBound, Function<String, T> parser) {

        T value;
        while (true) {
            try {
                System.out.println(inputMsg);
                value = parser.apply(sc.nextLine().trim());
                if (value.compareTo(lowerBound) < 0 || value.compareTo(upperBound) > 0) {
                    throw new Exception();
                }
                return value;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static boolean isValidDate(String date) {
        SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");
        FORMATTER.setLenient(false);
        try {
            FORMATTER.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    public static String getStringID(String inputMsg, String error, String format) {
        String id;
        while (true) {

            id = getValue(inputMsg.trim());
            if (id.isBlank() || !id.matches(format)) {
                System.out.println(error);
            } else {
                return id;
            }

        }
    }

    public static String getStringPhone(String inputMsg, String error) {
        String phoneNum;
        while (true) {
            phoneNum = getValue(inputMsg).trim();
            if (phoneNum.isBlank() || !phoneNum.matches("0\\d{9,10}")) {
                System.out.println(error);
            } else {
                return phoneNum;
            }

        }
    }

//    public static String normalizeName(String name) {
//        name = name.replaceAll("[^a-zA-Z ]", 
//        name = name.replaceAll("\\s+", " ");
//
//        String[] words = name.split("\\s+");
//        StringBuilder normalized = new StringBuilder();
//
//        for (String word : words) {
//            if (!word.isEmpty()) {
//                String normalizedName = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
//                normalized.append(normalizedName).append(" ");
//            }
//
//        }
//        return normalized.toString().trim();
//    }
      public static <T> void display(String tittle, ArrayList<T> ls) {
        System.out.println(tittle + "\n-------------------------------------------------------------");
        for (T b : ls) {
            System.out.println(b);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total : " + ls.size());
    }
      
    public static <T> void displayList(String tittle, ArrayList<T> list){
        System.out.println(tittle + "\n-------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i));
        }
         System.out.println("-------------------------------------------------------------");
    }
    
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list){
        HashSet<T> set = new HashSet<>(list);
        return new ArrayList<>(set);
    } 
    
      public static LocalDate toLocalDate(String dob){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dob, formatter);
    }

    public static String toStringDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy,HH:mm");
        return formatter.format(date);
    } 
}
