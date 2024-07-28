package com.example.lap5q3event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class Event {
private int id;
private String description;
private int capacity;
private LocalDateTime startDate;
private LocalDateTime endDate;

}
