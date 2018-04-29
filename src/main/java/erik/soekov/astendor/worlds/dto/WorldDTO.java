package erik.soekov.astendor.worlds.dto;

public class WorldDTO {

    private String name;
    private Integer mapId;

    public WorldDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    @Override
    public String toString() {
        return this.mapId + " " + this.name;
    }
}
