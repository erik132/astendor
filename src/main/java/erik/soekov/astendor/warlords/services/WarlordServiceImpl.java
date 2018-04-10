package erik.soekov.astendor.warlords.services;

import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.repos.WarlordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarlordServiceImpl implements WarlordService{

    @Autowired
    private WarlordRepository warlordRepository;

    @Override
    public Warlord getWarlord(Integer id) {
        return this.warlordRepository.findById(id).get();
    }

    @Override
    public void setWarlord(Warlord warlord) {
        this.warlordRepository.save(warlord);
    }
}
