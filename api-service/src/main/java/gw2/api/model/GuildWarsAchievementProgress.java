package gw2.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.nithanim.gw2api.v2.api.account.AchievementStatus;
import me.nithanim.gw2api.v2.api.achievements.Achievement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildWarsAchievementProgress {
    private GuildWarsAchievementStatus achievementStatus;
    private GuildWarsAchievement achievement;

    public GuildWarsAchievementProgress() {
    }

    public GuildWarsAchievementProgress(GuildWarsAchievement achievement, GuildWarsAchievementStatus achievementStatus) {
        this.achievement = achievement;
        this.achievementStatus = achievementStatus;
    }

    public GuildWarsAchievementStatus getAchievementStatus() {
        return achievementStatus;
    }

    public void setAchievementStatus(GuildWarsAchievementStatus achievementStatus) {
        this.achievementStatus = achievementStatus;
    }

    public GuildWarsAchievement getAchievement() {
        return achievement;
    }

    public void setAchievement(GuildWarsAchievement achievement) {
        this.achievement = achievement;
    }
}
