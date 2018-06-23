package gw2.api.model;

public class GuildWarsCurrencyDetails {
    private int id;
    private String name;
    private String description;
    private int order;
    private String icon;

    public GuildWarsCurrencyDetails(int id, String name, String description, int order, String icon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.order = order;
        this.icon = icon;
    }

    public GuildWarsCurrencyDetails() {
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
