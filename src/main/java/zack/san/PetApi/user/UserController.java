package zack.san.PetApi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zack.san.PetApi.role.Role;
import zack.san.PetApi.role.RoleServiceImpl;

import java.util.List;

@RestController
@RequestMapping("PetApi/v1/user")
public class UserController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    @Autowired
    public UserController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    // works fine
    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody User user) {
        if (userService.existsById(user.getUserId())) {
            return ResponseEntity.badRequest().body(null);
        }
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(null);
        }
        if (userService.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(null);
        }
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // works fine
    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        if (userService.findUserByEmailAndPassword(email, password) == null) {
            return ResponseEntity.badRequest().build();
        }
        User user = userService.findUserByEmailAndPassword(email, password);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/allUsers")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/profile/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        if(userService.existsById(id))
        {
            return ResponseEntity.ok(userService.findById(id));
        }
        else
            return ResponseEntity.badRequest().build();

    }

    //update user
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {

        user.setUserId(id);
        if (userService.existsByUsernameAndIdNot( user.getUsername(),id)) {
            return ResponseEntity.badRequest().body(null);
        }
        if (userService.existsByEmailAndIdNot( user.getEmail(),id)) {
            return ResponseEntity.badRequest().body(null);
        }
        User updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser);

    }

    @PutMapping("profile/{id}/role")
    public ResponseEntity<String> updateRole(@PathVariable Long id, @RequestBody String roleName) {
        User user = userService.findById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Role role = roleService.findRoleByName(roleName);
        if (role == null) {
            return ResponseEntity.badRequest().body("we couldn't find role");
        }

        user.setRole(role);
        userService.save(user);
        return ResponseEntity.ok("role modified");
    }



    // I NEED TO CHECK IF USER ID EXISTS FIRST SO I DON'T GET THE  INTERNAL SERVER ERROR
    @DeleteMapping("profile/{id}/delete")
    public void delete(@PathVariable Long id) {
        userService.delete(userService.findById(id));
    }



}
