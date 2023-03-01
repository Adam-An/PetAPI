package zack.san.PetApi.adoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.animal.AnimalServiceImpl;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Configuration
@Order(7)
public class AdoptionRequestConfig  implements CommandLineRunner {

    private final AdoptionRequestServiceImpl adoptionRequestService;
    private final UserServiceImpl userService;

    private final AnimalServiceImpl animalService;

    @Autowired
    public AdoptionRequestConfig(AdoptionRequestServiceImpl adoptionRequestService, UserServiceImpl userService, AnimalServiceImpl animalService) {
        this.adoptionRequestService = adoptionRequestService;
        this.userService = userService;
        this.animalService = animalService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        User user = userService.findById(1L);

        Animal animal = animalService.findById(2L);

        AdoptionRequest adoptionRequest = new AdoptionRequest();
        adoptionRequest.setUser(user);
        adoptionRequest.setAnimal(animal);
        adoptionRequest.setAdoptionDate(LocalDate.now());
        adoptionRequest.setRequestStatus("Pending");
        adoptionRequestService.save(adoptionRequest);






    }
}
