package com.example.lap5q3event.Controller;
import com.example.lap5q3event.Api.ApiResponse;
import com.example.lap5q3event.Model.Event;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Event")
public class EventController {

    ArrayList<Event> events = new ArrayList<Event>();

@GetMapping("/get")
    public ArrayList<Event> getEvents() {
    return events;
}
@PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
    events.add(event);
    return new ApiResponse("Event Added Successfully");
}
@PutMapping("/update/{index}")
    public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
    events.set(index, event);
    return new ApiResponse("Event Updated Successfully");
}
@DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
    events.remove(index);
    return new ApiResponse("Event Deleted Successfully");
}

@PutMapping("/capacity/{id}/{index}")
    public ApiResponse changeCapacity(@PathVariable int id ,@PathVariable int capacity ,@RequestBody Event event) {
   for(Event e : events) {
       if(e.getId() == id) {
           e.setCapacity(capacity);
       }
   }
    return new ApiResponse("Event Capacity Updated Successfully");
    }
 @GetMapping("/get/search/{id}")
 public ArrayList<Event> searchEventById(@PathVariable int id,@RequestBody Event event) {
    for(Event e : events) {
        if(e.getId() == id) {
            return events;
        }
    }
   return null;
 }
}



