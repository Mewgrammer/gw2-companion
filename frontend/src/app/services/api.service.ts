import { Injectable } from '@angular/core';
import {Observable, Subject} from 'rxjs';
import {HttpClient, HttpParams, HttpResponse} from '@angular/common/http';
import {IUser} from '../interfaces/User';
import {IUserData} from '../interfaces/ApiData';

export const ApiUrl = "http://localhost:8080/api/";

export const Urls = {
  login: ApiUrl + "users",
  register: ApiUrl + "users",
  data: ApiUrl + "guildwars/all"
};

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  public userChanged: Subject<IUser>;

  constructor(private http: HttpClient) {
    this.userChanged = new Subject<IUser>();
  }

  public loginUser(user: IUser) {
    let loginParams = new HttpParams().set("email", user.email).set("password", user.password);
    this.http.get(Urls.login, {params: loginParams} ).subscribe((response: any) => {
      console.log("LoginResponse:", response);
      this.userChanged.next({
        email: response.email,
        password: response.password,
        apiKey: response.apiKey,
        loggedIn: true,
        data: response.data
      } as IUser);
    },
    (error) => {
      console.log("LoginError:", error);
    });
  }

  public requestUserData(user: IUser): Observable<IUserData> {
    if(user != null) {
      let requestParams = new HttpParams().set("apiKey", user.apiKey);
      return this.http.get(Urls.data, {params: requestParams}) as Observable<IUserData>;
    }
  }

  public registerUser(user: IUser) {
    this.http.post(Urls.register, {
      email: user.email,
      password: user.password,
      apiKey: user.apiKey
    }).subscribe( (response: any) => {
        console.log("RegisterResponse:", response);
        this.userChanged.next({
          email: response.email,
          password: response.password,
          apiKey: response.apiKey,
          loggedIn: true,
          data: user.data
        } as IUser);
      },
      (error) => {
        console.log("RegisterError:", error);
      });
  }
}
