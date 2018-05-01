package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.Race;

import java.util.List;

public interface RaceService {

    public List<Race> getAllRaces();
    public Race getRace(Integer id);
}
