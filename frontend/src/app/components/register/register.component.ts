import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {RegisterDialogComponent} from './register-dialog/register-dialog.component';
import {Subscription} from 'rxjs';
import {ApiService} from '../../services/api.service';
import {DataService} from '../../services/data.service';
import {IUser} from '../../interfaces/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit, OnDestroy {

  private userChangedSubscription: Subscription;

  constructor(public dialog: MatDialog, private api: ApiService) { }

  ngOnInit() {
    this.userChangedSubscription = this.api.userChanged.subscribe( (user: IUser) => {
      console.log("[Register] userChanged",user);
      this.dialog.closeAll();
    });
  }

  ngOnDestroy(){
    this.userChangedSubscription.unsubscribe();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(RegisterDialogComponent, {
      width: '50%',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log("Dialog Result:", result);
    });
  }

}
