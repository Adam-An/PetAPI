package zack.san.PetApi.permission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {


   Permission findPermissionByName(String name);

    @Query("FROM Permission p ORDER BY p.permissionId")
    List<Permission> findAllOrderByPermissionId();


    boolean existsByName(String name);

}
