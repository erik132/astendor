package erik.soekov.astendor.maps.services;

import erik.soekov.astendor.maps.models.MapTile;
import erik.soekov.astendor.maps.repos.TileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TileServiceImpl implements TileService{

    @Autowired
    private TileRepository tileRepository;

    @Override
    public List<MapTile> getTiles() {
        List<MapTile> tiles = new ArrayList<>();
        tileRepository.findAll().forEach(tiles::add);
        return tiles;
    }
}
