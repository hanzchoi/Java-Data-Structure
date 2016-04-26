package nyc.personabe1984.treehouse;

import com.teamtreehouse.Treet;
import com.teamtreehouse.Treets;

public class Main {

    public static void main(String[] args) {
        Treet[] treets = Treets.load();
        System.out.printf("There are %d treets. %n",
                          treets.length);

        Treet originalTreet = treets[0];
        System.out.println("HashTags: ");
        for(String hashtag : originalTreet.getHashTags()){
            System.out.println(hashtag);
        }


    }
}
