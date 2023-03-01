package zack.san.PetApi.adoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zack.san.PetApi.animal.Animal;
import zack.san.PetApi.user.User;

import java.util.List;

@Service
public class AdoptionRequestServiceImpl implements AdoptionService{

    private final AdoptionRequestRepository adoptionRequestRepository;

    @Autowired
    public AdoptionRequestServiceImpl(AdoptionRequestRepository adoptionRequestRepository) {
        this.adoptionRequestRepository = adoptionRequestRepository;
    }

    @Override
    public AdoptionRequest save(AdoptionRequest adoptionRequest) {
        return adoptionRequestRepository.save(adoptionRequest);
    }

    @Override
    public List<AdoptionRequest> findAll() {
        return adoptionRequestRepository.findAll();
    }

    @Override
    public AdoptionRequest findById(Animal animalId, User userId) {
        return adoptionRequestRepository.findById(new AdoptionRequestId(animalId, userId)).orElse(null);
    }

    @Override
    public List<AdoptionRequest> findAllByUser(User user) {
        return adoptionRequestRepository.findAllByUser(user);
    }

    @Override
    public AdoptionRequest update(AdoptionRequest adoptionRequest) {
        return adoptionRequestRepository.save(adoptionRequest);
    }

    @Override
    public void delete(AdoptionRequest adoptionRequest) {
        adoptionRequestRepository.delete(adoptionRequest);
    }

}
