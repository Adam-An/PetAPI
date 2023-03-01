package zack.san.PetApi.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PetApi/v1/dev/permission")
public class PermissionController {

    private final PermissionServiceImpl permissionService;

    @Autowired
    public PermissionController(PermissionServiceImpl permissionService) {
        this.permissionService = permissionService;
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<Permission>> findAll() {
        List<Permission> permissions = permissionService.findAllOrderByPermissionId();
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> findById(@PathVariable Long id) {
        Permission permission = permissionService.findById(id);
        return ResponseEntity.ok(permission);
    }

    // WHEN THE OBJECT PASSED IN THE BODY MATCHES AND EXISTING PERMISSION IN DATA BASE IT DOESN'T INSERT THE OBJECT

    // I NEED TO PREVENT INSERTING TO DATABASE UNTIL I VERIFY THAT THE PERMISSION NAME ISN'T DUPLICATED solved :)
    // WHEN THE PERMISSION-ID PASSED IN BODY MATCHED AN EXISTING PERMISSION-ID IN DATABASE IT GETS UPDATED SO I HAVE TO PREVENT TO INSERT WITH THE SAME ID solved :)

    @PostMapping("/createPermission")
    public ResponseEntity<String> create(@RequestBody Permission permission) {
        if(permissionService.existById(permission.getPermissionId()))
        {
            return ResponseEntity.badRequest().body("Oops cant do that");
        }

        if(permissionService.existsByName(permission.getName()))
        {
            return ResponseEntity.badRequest().body("Permission with the same name already exists.\"");
        }
        permissionService.save(permission);
        return ResponseEntity.ok("Permission Created Successfully");
    }

    // ACTUALLY I SHOULD PREVENT USERS FROM UPDATING PERMISSIONS OR AT LEAST I SHOULDN'T ALLOW HAVING DUPLICATED PERMISSIONS THE NAME SHOULD BE UNIQUE

    /* I WILL NOT ALLOW USERS TO UPDATE PERMISSION NAMES FOR NOW

    @PutMapping("/{id}")
    public ResponseEntity<Permission> update(@PathVariable Long id, @RequestBody Permission permission) {
        permission.setPermissionId(id);
        Permission updatedPermission = permissionService.update(permission);
        return ResponseEntity.ok(updatedPermission);
    }*/




    // I NEED TO CHECK IF PERMISSION ID EXISTS FIRST SO I DON'T GET THE  INTERNAL SERVER ERROR

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if(!permissionService.existById(id))
        {
            return ResponseEntity.badRequest().body("Permission with "+ id +" doesn't exist");
        }

        permissionService.delete(permissionService.findById(id));
        return ResponseEntity.ok().build();
    }




}
