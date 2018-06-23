import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {GuildWarsCurrency} from '../../../interfaces/guildwars/GuildWarsCurrency';
import {DataService} from '../../../services/data.service';
import {Subscription} from 'rxjs';
import {IUser} from '../../../interfaces/User';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit, OnDestroy {

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
