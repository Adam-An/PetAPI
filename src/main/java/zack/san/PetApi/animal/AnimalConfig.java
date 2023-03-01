package zack.san.PetApi.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import javax.transaction.Transactional;

@Configuration
@Order(5)
public class AnimalConfig implements CommandLineRunner {

    private final AnimalServiceImpl animalService;
    private final UserServiceImpl userService;

    @Autowired
    public AnimalConfig(AnimalServiceImpl animalService, UserServiceImpl userService) {
        this.animalService = animalService;
        this.userService = userService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {


        User user1 = userService.findById(1L);
        Animal animal1 = new Animal();
        animal1.setName("Fluffy");
        animal1.setSpeciesName("Dog");
        animal1.setBreedType("Poodle");
        animal1.setGender("Male");
        animal1.setAge(3);
        animal1.setImgPath("/images/animal1.jpg");
        animal1.setUser(user1);

        animalService.save(animal1);
        user1.getAnimals().add(animal1);
        userService.save(user1);

        User user2 = userService.findById(2L);
        Animal animal2 = new Animal();
        animal2.setName("Whiskers");
        animal2.setSpeciesName("Cat");
        animal2.setBreedType("Siamese");
        animal2.setGender("Female");
        animal2.setAge(2);
        animal2.setImgPath("/images/animal2.jpg");
        animal2.setUser(user2);

        animalService.save(animal2);
        user2.getAnimals().add(animal2);
        userService.save(user2);




    }
}
