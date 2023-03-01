package zack.san.PetApi.favorite;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import zack.san.PetApi.Serializers.FavoriteSerializer;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@IdClass(FavoriteId.class)
public class Favorite {


    //    @JsonIgnore
    @JsonSerialize(using = FavoriteSerializer.class)
    @Id
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;


    @JsonIgnore
    @Id
    @ManyToOne

    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDate date;

    // I need to serialize this



}
