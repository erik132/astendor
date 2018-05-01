package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.Race;
import erik.soekov.astendor.maps.repos.RaceRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceServiceStandard implements RaceService {

    @Autowired
    private RaceRepostitory raceRepostitory;

    @Override
    public List<Race> getAllRaces() {
        List<Race> races = new ArrayList<>();
        this.raceRepostitory.findAll().forEach(races::add);
        return races;
    }

    @Override
    public Race getRace(Integer id) {
        return this.raceRepostitory.findById(id).get();
    }
}
