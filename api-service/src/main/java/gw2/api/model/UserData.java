package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.characters.Character;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    public List<GuildWarsWalletItem> wallet;
    public GuildWarsAccount account;
    public List<GuildWarsAchievementProgress> achievements;
    public List<GuildWarsCharacter> characters;
    public List<GuildWarsItem> bank;
}
