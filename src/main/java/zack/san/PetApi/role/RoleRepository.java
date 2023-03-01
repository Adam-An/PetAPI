package zack.san.PetApi.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zack.san.PetApi.permission.Permission;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findByPermissionsContaining(Permission permission);


    Role findRoleByName(String roleName);
}
