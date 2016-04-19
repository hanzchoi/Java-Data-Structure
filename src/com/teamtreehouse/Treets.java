package com.teamtreehouse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Treets {

    public static void save(Treet[] treets){

        try(
                FileOutputStream fos = new FileOutputStream("treets.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ){
            oos.writeObject(treets);
        }catch(IOException ioe){
            System.out.println("Problem saving treets");
            ioe.printStackTrace();
        }
    }

    public static Treet[] load(){
        Treet[] treets = new Treet[0];
        try(
                FileInputStream fis = new FileInputStream("treets.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            treets = (Treet[]) ois.readObject();
        }catch(IOException ioe){
            System.out.println("Error reading the file");
            ioe.printStackTrace();
        } catch(ClassNotFoundException cnfe){
            System.out.println("Error loading the treets");
            cnfe.printStackTrace();
        }

        return treets;
    }
}
