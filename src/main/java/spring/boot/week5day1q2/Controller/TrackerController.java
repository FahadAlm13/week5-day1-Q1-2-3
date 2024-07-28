package spring.boot.week5day1q2.Controller;


import org.springframework.web.bind.annotation.*;
import spring.boot.week5day1q2.Api.ApiTracker;
import spring.boot.week5day1q2.Model.Tracker;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {
    //Q2
    ArrayList<Tracker> trackers = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Tracker> getTrackers() {
        return trackers;
    }

    //Post
    @PostMapping("add")
    public ApiTracker addTracker(@RequestBody Tracker tracker) {
        try {
            this.trackers.add(tracker);
            return new ApiTracker("Success tasks add", "200");
        } catch (Exception e) {
            System.out.println("Error adding tracker: " + e.getMessage());
        }
        return new ApiTracker("Failed to adding new tracker: ", "500");
    }

    //update
    @PutMapping("/update/{id}")
    public ApiTracker updateTracker(@RequestBody Tracker tracker, @PathVariable int id) {
        try {
            this.trackers.set(id, tracker);
            return new ApiTracker("Success tasks update", "200");
        } catch (Exception e) {
            System.out.println("Error updating tracker: " + e.getMessage());
        }
        return new ApiTracker("Failed to update tracker: ", "500");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ApiTracker deleteTracker(@PathVariable int id) {
        try {
            this.trackers.remove(id);
            return new ApiTracker("Success tasks delete", "200");
        } catch (Exception e) {
            System.out.println("Error deleting tracker: " + e.getMessage());
        }
        return new ApiTracker("Failed to delete tracker: ", "500");
    }

    //Change the project status as done or not done
    @PutMapping("/status/{index}")
    public ApiTracker changeStatus(@RequestParam String status, @PathVariable int index) {
        try {
            Tracker temp = this.trackers.get(index);
            temp.setStatus(status);
            return new ApiTracker("Success tasks change", "200");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error changing tracker: " + e.getMessage());
        }
        return new ApiTracker("Failed to change tracker: ", "500");
    }

    //Search for a project by given title
    @GetMapping("/search/{title}")
    public Tracker searchTracker(@PathVariable String title) {
        try {
            for (Tracker tracker : trackers) {
                if (tracker.getTitle().equals(title)) {
                    return tracker;
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching tracker: " + e.getMessage());
        }
        return null;
    }

    //• Display All project for one company by companyName.
    @GetMapping("getTrackersByCompanyName/{companyName}")
    public ArrayList<Tracker> getTrackersByCompanyName(@PathVariable String companyName) {
        ArrayList<Tracker> search = new ArrayList<>();
        for (Tracker tracker : trackers) {
            if (tracker.getCompanyName().equals(companyName)) {
                search.add(tracker);
            }
        }
         return search;
    }
}


