package com.example.e_certy51;

public class database_fill_details {

    String userid;
    String username;



    public database_fill_details(){

    }

    public database_fill_details(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public String getId(){
        return userid;
    }
    public String getName(){
        return username;
    }
}

