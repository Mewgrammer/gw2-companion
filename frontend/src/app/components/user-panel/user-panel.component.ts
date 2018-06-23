import {Component, OnDestroy, OnInit} from '@angular/core';
import {DataService} from '../../services/data.service';
import {IUser} from '../../interfaces/User';
import {Subscription} from 'rxjs';
import {IUserData} from '../../interfaces/ApiData';

@Component({
  selector: 'app-user-panel',
  templateUrl: './user-panel.component.html',
  styleUrls: ['./user-panel.component.css']
})
export class UserPanelComponent implements OnInit, OnDestroy {

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

  reloadData() {
    this.user.data = null;
    this.data.requestData();
  }
}
