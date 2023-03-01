package zack.san.PetApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zack.san.PetApi.location.Location;
import zack.san.PetApi.role.Role;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(role))
                .collect(Collectors.toList());
    }

    @Override
    public User findByLocation(Location location) {
        return userRepository.findAll().stream()
                .filter(user -> user.getLocation().equals(location))
                .findFirst()
                .orElse(null);
    }


    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsernameAndIdNot(String username, Long id) {
        return userRepository.existsByUsernameAndUserIdNot(username, id);
    }

    @Override
    public boolean existsByEmailAndIdNot(String email, Long id) {
        return userRepository.existsByEmailAndUserIdNot(email, id);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email,password);
    }


}
