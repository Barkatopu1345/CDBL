/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

public abstract class User implements Serializable {
    protected String name;
    protected String ID;
    protected String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    protected String password;

    public String getID() {
        return ID;
    }
    public void setPassword(String password){
        this.password = password;
    }
  
    
    
    
}
