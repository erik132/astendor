package erik.soekov.astendor.worlds.models;


import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.warlords.model.WarlordPrimitive;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="worlds")
public class WorldNoTiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "turn_nr")
    private Integer turnNr;

    @Column(name = "harvest_multi")
    private Float harvestMulti;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "world_id")
    private Set<WarlordPrimitive> warlords;


    public WorldNoTiles() {
    }


    public boolean checkForWarlord(User user){
        if(this.findWarlord(user) != null){
            return true;
        }
        return false;
    }

    public WarlordPrimitive findWarlord(User user){
        for(WarlordPrimitive warlord : this.getWarlords()){
            if(warlord.getUserId().equals(user.getId())){
                return warlord;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurnNr() {
        return turnNr;
    }

    public void setTurnNr(Integer turnNr) {
        this.turnNr = turnNr;
    }

    public void increaseTurn(){
        this.turnNr++;
    }

    public Set<WarlordPrimitive> getWarlords() {
        return warlords;
    }

    public void setWarlords(Set<WarlordPrimitive> warlords) {
        this.warlords = warlords;
    }

    public Float getHarvestMulti() {
        return harvestMulti;
    }

    public void setHarvestMulti(Float harvestMulti) {
        this.harvestMulti = harvestMulti;
    }
}
