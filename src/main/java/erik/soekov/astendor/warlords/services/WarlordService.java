package erik.soekov.astendor.warlords.services;

import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.warlords.dtos.WarlordDTO;
import erik.soekov.astendor.warlords.exceptions.WarlordAlreadyExistsException;
import erik.soekov.astendor.warlords.model.Warlord;

public interface WarlordService {

    public Warlord getWarlord(Integer id);
    public void setWarlord(Warlord warlord);
    public void createWarlord(WarlordDTO warlordDTO,User user, Integer worldId) throws WarlordAlreadyExistsException;
}
