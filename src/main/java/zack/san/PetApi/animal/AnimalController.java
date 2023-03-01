package zack.san.PetApi.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/PetApi/v1/animal")
public class AnimalController {

    private final AnimalServiceImpl animalService;
    private final UserServiceImpl userService;

    @Autowired
    public AnimalController(AnimalServiceImpl animalService, UserServiceImpl userService) {
        this.animalService = animalService;
        this.userService = userService;
    }

    @GetMapping("/brows")
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok(animalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.findById(id));
    }

    @PostMapping("user/create-animal/{userId}")
    public ResponseEntity<Animal> create(@PathVariable Long userId,@RequestBody Animal animal) {
        User user = userService.findById(userId);
        if(user == null)
        {
            return ResponseEntity.badRequest().build();
        }
        animal.setUser(user);
        return ResponseEntity.ok(animalService.save(animal));
    }

    // here for update I have to control of editing the user id etc ...
    @PutMapping("user/updateAnimal/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {
        if (!id.equals(animal.getAnimalId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(animalService.save(animal));
    }

    // if an animal owner delete the animal also is deleted :)
    @DeleteMapping("user/deleteAnimal/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.delete(animalService.findById(id));
        return ResponseEntity.ok().build();
    }



}
