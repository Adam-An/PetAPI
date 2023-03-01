package zack.san.PetApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/PetApi/v1")
public class LocationController {

    private final LocationServiceImpl locationService;
    private final UserServiceImpl userService;

    @Autowired
    public LocationController(LocationServiceImpl locationService, UserServiceImpl userService) {
        this.locationService = locationService;
        this.userService = userService;
    }

    @GetMapping("/dev/location/getAll")
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

    @GetMapping("/dev/location/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.findById(id);
    }



    // need to be fixed :
    // duplicated entity problems
    //

    @PostMapping("user/location")
    public ResponseEntity<Location> createLocation(@RequestBody Location location, @RequestParam Long userId) {
        User user = userService.findById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //location.setUser(user);
        Location savedLocation = locationService.save(location);
        user.setLocation(location);
        userService.save(user);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }
    //UPDATE WORKS, BUT I STILL NEED TO DO MORE CONTROL
    //yup works for now
    @PutMapping("user/location/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location) {
        location.setLocationId(id);
        return locationService.save(location);
    }


    //CAN'T DELETE UNTIL THE USER THAT HAS LOCATION IS DELETED SO IT'S NOT NEEDED FOR NOW :(
    /**
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.delete(locationService.findById(id));
    }**/
}
