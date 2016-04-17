package com.teamtreehouse;

import java.util.Date;

public class Treet {
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
        return "Treet: \"" + mDescription + "\" - @" + mAuthor ;
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
    public String[] getWords(){
        return mDescription.toLowerCase().split("[^\\w#@']+");
    }

}

