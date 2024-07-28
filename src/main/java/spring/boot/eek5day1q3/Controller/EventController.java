package spring.boot.eek5day1q3.Controller;

import org.springframework.web.bind.annotation.*;
import spring.boot.eek5day1q3.Api.ApiEvent;
import spring.boot.eek5day1q3.Model.Event;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    //Q3
    ArrayList<Event> events = new ArrayList<>();

    //get
    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }

    //Post
    @PostMapping("/add")
    public ApiEvent addEvent(@RequestBody Event event) {
        try {
            this.events.add(event);
            return new ApiEvent("Success add event","200");
        }catch(Exception e) {
            System.out.println("Error adding event");
        }
        return new ApiEvent("Failed to add event","500");
    }

    //update
    @PutMapping("/update/{index}")
    public ApiEvent updateEvent(@RequestBody Event event , @PathVariable int index) {
        try {
            this.events.set(index, event);
            return new ApiEvent("Success update event","200");
        }catch(Exception e) {
            System.out.println("Error updating event");
        }
        return new ApiEvent("Failed to update event","500");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public ApiEvent deleteEvent(@PathVariable int index) {
        try {
            this.events.remove(index);
            return new ApiEvent("Success delete event","200");
        }catch(Exception e) {
            System.out.println("Error deleting event");
        }
        return new ApiEvent("Failed to delete event","500");
    }

    //Change capacity
    @PutMapping("/capacity/{index}")
    public ApiEvent changeCapacity(@RequestParam int capacity , @PathVariable int index) {
       try {
           ArrayList<Event> events = this.events;
           Event event = events.get(index);
           event.setCapacity(capacity);
           return new ApiEvent("Success change capacity","200");
       }catch(Exception e) {
           System.out.println("Error changing capacity");
       }
       return new ApiEvent("Failed to change capacity","500");
    }
    //Search for a event by given id
    @GetMapping("/search/{id}")
    public Event getEventById(@PathVariable int id) {
        try {
            for(Event event : this.events) {
                if(event.getId() == id) {
                    return event;
                }
            }
        }catch(Exception e) {
            System.out.println("Error getting event");
        }
        return null;
    }
}
