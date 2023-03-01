package zack.san.PetApi.adoption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zack.san.PetApi.user.User;

import java.util.List;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest,AdoptionRequestId> {

    List<AdoptionRequest> findAllByUser(User user);

}
