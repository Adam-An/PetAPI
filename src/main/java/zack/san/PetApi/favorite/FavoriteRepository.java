package zack.san.PetApi.favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zack.san.PetApi.user.User;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,FavoriteId> {


    List<Favorite> findAllByUser(User user);

}
