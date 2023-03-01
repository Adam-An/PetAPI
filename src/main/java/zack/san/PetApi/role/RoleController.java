package zack.san.PetApi.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("PetApi/v1/dev/role")
public class RoleController {

    private final RoleServiceImpl roleService;

    @Autowired
    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }


    //working

    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }
    //working
    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        Optional<Role> optionalRole = Optional.ofNullable(roleService.findById(id));
        if (!optionalRole.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalRole.get());
    }


    // working but need verification
    @PostMapping("/creatRole")
    public ResponseEntity<Role> create(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }


    // working but need verification
    @PutMapping("/updateRole/{id}")
    public ResponseEntity<Role> update(@PathVariable Long id, @RequestBody Role role) {
        if (!id.equals(role.getRoleId())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(roleService.save(role));
    }

    //need a method to add permissions to role

    //working
    @DeleteMapping("deleteRole/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        roleService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
