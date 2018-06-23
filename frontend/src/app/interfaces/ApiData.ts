import {GuildWarsCurrency} from './guildwars/GuildWarsCurrency';
import {GuildWarsAccountInfo} from './guildwars/GuildWarsAccountInfo';
import {GuildWarsAchievementProgress} from './guildwars/GuildWarsAchievementProgress';
import {GuildWarsCharacter} from './guildwars/GuildWarsCharacter';
import {GuildWarsItem} from './guildwars/GuildWarsItem';

export interface IUserData {
  wallet: GuildWarsCurrency[],
  account: GuildWarsAccountInfo,
  achievements: GuildWarsAchievementProgress[],
  characters: GuildWarsCharacter[],
  bank: GuildWarsItem[]
}
