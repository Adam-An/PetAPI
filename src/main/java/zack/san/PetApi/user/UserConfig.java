package zack.san.PetApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.animal.AnimalServiceImpl;
import zack.san.PetApi.favorite.Favorite;
import zack.san.PetApi.favorite.FavoriteServiceImpl;
import zack.san.PetApi.location.LocationServiceImpl;
import zack.san.PetApi.role.RoleServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Configuration
@Order(3)
public class UserConfig implements CommandLineRunner {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;



    @Autowired
    public UserConfig(UserServiceImpl userService, RoleServiceImpl roleService, LocationServiceImpl locationService, AnimalServiceImpl animalService, FavoriteServiceImpl favoriteService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @Transactional
    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setUsername("user1");
        user1.setFirstname("John");
        user1.setLastname("Doe");
        user1.setEmail("user1@example.com");
        user1.setPassword("password");
        user1.setImgPath("/images/user1.jpg");
        user1.setRole(roleService.findById(1L));
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setFirstname("Jane");
        user2.setLastname("Doe");
        user2.setEmail("user2@example.com");
        user2.setPassword("password");
        user2.setImgPath("/images/user2.jpg");
        user2.setRole(roleService.findById(2L));
        userService.save(user2);

        
    }
}
