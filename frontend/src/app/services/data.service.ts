import {Injectable, OnDestroy, OnInit} from '@angular/core';
import {Subject} from 'rxjs';
import {IUser} from '../interfaces/User';
import {ApiService} from './api.service';

@Injectable({
  providedIn: 'root'
})
export class DataService implements OnInit, OnDestroy{

  private currentUser: IUser;

  get User() {
    return this.currentUser;
  }

  set User(user: IUser) {
    console.log("[Data] UserChanged", user);
    this.currentUser = user;
    this.userChanged.next(user);
  }

  public userChanged: Subject<IUser>;

  constructor(private api: ApiService) {
    this.userChanged = new Subject<IUser>();
    this.api.userChanged.subscribe((user: IUser) => {
      this.currentUser = user;
      this.userChanged.next(user);
    });
  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
    this.userChanged.unsubscribe();
  }




}
