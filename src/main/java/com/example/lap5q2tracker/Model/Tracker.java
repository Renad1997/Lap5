package com.example.lap5q2tracker.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tracker {

    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;

}
