package nyc.personabe1984.treehouse;

import com.teamtreehouse.Treet;
import com.teamtreehouse.Treets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Treet[] treets = Treets.load();
        System.out.printf("There are %d treets. %n",
                          treets.length);

        printOutTagsAndMentions(treets);

        Map<String, Integer> hashTagCounts = new HashMap<>();
        for(Treet treet : treets){
            for(String hashTags : treet.getHashTags()){
                Integer count = hashTagCounts.get(hashTags);
                if(count == null){
                    count = 0;
                }
                count++;
                hashTagCounts.put(hashTags,count);
            }
        }
        System.out.printf("Hash tag counts: %s %n", hashTagCounts);

        Map<String, List<Treet>> treetsByAuthor = new HashMap<>();
        for(Treet treet : treets){
            List<Treet> authoredTreets = treetsByAuthor.get(treet.getAuthor());
            if(authoredTreets == null){
                authoredTreets = new ArrayList<>();
                treetsByAuthor.put(treet.getAuthor(), authoredTreets);
            }
            authoredTreets.add(treet);
        }
        System.out.printf("Treets by author: %s %n ", treetsByAuthor);
    }

    public static void printOutTagsAndMentions(Treet[] treets){
        Set<String> allHashTags = new HashSet<>();
        Set<String> allMentions = new TreeSet<>();
        for(Treet treet : treets){
            allHashTags.addAll(treet.getHashTags());
            allMentions.addAll(treet.getMentions());
        }
        System.out.printf("HashTags: %s %n",allHashTags);
        System.out.printf("Mentions: %s %n",allMentions);
    }

}
