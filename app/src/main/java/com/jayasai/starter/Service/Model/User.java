package com.jayasai.starter.Service.Model;


import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("UserID")
    private int user_id;

    private String user_fname;
    private String user_lname;
    private String user_address;
    private String user_phone;
    private String user_email;
    private String user_password;


}
