package com.fuchsia.fuchsia;

import lombok.Data;

import java.util.Date;

@Data
public class Exercise {
    private int userId;
    private String description;
    private String duration;        //TODO: change the type to date or time type??
    private Date date;

    public Exercise() {
        super();
        System.out.println("INITIAL CONSTRUCTOR INVOKED");
    }

//    public Exercise(int id, String description, String duration, Date date) {
//        System.out.println("SECOND CONSTRUCTOR INVOKED");
//        userId = id;
//        this.description = description;
//        this.duration = duration;
//        this.date = date;
//    }
//
//    public Exercise(int id, String description, String duration) {
//        super();
//        System.out.println("THIRD CONSTRUCTOR INVOKED");
//        userId = id;
//        this.description = description;
//        this.duration = duration;
//    }

    public int getUserId() {
        return userId;
    }
}
