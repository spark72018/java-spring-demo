package com.fuchsia.fuchsia;

import lombok.Data;

import java.util.Date;

@Data
public class Exercise {
    private String userId;
    private int id;
    private String description;
    private String duration;        //TODO: change the type to date or time type??
    private Date date;

    public Exercise(String id, String description, String duration, Date date){
        userId = id;
        this.description = description;
        this.duration = duration;
        this.date = date;
    }

    public Exercise(String id, String description, String duration){
        userId = id;
        this.description = description;
        this.duration = duration;
    }
}
