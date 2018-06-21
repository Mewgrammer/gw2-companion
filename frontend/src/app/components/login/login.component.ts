import {Component, OnDestroy, OnInit} from '@angular/core';
import {RegisterDialogComponent} from '../register/register-dialog/register-dialog.component';
import {MatDialog} from '@angular/material';
import {LoginDialogComponent} from './login-dialog/login-dialog.component';
import {ApiService} from '../../services/api.service';
import {Subscription} from 'rxjs';
import {DataService} from '../../services/data.service';
import {IUser} from '../../interfaces/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  private userChangedSubscription: Subscription;

  constructor(public dialog: MatDialog, private api: ApiService) { }

  ngOnInit() {
    this.userChangedSubscription = this.api.userChanged.subscribe( (user: IUser) => {
      console.log("[Login] userChanged",user);
      this.dialog.closeAll();
    });
  }

  ngOnDestroy(){
    this.userChangedSubscription.unsubscribe();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(LoginDialogComponent, {
      width: '50%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log("Dialog Result:", result);
    });
  }

}
