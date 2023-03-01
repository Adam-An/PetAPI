package zack.san.PetApi.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.animal.AnimalServiceImpl;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Configuration
@Order(6)
public class FavoriteConfig implements CommandLineRunner {

    private final FavoriteServiceImpl favoriteService;
    private final UserServiceImpl userService;
    private final AnimalServiceImpl animalService;

    @Autowired
    public FavoriteConfig(FavoriteServiceImpl favoriteService, UserServiceImpl userService, AnimalServiceImpl animalService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
        this.animalService = animalService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Find a user and an animal
        User user1 = userService.findById(1L);
        Animal animal1 = animalService.findById(1L);

        // Create a new favorite
        Favorite favorite = new Favorite();
        favorite.setUser(user1);
        favorite.setAnimal(animal1);
        favorite.setDate(LocalDate.now());

        // Save the favorite
        favoriteService.save(favorite);
    }

}
