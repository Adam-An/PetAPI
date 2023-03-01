package zack.san.PetApi.role;

import zack.san.PetApi.permission.Permission;

import java.util.List;

public interface RoleService {

    Role save(Role role);
    List<Role> findAll();
    Role findById(Long id);

    Role findRoleByName(String roleName);

    Role update(Role role);
    void delete(Role role);
    List<Role> findByPermission(Permission permission);

}
