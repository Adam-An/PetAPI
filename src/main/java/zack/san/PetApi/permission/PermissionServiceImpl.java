package zack.san.PetApi.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public List<Permission> findAllOrderByPermissionId() {
        return permissionRepository.findAllOrderByPermissionId();
    }

    @Override
    public Permission findById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }


    public Permission findByName(String name){return permissionRepository.findPermissionByName(name);}

    @Override
    public Permission update(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void delete(Permission permission) {
        permissionRepository.delete(permission);
    }

    @Override
    public boolean existById(Long id) {
        return permissionRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return permissionRepository.existsByName(name);
    }


}
