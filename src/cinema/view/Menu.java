/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.view;

import cinema.model.Utils;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class Menu {
    protected String title;
    protected ArrayList<String> choices;

  
        public Menu(){
        
        
    }

    public Menu(String title, String[] menuChoice) {
        this.title = title;
        choices = new ArrayList<>();
        for(String menu : menuChoice){
            choices.add(menu);
        }
    }
        
  
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }
    
    public void printMenu(){
        System.out.println("--------------" + title +"-------------------");
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
            
        }
        System.out.println("--------------------------------------------");
        
        
    }
    public int getSelected(){
        printMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your selection");
        return scanner.nextInt();
    }
    
    public abstract void execute(int choice);
    
    public void run(){
        while(true){
        int choice = getSelected();
        boolean isValid = false;
            while (!isValid) {
                if (choice > 0 && choice <=8) {
                    isValid = true;
                } else {
                    System.out.println("Input invalid value\nPlease input again: ");
                    choice = getSelected();

                }

            }
            if (choice <= choices.size()) {
                execute(choice);
                //Program used for choose again.  
                String chooseAgain = Utils.getValue("Do you want to choose again (Yes/No)?");
                while (!"Yes".equals(chooseAgain) && !"No".equals(chooseAgain)) {
                    chooseAgain = Utils.getValue("Invalid selection.\nPlease input again (Yes/No): ");
                }
                if ("Yes".equals(chooseAgain)) {

                    System.out.println("Please choose again:");

                } else if ("No".equals(chooseAgain)) {
                    System.out.println("The program has exited!");
                    System.exit(0);
                }
            } else {
                break;
            }
        }
    }

}



