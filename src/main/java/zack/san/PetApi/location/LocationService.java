package zack.san.PetApi.location;

import java.util.List;

public interface LocationService {

    Location save(Location location);
    List<Location> findAll();
    Location findById(Long id);
    Location update(Location location);
    void delete(Location location);

}
