package zack.san.PetApi.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.animal.AnimalServiceImpl;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/PetApi/v1/user/favorites")
public class FavoriteController {


    private final FavoriteServiceImpl favoriteService;
    private final UserServiceImpl userService;
    private final AnimalServiceImpl animalService;

    @Autowired
    public FavoriteController(FavoriteServiceImpl favoriteService, UserServiceImpl userService, AnimalServiceImpl animalService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
        this.animalService = animalService;
    }





    // works fine :)
    @GetMapping("/{userId}")
    public List<Favorite> getAllFavoritesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setUserId(userId);
        return favoriteService.getAllFavoritesByUser(user);
    }


    //ids must be encoded
    //works find :)
    // must check if user already like this animal not allow to creation :)
    @PostMapping("/createFavorite")
    public Favorite createFavorite(@RequestParam Long userId,@RequestParam Long animalId) {
        User user = userService.findById(userId);
        Animal animal = animalService.findById(animalId);
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setAnimal(animal);
        favorite.setDate(LocalDate.now());
        return favoriteService.save(favorite);
    }



    // working
    @DeleteMapping("/{animalId}/{userId}")
    public void deleteFavorite(@PathVariable Long animalId, @PathVariable Long userId) {
        User user = new User();
        user.setUserId(userId);
        Animal animal = new Animal();
        animal.setAnimalId(animalId);
        Favorite favorite = favoriteService.findById(animal,user);
        favoriteService.delete(favorite);
    }







}
