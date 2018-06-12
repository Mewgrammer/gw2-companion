import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material';
import {RegisterDialogComponent} from './register-dialog/register-dialog.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
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
