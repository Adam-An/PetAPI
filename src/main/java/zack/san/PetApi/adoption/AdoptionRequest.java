package zack.san.PetApi.adoption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import zack.san.PetApi.Serializers.AnimalIdSerializer;
import zack.san.PetApi.Serializers.UserIdUsernameSerializer;
import zack.san.PetApi.animal.Animal;

import zack.san.PetApi.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@IdClass(AdoptionRequestId.class)
@Data
public class AdoptionRequest {


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
    private LocalDate adoptionDate;

    @Column(nullable = false)
    private String requestStatus;


//    ohhh i need to serialize this too

   /* public AdoptionRequest() {
    }

    public AdoptionRequest(Animal animal, User user, LocalDate now, String pending) {
    }*/
}
