package erik.soekov.astendor.items.services;

import erik.soekov.astendor.items.models.Blueprint;
import erik.soekov.astendor.items.repos.BlueprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlueprintServiceStandard implements BlueprintService{

    @Autowired
    private BlueprintRepository blueprintRepository;

    @Override
    public List<Blueprint> getBlueprints() {
        List<Blueprint> result = new ArrayList<>();
        this.blueprintRepository.findAll().forEach(result::add);
        return result;
    }
}
