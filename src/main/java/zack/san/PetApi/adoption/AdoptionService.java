package zack.san.PetApi.adoption;

import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import java.util.List;

public interface AdoptionService {

    AdoptionRequest save(AdoptionRequest adoptionRequest);
    List<AdoptionRequest> findAll();
    AdoptionRequest findById(Animal animalId, User userId);

    List<AdoptionRequest> findAllByUser(User user);


    AdoptionRequest update(AdoptionRequest adoptionRequest);
    void delete(AdoptionRequest adoptionRequest);



}
