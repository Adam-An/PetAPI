package zack.san.PetApi.animal;

import java.util.List;

public interface AnimalService {

    Animal save(Animal animal);
    List<Animal> findAll();
    Animal findById(Long id);
    Animal update(Animal animal);
    void delete(Animal animal);

}
