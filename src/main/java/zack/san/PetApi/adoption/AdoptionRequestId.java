package zack.san.PetApi.adoption;

import lombok.Data;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import java.io.Serializable;

public class AdoptionRequestId implements Serializable {

    private Long animal;
    private Long user;

    public AdoptionRequestId() {
    }



    public AdoptionRequestId(Animal animal1, User user1) {
        this.animal = animal1.getAnimalId();
        this.user = user1.getUserId();
    }
}
