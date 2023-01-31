package com.company.chatterbook.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts;

    public User(String name){
        this.name = name;
    }

    public String getUsername (){
        return name;
    }
    public void setUsername(String name){
        this.name = name;
    }

    public void setChatterPosts(List<ChatterPost> chatters){
        chatterPosts = new ArrayList<>();
        for(ChatterPost chatter : chatters){
            chatterPosts.add(chatter);
        }
    }
    public List<ChatterPost> getChatterPosts(){
        return chatterPosts;
    }
}
