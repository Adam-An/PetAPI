package zack.san.PetApi.favorite;

import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import java.util.List;

public interface FavoriteService {

    Favorite save(Favorite favorite);
    List<Favorite> findAll();
    Favorite findById(Animal animal, User user);
    Favorite update(Favorite favorite);
    void delete(Favorite favorite);

}
