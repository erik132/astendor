package erik.soekov.astendor.worldState.models;


import erik.soekov.astendor.warlords.dtos.WarlordDTO;


public class WorldState {

    private boolean isError = false;
    private String errorMsg = "";
    private WarlordDTO warlord;

    public WorldState() {
    }

    public WorldState(WarlordDTO warlord) {
        this.warlord = warlord;
    }

    public WarlordDTO getWarlord() {
        return warlord;
    }

    public void setWarlord(WarlordDTO warlord) {
        this.warlord = warlord;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        this.isError = true;
    }
}
