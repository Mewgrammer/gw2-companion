export type GuildWarsAccountInfo = {
  id?: string,
  name?: string,
  age?: number,
  world?: number,
  created?: Date,
  guilds?: string[],
  access?: string[],
  commander?: boolean,
  fractal_level?: number,
  daily_ap?: number,
  monthly_ap?: number,
  wvw_rank?: number,
};
