package zack.san.PetApi.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import zack.san.PetApi.Serializers.UserIdUsernameSerializer;
import zack.san.PetApi.adoption.AdoptionRequest;
import zack.san.PetApi.favorite.Favorite;
import zack.san.PetApi.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int age;

    private String imgPath;


    private String speciesName;


    private String breedType;

    @ManyToOne
    @JsonSerialize(using = UserIdUsernameSerializer.class)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdoptionRequest> adoptionRequests = new ArrayList<>();


    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favorite> favorites = new ArrayList<>();




}
