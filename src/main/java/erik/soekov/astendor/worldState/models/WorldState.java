package erik.soekov.astendor.worldState.models;


import erik.soekov.astendor.warlords.model.StrippedWarlord;


public class WorldState {

    private StrippedWarlord warlord;

    public WorldState(StrippedWarlord warlord) {
        this.warlord = warlord;
    }

    public StrippedWarlord getWarlord() {
        return warlord;
    }

    public void setWarlord(StrippedWarlord warlord) {
        this.warlord = warlord;
    }
}
