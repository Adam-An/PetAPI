package zack.san.PetApi.role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zack.san.PetApi.permission.Permission;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.roleRepository = repository;
    }


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public List<Role> findByPermission(Permission permission) {
        return roleRepository.findAll().stream()
                .filter(role -> role.getPermissions().contains(permission))
                .collect(Collectors.toList());
    }


    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
