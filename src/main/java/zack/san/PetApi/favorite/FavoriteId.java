package zack.san.PetApi.favorite;

import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import java.io.Serializable;

public class FavoriteId implements Serializable {
    private Long animal;
    private Long user;

    public FavoriteId() {}

    public FavoriteId(Animal animal1, User user1) {
        this.animal = animal1.getAnimalId();
        this.user = user1.getUserId();
    }



}
