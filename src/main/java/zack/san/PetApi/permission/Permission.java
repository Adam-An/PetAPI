package zack.san.PetApi.permission;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import zack.san.PetApi.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Permission {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(nullable = false , unique = true)
    private String name;

     /**
     * I commented this property cuz its cause recursion problem, and we actually don't need it
     * @ManyToMany(mappedBy = "permissions")
     * private Set<Role> roles = new HashSet<>();
     **/


}
