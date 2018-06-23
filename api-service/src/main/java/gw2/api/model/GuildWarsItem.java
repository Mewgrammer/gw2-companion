package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.items.ItemInfo;
import me.nithanim.gw2api.v2.common.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsItem {

    private GuildWarsItemData item;
    private GuildWarsItemInfo itemInfo;

    public GuildWarsItem(GuildWarsItemData item, GuildWarsItemInfo itemInfo) {
        this.item = item;
        this.itemInfo = itemInfo;
    }

    public GuildWarsItem() {
    }

    public GuildWarsItemData getItem() {
        return item;
    }

    public void setItem(GuildWarsItemData item) {
        this.item = item;
    }

    public GuildWarsItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(GuildWarsItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }
}


