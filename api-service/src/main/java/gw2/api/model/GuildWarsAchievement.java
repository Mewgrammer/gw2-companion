package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.achievements.Achievement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsAchievement {

    private int id = -1;
    private String icon;
    private String name;
    private String description;
    private String requirement;
    private String type;
    private String[] flags;


    public GuildWarsAchievement() {
    }

    public GuildWarsAchievement(int id, String icon, String name, String description, String requirement, String type, String[] flags) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.description = description;
        this.requirement = requirement;
        this.type = type;
        this.flags = flags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getFlags() {
        return flags;
    }

    public void setFlags(String[] flags) {
        this.flags = flags;
    }
}
