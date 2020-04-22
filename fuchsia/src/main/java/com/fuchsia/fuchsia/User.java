package com.fuchsia.fuchsia;


import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private static int _id = 0;
    private static ArrayList<User> userArray = new ArrayList<>();
    private String firstName;
    private String lastName;
    private int userInt;


    public User(String firstName, String lastName) {
        userInt = _id;
        this.firstName = firstName;
        this.lastName = lastName;

        userArray.add(this);

        System.out.println("userArray " + userArray.toString());

        _id++;
    }
}
