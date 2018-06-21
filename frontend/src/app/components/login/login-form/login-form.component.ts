import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ApiService} from '../../../services/api.service';
import {IUser} from '../../../interfaces/User';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl()
    });
  }

  onLogin() {
    const user: IUser = {
      email: this.loginForm.get('email').value,
      password: this.loginForm.get('password').value,
      loggedIn: false
    };
    this.api.loginUser(user);
  }

  getErrorMessage() {

  }

  usernameValid() {
    return false;
  }
}
