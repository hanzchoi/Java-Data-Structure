package com.teamtreehouse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Treet implements Comparable<Treet>, Serializable{
    private static final long serialVersionUID = 1L;
    private String mAuthor;
    private String mDescription;
    private Date   mCreationDate;

    public Treet(String author,String description, Date creationDate){
        mAuthor = author;
        mDescription = description;
        mCreationDate = creationDate;
    }

    @Override
    public String toString(){
        return String.format("Treet: \"%s\" by %s on %s" ,
                mDescription, mAuthor, mCreationDate);
    }

    public String getAuthor(){
        return mAuthor;
    }

    public String getDescription(){
        return mDescription;
    }

    public Date getCreationDate(){
        return mCreationDate;
    }

    //[^\\w#@']+ this is the regex expression to us the split method for java
    public List<String> getWords(){
        String[] words = mDescription.toLowerCase().split("[^\\w#@']+");
        return Arrays.asList(words);
    }

    public List<String> getHashTags(){
        return getWrodsPrefixedWith("#");
    }

    public List<String> getMentions(){
        return getWrodsPrefixedWith("@");
    }

    private List<String> getWrodsPrefixedWith(String prefix){
        List<String> results = new ArrayList<>();
        for(String word : getWords()){
            if(word.startsWith(prefix)){
                results.add(word);
            }
        }
        return results;
    }

    @Override
    public int compareTo(Treet other) {
        // All object had the equal method and so if they are the same object return 0 right away
        if(equals(other)){
            return 0;
        }

        int dateCmp = mCreationDate.compareTo(other.mCreationDate);

        // In case if the tweet is created on the same date then check the description to make sure they are the same
        if(dateCmp == 0){
            return mCreationDate.compareTo(other.mCreationDate);
        }

        return dateCmp;
    }
}

