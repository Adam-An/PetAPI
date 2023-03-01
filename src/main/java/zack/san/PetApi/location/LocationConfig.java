package zack.san.PetApi.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import javax.transaction.Transactional;

@Configuration
public class LocationConfig implements CommandLineRunner {

    private final LocationServiceImpl locationService;
    private final UserServiceImpl userService;

    @Autowired
    public LocationConfig(LocationServiceImpl locationService, UserServiceImpl userService) {
        this.locationService = locationService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        User user1 = userService.findById(1L);
        Location location1 = new Location();
        location1.setAddress("123 Main Street");
        location1.setCity("New York");
        location1.setCountry("USA");
        location1.setLatitude(40.7128);
        location1.setLongitude(-74.0060);
        location1.setUser(user1);
        locationService.save(location1);
        user1.setLocation(location1);
        userService.save(user1);

        User user2 = userService.findById(2L);
        Location location2 = new Location();
        location2.setAddress("456 Main Street");
        location2.setCity("Chicago");
        location2.setCountry("USA");
        location2.setLatitude(41.8781);
        location2.setLongitude(-87.6298);
        location2.setUser(user2);
        locationService.save(location2);
        user2.setLocation(location2);
        userService.save(user2);
    }
}
