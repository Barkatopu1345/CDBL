/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class DpsMember extends User implements Serializable {

    private String licence;
    private String address;

    public DpsMember(String name, String licence, String email, String password, String address) {

        this.name = name;
        this.licence = licence;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    public DpsMember(String name,String DPID, String licence, String email, String password, String address) {

        this.name = name;
        this.ID = DPID;
        this.licence = licence;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
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

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void showInfo(){
        System.out.println(name +" "+ licence +" "+ address);
    }


}
