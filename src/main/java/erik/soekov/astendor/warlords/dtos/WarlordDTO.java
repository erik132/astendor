package erik.soekov.astendor.warlords.dtos;

import erik.soekov.astendor.warlords.model.Warlord;

public class WarlordDTO {

    private Integer id;
    private Integer x;
    private Integer y;
    private Integer raceId;

    public WarlordDTO() {
    }

    public WarlordDTO(Warlord warlord){
        this.id = warlord.getId();
        this.x = warlord.getX();
        this.y = warlord.getY();
        this.raceId = warlord.getRace().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }
}
