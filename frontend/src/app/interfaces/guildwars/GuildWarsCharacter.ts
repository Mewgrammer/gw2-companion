import {GuildWarsCharacterCraftingInfo} from './GuildWarsCharacterCraftingInfo';

export type GuildWarsCharacter = {
  name?: string,
  race?: string,
  gender?: string,
  profession?: string,
  level?: number,
  guild?: string,
  age?: number,
  created?: Date,
  deaths?: number,
  crafting?: GuildWarsCharacterCraftingInfo[],
};
