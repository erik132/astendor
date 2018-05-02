package erik.soekov.astendor.warlords.model;

import javax.persistence.*;

@Entity
@Table(name = "warlords")
public class WarlordPrimitive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int x;
    private int y;

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "race_id")
    private Integer raceId;
    @Column(name = "world_id")
    private Integer worldId;

    public WarlordPrimitive() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRaceId() {
        return raceId;
    }

    public void setRaceId(Integer raceId) {
        this.raceId = raceId;
    }

    public Integer getWorldId() {
        return worldId;
    }

    public void setWorldId(Integer worldId) {
        this.worldId = worldId;
    }

    @Override
    public boolean equals(Object obj) {
        WarlordPrimitive other;
        try{
            other = (WarlordPrimitive)obj;
        }catch (Exception e){
            return false;
        }

        if(other.getId() == this.id){
            return true;
        }
        return false;
    }
}
