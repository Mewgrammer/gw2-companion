import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {

  registerForm: FormGroup;

  constructor() { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      username: new FormControl(),
      password: new FormControl(),
      repeatPassword: new FormControl(),
    });
  }

  onRegister() {

  }

  getErrorMessage() {

  }

  passwordsMatch() {
    return false;
  }

  usernameValid() {
    return false;
  }
}
