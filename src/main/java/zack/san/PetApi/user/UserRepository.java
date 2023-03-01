package zack.san.PetApi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zack.san.PetApi.location.Location;
import zack.san.PetApi.role.Role;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // find users by role
    List<User> findByRole(Role role);

    // find user by location
    User findByLocation(Location location);

    boolean deleteByUserId(Long id);

    //User update();

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);



    boolean existsByUsernameAndUserIdNot(String username, Long id);

    boolean existsByEmailAndUserIdNot(String email ,Long id);




}
