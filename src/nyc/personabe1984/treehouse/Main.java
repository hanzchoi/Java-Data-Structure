package nyc.personabe1984.treehouse;

import com.teamtreehouse.Treet;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    Treet treet = new Treet("","", new Date());
        System.out.printf("This is a new Treet: %s %n", treet);
    }
}
