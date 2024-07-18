/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class Account {
    HashMap<String,String> account;

    public Account() {
        account = new HashMap();
        loadData("Identity.txt");
    }
    
    
     public void loadData(String file) {
        
        
        
        String data;
        try ( BufferedReader readFile = new BufferedReader(new FileReader(file))) {
            while ((data = readFile.readLine()) != null) {
                String[] line = data.split(":");
                if (line.length != 2){
                    System.out.println("Error" + line);
                    continue;
                }
               try {
                    account.put(line[0],line[1]);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.println("Error"+ex);
        }
    }
     
    public boolean accStaff(){
        for (int i = 0; i < 3; i++) {
            
        
     String acc = Utils.getValue("Account : ");
     
     String pass = Utils.getValue("Password : ");
     
        for (String tk : account.keySet()) {
            if(acc.equals(tk) && pass.equals(account.get(tk))){
                return true;
            }
            
        }
        }
        
        return false;
    }
    
    public boolean accAdmin(){
        for (int i = 0; i < 3; i++) {
            
        
     String acc = Utils.getValue("Account : ");
     
     String pass = Utils.getValue("Password : ");
     

            if(acc.equals("Phamtrang") && pass.equals("123")){
                return true;
            }
            

        }
        
        return false;
    }
}
