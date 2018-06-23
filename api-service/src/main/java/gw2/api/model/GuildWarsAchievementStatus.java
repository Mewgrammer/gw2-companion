package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsAchievementStatus {
    private int id = -1;
    private int current = -1;
    private int max = -1;
    private boolean done = false;
    private int[] bits;
    private int repeated = -1;

    public GuildWarsAchievementStatus() {
    }

    public GuildWarsAchievementStatus(int id, int current, int max, boolean done, int[] bits, int repeated) {
        this.id = id;
        this.current = current;
        this.max = max;
        this.done = done;
        this.bits = bits;
        this.repeated = repeated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int[] getBits() {
        return bits;
    }

    public void setBits(int[] bits) {
        this.bits = bits;
    }

    public int getRepeated() {
        return repeated;
    }

    public void setRepeated(int repeated) {
        this.repeated = repeated;
    }
}
