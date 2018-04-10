package erik.soekov.astendor.warlords.model;

public class StrippedWarlord {

    private Integer id;
    private Integer x;
    private Integer y;

    public StrippedWarlord(Warlord warlord) {
        this.id = warlord.getId();
        this.x = warlord.getX();
        this.y = warlord.getY();
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
}
