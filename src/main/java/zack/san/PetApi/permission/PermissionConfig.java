package zack.san.PetApi.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class PermissionConfig implements CommandLineRunner {

    private final PermissionServiceImpl permissionService;

    @Autowired
    public PermissionConfig(PermissionServiceImpl permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public void run(String... args) throws Exception {

        Permission readPermission = new Permission();
        readPermission.setName("READ");
        permissionService.save(readPermission);

        Permission writePermission = new Permission();
        writePermission.setName("WRITE");
        permissionService.save(writePermission);

        Permission deletePermission = new Permission();
        deletePermission.setName("DELETE");
        permissionService.save(deletePermission);

    }
}
