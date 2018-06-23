package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.account.CurrencyBelonging;
import me.nithanim.gw2api.v2.api.currencies.Currency;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsWalletItem {

    private int id;
    private String name;
    private String description;
    private long value;
    private int order;
    private String icon;


    public GuildWarsWalletItem(GuildWarsCurrencyIdentifier identifier, GuildWarsCurrencyDetails details) {
        this.id = identifier.getId();
        this.name = details.getName();
        this.description = details.getDescription();
        this.value = identifier.getValue();
        this.icon = details.getIcon();
        this.order = details.getOrder();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
