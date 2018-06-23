package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.items.Details;
import me.nithanim.gw2api.v2.api.items.GameType;
import me.nithanim.gw2api.v2.api.items.ItemRarity;
import me.nithanim.gw2api.v2.api.items.ItemType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsItemInfo {
    private int id;
    private String name;
    private String icon;
    private String description;
    private String chatLink;
    private String type;
    private String rarity;
    private int level = -1;
    private int vendorValue = -1;
    private int defaultSkin = -1;
    private String[] flags;
    private String[] gameTypes;
    private String[] restrictions;

    public GuildWarsItemInfo() {
    }


    public GuildWarsItemInfo(int id, String name, String icon, String description, String chatLink, String type, String rarity, int level, int vendorValue, int defaultSkin, String[] flags, String[] gameTypes, String[] restrictions) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.chatLink = chatLink;
        this.type = type;
        this.rarity = rarity;
        this.level = level;
        this.vendorValue = vendorValue;
        this.defaultSkin = defaultSkin;
        this.flags = flags;
        this.gameTypes = gameTypes;
        this.restrictions = restrictions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChatLink() {
        return chatLink;
    }

    public void setChatLink(String chatLink) {
        this.chatLink = chatLink;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getVendorValue() {
        return vendorValue;
    }

    public void setVendorValue(int vendorValue) {
        this.vendorValue = vendorValue;
    }

    public int getDefaultSkin() {
        return defaultSkin;
    }

    public void setDefaultSkin(int defaultSkin) {
        this.defaultSkin = defaultSkin;
    }

    public String[] getFlags() {
        return flags;
    }

    public void setFlags(String[] flags) {
        this.flags = flags;
    }

    public String[] getGameTypes() {
        return gameTypes;
    }

    public void setGameTypes(String[] gameTypes) {
        this.gameTypes = gameTypes;
    }

    public String[] getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String[] restrictions) {
        this.restrictions = restrictions;
    }
}
