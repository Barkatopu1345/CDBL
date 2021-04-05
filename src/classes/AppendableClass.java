/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author user
 */
public class AppendableClass extends ObjectOutputStream implements Serializable  {

    public AppendableClass(OutputStream out) throws IOException {
        super(out);
    }


    @Override
    protected void writeStreamHeader()throws IOException{
        
    }
    
}
