/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author user
 */
public class product {
    private String companyName;
    private String firstAccountNo;
    private String lastAccountNo;

    public product(String companyName, String firstAccountNo, String lastAccountNo) {
        this.companyName = companyName;
        this.firstAccountNo = firstAccountNo;
        this.lastAccountNo = lastAccountNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstAccountNo() {
        return firstAccountNo;
    }

    public void setFirstAccountNo(String firstAccountNo) {
        this.firstAccountNo = firstAccountNo;
    }

    public String getLastAccountNo() {
        return lastAccountNo;
    }

    public void setLastAccountNo(String lastAccountNo) {
        this.lastAccountNo = lastAccountNo;
    }
    
    
    
}
