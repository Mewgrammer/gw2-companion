import {Injectable, OnDestroy, OnInit} from '@angular/core';
import {Subject} from 'rxjs';
import {IUser} from '../interfaces/User';
import {ApiService} from './api.service';
import {IUserData} from '../interfaces/ApiData';

@Injectable({
  providedIn: 'root'
})
export class DataService implements OnInit, OnDestroy{

  private currentUser: IUser;

  public userChanged: Subject<IUser>;
  public userDataChanged: Subject<IUser>;

  get User() {
    return this.currentUser || null;
  }

  set User(user: IUser) {
    localStorage.setItem("user", user == null ? "" : JSON.stringify(user));
    console.log("[Data] UserChanged", user);
    this.currentUser = user;
    this.userChanged.next(user);
  }


  constructor(private api: ApiService) {
    this.userChanged = new Subject<IUser>();
    this.userDataChanged = new Subject<IUser>();
    try {
      let userCache = JSON.parse(localStorage.getItem("user"));
      if(userCache.hasOwnProperty("email")) {
        this.currentUser = userCache;
      }
    }
    catch{}
    this.api.userChanged.subscribe((user: IUser) => {
      localStorage.setItem("user", JSON.stringify(user));
      this.currentUser = user;
      this.userChanged.next(this.currentUser);
      this.requestData();
    });
    if(this.currentUser != null && this.currentUser.data == null) this.requestData();
  }

  public requestData() {
    console.log("[Data] Requesting Data...");
    try{
      this.api.requestUserData(this.currentUser).subscribe((userdata: IUserData) => {
        this.currentUser.data = userdata;
        console.log("[Data] UserDataChanged", userdata);
        this.userDataChanged.next(this.currentUser);
        localStorage.setItem("user", JSON.stringify(this.currentUser));
      });
    }
    catch (e) {

    }

  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
    this.userChanged.unsubscribe();
  }




}
