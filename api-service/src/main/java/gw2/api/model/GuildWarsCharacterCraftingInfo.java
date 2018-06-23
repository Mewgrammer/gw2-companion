package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsCharacterCraftingInfo {
    private String discipline;
    private int rating;
    private boolean active;

    public GuildWarsCharacterCraftingInfo(String discipline, int rating, boolean active) {
        this.discipline = discipline;
        this.rating = rating;
        this.active = active;
    }

    public GuildWarsCharacterCraftingInfo() {
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
