package zack.san.PetApi.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import zack.san.PetApi.permission.Permission;
import zack.san.PetApi.permission.PermissionServiceImpl;

import javax.transaction.Transactional;

@Configuration
@Order(2)
public class RoleConfig implements CommandLineRunner {

    private final RoleServiceImpl roleService;
    private final PermissionServiceImpl permissionService;

    @Autowired
    public RoleConfig(RoleServiceImpl roleService, PermissionServiceImpl permissionService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Role role1 = new Role();
        role1.setName("admin");
        roleService.save(role1);

        // Retrieve an existing permission from the database
        Permission permission1 = permissionService.findByName("READ");
        Permission permission2 = permissionService.findByName("WRITE");
        Permission permission3 = permissionService.findByName("DELETE");

        // Add the permission to the role
        role1.getPermissions().add(permission1);
        role1.getPermissions().add(permission2);
        role1.getPermissions().add(permission3);
        roleService.save(role1);

        Role role2 = new Role();
        role2.setName("user");
        role2.getPermissions().add(permission1);
        roleService.save(role2);

    }
}
