package zack.san.PetApi.adoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.animal.AnimalServiceImpl;
import zack.san.PetApi.favorite.Favorite;
import zack.san.PetApi.user.User;
import zack.san.PetApi.user.UserServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/PetApi/v1/user/adoptionRequest")
public class AdoptionRequestController {


    private final AdoptionRequestServiceImpl adoptionRequestService;
    private final UserServiceImpl userService;
    private final AnimalServiceImpl animalService;

    @Autowired
    public AdoptionRequestController(AdoptionRequestServiceImpl adoptionRequestService, UserServiceImpl userService, AnimalServiceImpl animalService) {
        this.adoptionRequestService = adoptionRequestService;
        this.userService = userService;
        this.animalService = animalService;
    }

    @GetMapping("/getAll")
    public List<AdoptionRequest> getAllAdoptionRequests() {
        return adoptionRequestService.findAll();
    }


    @GetMapping("/{animalId}/{userId}")
    public ResponseEntity<AdoptionRequest> getAdoptionRequest(@PathVariable("animalId") Long animalId, @PathVariable("userId") Long userId) {
       User user = userService.findById(userId);
       Animal animal = animalService.findById(animalId);
       AdoptionRequest result = adoptionRequestService.findById(animal,user);
       if(result != null)
       {
           return ResponseEntity.ok(result);
       }else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userId}")
    public List<AdoptionRequest> getAdoptionRequestByUser(@PathVariable("userId") Long userId) {
        User user = userService.findById(userId);
        List<AdoptionRequest> result = adoptionRequestService.findAllByUser(user);
        return result;
    }


    // I should add more controllers actually two one for get for animal and other for get for user , a lot of for

    //WORKS

    @PostMapping("createAdoptionRequest")
    public ResponseEntity<AdoptionRequest> createAdoptionRequest(@RequestParam Long userId,@RequestParam Long animalId) {
       try{
           User user = userService.findById(userId);
           Animal animal = animalService.findById(animalId);
           AdoptionRequest adoptionRequest = new AdoptionRequest();
           adoptionRequest.setUser(user);
           adoptionRequest.setAnimal(animal);
           adoptionRequest.setAdoptionDate(LocalDate.now());
           adoptionRequest.setRequestStatus("Pending");
           return ResponseEntity.ok(adoptionRequestService.save(adoptionRequest));
       }catch (Exception e)
       {
           return ResponseEntity.badRequest().build();
       }

    }


    //works fine but should do more work if approved I have to update the animal user to other table and add owned table, so we track more stuff not now exactly but in future
//    i should add if a request approved the other should be rejected
    @PutMapping("updateAdoptionRequest")
    public ResponseEntity<AdoptionRequest> updateAdoptionRequest(@RequestParam("animalId") Long animalId, @RequestParam("userId") Long userId, @RequestParam("requestStatus") String requestStatus) {
        try{

            User user = userService.findById(userId);
            Animal animal = animalService.findById(animalId);
            AdoptionRequest ar = adoptionRequestService.findById(animal,user);
            ar.setRequestStatus(requestStatus);
            return ResponseEntity.ok(adoptionRequestService.update(ar));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }

    }

    // works fine

    @DeleteMapping("/{animalId}/{userId}")
    public ResponseEntity<String> deleteAdoptionRequest(@PathVariable("animalId") Long animalId, @PathVariable("userId") Long userId) {
      try{
          User user = userService.findById(userId);
          Animal animal = animalService.findById(animalId);
          adoptionRequestService.delete(adoptionRequestService.findById(animal,user));
          return ResponseEntity.ok("Request deleted successfully ");
      }catch (Exception e){

          return ResponseEntity.badRequest().build();

      }
    }






}




