package erik.soekov.astendor.worldState.models;


import erik.soekov.astendor.warlords.dtos.WarlordDTO;


public class WorldState {

    private WarlordDTO warlord;

    public WorldState(WarlordDTO warlord) {
        this.warlord = warlord;
    }

    public WarlordDTO getWarlord() {
        return warlord;
    }

    public void setWarlord(WarlordDTO warlord) {
        this.warlord = warlord;
    }
}
