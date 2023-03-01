package zack.san.PetApi.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zack.san.PetApi.Serializers.AnimalIdSerializer;
import zack.san.PetApi.adoption.AdoptionRequest;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.favorite.Favorite;
import zack.san.PetApi.location.Location;
import zack.san.PetApi.role.Role;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;


    private String phone;


    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String imgPath;


    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "location_id")
    private Location location;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonSerialize(using = AnimalIdSerializer.class)
    private List<Animal> animals = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdoptionRequest> adoptionRequests = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "role_id", nullable = true)
    private Role role;

    public User(Long userId, String username, String firstname, String lastname, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
}
