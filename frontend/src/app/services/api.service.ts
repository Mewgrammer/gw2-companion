import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {IUser} from '../interfaces/User';

export const ApiUrl = "http://localhost:8080/api/";

export const Urls = {
  login: (email: string, password: string) => {
    return ApiUrl + 'users/?&email=' + email + '&password=' + password;
  },
  register: ApiUrl + "users",
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
    this.http.get(Urls.login(user.email, user.password)).subscribe((response: any) => {
      console.log("LoginResponse:", response);
      this.userChanged.next({
        email: response.email,
        password: response.password,
        apiKey: response.apiKey,
        loggedIn: true,
        data: user.data
      } as IUser);
    },
    (error) => {
      console.log("LoginError:", error);
    });
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
