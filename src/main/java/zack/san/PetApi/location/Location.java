package zack.san.PetApi.location;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import zack.san.PetApi.user.User;

import javax.persistence.*;


@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private double latitude;

    @JsonIgnore
    @OneToOne(mappedBy = "location")
    private User user;


}
