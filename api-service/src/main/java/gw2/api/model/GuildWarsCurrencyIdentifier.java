package gw2.api.model;

public class GuildWarsCurrencyIdentifier {

    private int id;
    private long value;

    public  GuildWarsCurrencyIdentifier(){}

    public GuildWarsCurrencyIdentifier(int id, long value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
