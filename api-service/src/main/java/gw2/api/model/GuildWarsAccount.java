package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsAccount {

    private String id;
    private String name;
    private int age;
    private int world = -1;
    private String[] guilds;
    private String[] guild_leader;
    private Date created;
    private String[] access;
    private boolean commander;
    private int fractal_level = -1;
    private int daily_ap;
    private int monthly_ap;
    private int wvw_rank;

    public GuildWarsAccount(String id, String name, int age, int world, String[] guilds, Date created, String[] access, boolean commander, int fractal_level, int daily_ap, int monthly_ap, int wvw_rank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.world = world;
        this.guilds = guilds;
        this.created = created;
        this.access = access;
        this.commander = commander;
        this.fractal_level = fractal_level;
        this.daily_ap = daily_ap;
        this.monthly_ap = monthly_ap;
        this.wvw_rank = wvw_rank;
    }

    public GuildWarsAccount() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWorld() {
        return world;
    }

    public String[] getGuilds() {
        return guilds;
    }

    public Date getCreated() {
        return created;
    }

    public String[] getAccess() {
        return access;
    }

    public boolean isCommander() {
        return commander;
    }

    public int getFractal_level() {
        return fractal_level;
    }

    public int getDaily_ap() {
        return daily_ap;
    }

    public int getMonthly_ap() {
        return monthly_ap;
    }

    public int getWvw_rank() {
        return wvw_rank;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorld(int world) {
        this.world = world;
    }

    public void setGuilds(String[] guilds) {
        this.guilds = guilds;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setAccess(String[] access) {
        this.access = access;
    }

    public void setCommander(boolean commander) {
        this.commander = commander;
    }

    public void setFractal_level(int fractal_level) {
        this.fractal_level = fractal_level;
    }

    public void setDaily_ap(int daily_ap) {
        this.daily_ap = daily_ap;
    }

    public void setMonthly_ap(int monthly_ap) {
        this.monthly_ap = monthly_ap;
    }

    public void setWvw_rank(int wvw_rank) {
        this.wvw_rank = wvw_rank;
    }
}
