import {IApiData} from './ApiData';

export interface IUser {
  email: string;
  password: string;
  apiKey?: string;
  loggedIn?: boolean;
  data?: IApiData;
}
