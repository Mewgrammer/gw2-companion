import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {GuildWarsAccountInfo} from '../../../interfaces/guildwars/GuildWarsAccountInfo';
import {DataService} from '../../../services/data.service';
import {Subscription} from 'rxjs';
import {IUser} from '../../../interfaces/User';

@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  styleUrls: ['./account-info.component.css']
})
export class AccountInfoComponent implements OnInit, OnDestroy {

  private user: IUser;
  private userChangedSubscription: Subscription;
  private userDataChangedSubscription: Subscription;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.user = this.data.User;
    this.userChangedSubscription = this.data.userChanged.subscribe( (user: IUser) => {
      this.user = user;
    });
    this.userDataChangedSubscription = this.data.userDataChanged.subscribe( (user: IUser) => {
      this.user = user;
    });
  }

  userDataPresent() {
    return this.user != null && this.user.data != null;
  }

  ngOnDestroy(): void {
    this.userDataChangedSubscription.unsubscribe();
    this.userChangedSubscription.unsubscribe();
  }

}
