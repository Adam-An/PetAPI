package zack.san.PetApi.user;

import zack.san.PetApi.location.Location;
import zack.san.PetApi.role.Role;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    User findById(Long id);
    User update(User user);


    void delete(User user);
    List<User> findByRole(Role role);
    User findByLocation(Location location);

    boolean existsById(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    boolean existsByUsernameAndIdNot(String username, Long id);

    boolean existsByEmailAndIdNot(String email ,Long id);


    User findUserByEmailAndPassword(String email, String password);







}
