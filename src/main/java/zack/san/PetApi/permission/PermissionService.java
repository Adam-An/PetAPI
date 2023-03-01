package zack.san.PetApi.permission;

import java.util.List;

public interface PermissionService {

    Permission save(Permission permission);
    List<Permission> findAll();
    List<Permission> findAllOrderByPermissionId();
    Permission findById(Long id);


    Permission update(Permission permission);
    void delete(Permission permission);

    boolean existById(Long id);

    boolean existsByName(String name);

}
