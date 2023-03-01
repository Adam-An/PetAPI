package zack.san.PetApi.favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService{


    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public Favorite save(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public List<Favorite> findAll() {
        return favoriteRepository.findAll();
    }

    @Override
    public Favorite findById(Animal animalId, User userId) {
        return favoriteRepository.findById(new FavoriteId(animalId, userId)).orElse(null);
    }

    @Override
    public Favorite update(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public void delete(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }


    public List<Favorite> getAllFavoritesByUser(User user) {
        return favoriteRepository.findAllByUser(user);
    }
}
