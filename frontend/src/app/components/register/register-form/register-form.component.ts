import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {IUser} from '../../../interfaces/User';
import {ApiService} from '../../../services/api.service';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  registerForm: FormGroup;

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      email: new FormControl(),
      password: new FormControl(),
      repeatPassword: new FormControl(),
      apiKey: new FormControl()
    });
  }

  onRegister() {
      const user: IUser = {
        email: this.registerForm.get('email').value,
        password: this.registerForm.get('password').value,
        apiKey: this.registerForm.get('apiKey').value,
      };
      this.api.registerUser(user);
  }

  getErrorMessage() {

  }

  passwordsMatch() {
   return this.registerForm.get('password').value == this.registerForm.get('repeatPassword').value;
  }

  usernameValid() {
    return false;
  }
}
