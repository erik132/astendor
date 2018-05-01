package erik.soekov.astendor.warlords.services;

import erik.soekov.astendor.maps.services.RaceService;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.warlords.dtos.WarlordDTO;
import erik.soekov.astendor.warlords.exceptions.WarlordAlreadyExistsException;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.repos.WarlordRepository;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarlordServiceImpl implements WarlordService{

    @Autowired
    private WarlordRepository warlordRepository;

    @Autowired
    private WorldService worldService;

    @Autowired
    private RaceService raceService;

    @Override
    public Warlord getWarlord(Integer id) {
        return this.warlordRepository.findById(id).get();
    }

    @Override
    public void setWarlord(Warlord warlord) {
        this.warlordRepository.save(warlord);
    }

    @Override
    public void createWarlord(WarlordDTO warlordDTO, User user, Integer worldId) throws WarlordAlreadyExistsException {
        World world = this.worldService.getWorld(worldId);
        if(world.checkForWarlord(user)){
            throw new WarlordAlreadyExistsException("Warlord already exists in world " + world.getName());
        }

        Warlord warlord = new Warlord();
        warlord.setX(1);
        warlord.setY(1);
        warlord.setRace(this.raceService.getRace(warlordDTO.getRaceId()));
        warlord.setUserId(user.getId());
        warlord.setWorld(world);

        this.warlordRepository.save(warlord);
    }
}
