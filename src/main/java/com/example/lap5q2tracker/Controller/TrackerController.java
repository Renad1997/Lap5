package com.example.lap5q2tracker.Controller;

import com.example.lap5q2tracker.Api.ApiResponse;
import com.example.lap5q2tracker.Model.Tracker;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Tracker")
public class TrackerController {

 ArrayList<Tracker> trackers = new ArrayList<Tracker>();

 @GetMapping("/get")
    public ArrayList<Tracker> getTrackers() {
     return trackers;
 }
 @PostMapping("/add")
    public ApiResponse addTracker(@RequestBody Tracker tracker) {
     trackers.add(tracker);
     return new ApiResponse("Tracker Added Successfully");
 }
 @PutMapping("/update/{index}")
    public ApiResponse updateTracker(@PathVariable int index, @RequestBody Tracker tracker) {
     trackers.set(index, tracker);
     return new ApiResponse("Tracker Updated Successfully");
 }
 @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTracker(@PathVariable int index) {
     trackers.remove(index);
     return new ApiResponse("Tracker Deleted Successfully");
 }
@PutMapping("/update/status/{index}")
 public ApiResponse changeStatus(@PathVariable int index){
     if (index < trackers.size()){
        if (trackers.get(index).getStatus().equals("done")){
            trackers.get(index).setStatus("not done");
            return new ApiResponse("Tracker Status Changed Successfully");
        }
        else if (trackers.get(index).getStatus().equals("not done")){
           trackers.get(index).setStatus("done");
           return new ApiResponse("Tracker Status Changed Successfully");
        }
     }
     return new ApiResponse("Tracker Status Not Found");
 }

 @GetMapping("/get1")
    public ApiResponse searchTitle(@RequestBody String title) {
     for (Tracker tracker : trackers) {
         if(tracker.getTitle().equalsIgnoreCase(title)){
             return new ApiResponse("Tracker Title Matched");
         }
     }
     return new ApiResponse("Tracker Title Not Found");
 }

 @GetMapping("/display/{companyName}")
    public ArrayList<Tracker> displayTracker(@PathVariable String companyName) {
     ArrayList<Tracker> trackerlist = new ArrayList<Tracker>();
     for (Tracker tracker : trackers) {
         if(tracker.getCompanyName().equalsIgnoreCase(companyName)){
             trackerlist.add(tracker);
         }
     }
     return trackerlist;
 }







}
