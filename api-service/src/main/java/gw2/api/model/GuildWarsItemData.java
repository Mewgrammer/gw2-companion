package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsItemData {

    private int id;
    private int skin = -1;
    private int charges;
    private int count;
    private int[] upgrades;
    private int[] infusions;
    private String binding;
    private String boundTo;

    public enum Binding {
        ACCOUNT, CHARACTER;
    }

    public GuildWarsItemData() {
    }

    public GuildWarsItemData(int id, int skin, int charges, int count, int[] upgrades, int[] infusions, String binding, String boundTo) {
        this.id = id;
        this.skin = skin;
        this.charges = charges;
        this.count = count;
        this.upgrades = upgrades;
        this.infusions = infusions;
        this.binding = binding;
        this.boundTo = boundTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkin() {
        return skin;
    }

    public void setSkin(int skin) {
        this.skin = skin;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(int[] upgrades) {
        this.upgrades = upgrades;
    }

    public int[] getInfusions() {
        return infusions;
    }

    public void setInfusions(int[] infusions) {
        this.infusions = infusions;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getBoundTo() {
        return boundTo;
    }

    public void setBoundTo(String boundTo) {
        this.boundTo = boundTo;
    }
}

