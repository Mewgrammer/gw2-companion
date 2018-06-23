import {GuildWarsAchievementStatus} from './GuildWarsAchievementStatus.';
import {GuildWarsAchievement} from './GuildWarsAchievement';

export type GuildWarsAchievementProgress = {
  achievementStatus?: GuildWarsAchievementStatus,
  achievement?: GuildWarsAchievement
};
