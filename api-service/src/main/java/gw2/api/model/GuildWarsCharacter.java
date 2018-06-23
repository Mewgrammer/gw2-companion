package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.characters.*;

import java.util.Date;
import java.util.EnumMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsCharacter {

    private String name;
    private String race;
    private String gender;
    private String profession;
    private int level;
    private String guild;
    private int age;
    private Date created;
    private int deaths;
    private GuildWarsCharacterCraftingInfo[] crafting;

    public GuildWarsCharacter() {}

    public GuildWarsCharacter(String name, String race, String gender, String profession, int level, String guild, int age, Date created, int deaths, GuildWarsCharacterCraftingInfo[] crafting) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.profession = profession;
        this.level = level;
        this.guild = guild;
        this.age = age;
        this.created = created;
        this.deaths = deaths;
        this.crafting = crafting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public GuildWarsCharacterCraftingInfo[] getCrafting() {
        return crafting;
    }

    public void setCrafting(GuildWarsCharacterCraftingInfo[] crafting) {
        this.crafting = crafting;
    }
}
