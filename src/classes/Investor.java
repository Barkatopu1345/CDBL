/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class Investor extends User implements Serializable {
   protected String nid;

    public Investor(String nid, String name, String email, String password, String boId) {
        this.name = name;
        this.nid = nid;
        this.email = email;
        this.password = password;
        this.ID = boId;
        
    }    
    public Investor(String nid, String name, String email, String password) {
        this.name = name;
        this.nid = nid;
        this.email = email;
        this.password = password;

        
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void showInfo(){
        System.out.println(name+" "+nid+" " );
    }
    
//    public getID(){
//        String boId = generateId();
//    }
    public String getID() {
        return ID;
    }
    
    
   
}
