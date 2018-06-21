import { Component, OnInit } from '@angular/core';
import {DataService} from '../../services/data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private data: DataService) { }

  ngOnInit() {

  }

  userLoggedIn() {
    return this.data.User != null;
  }

  logout() {
    this.data.User = null;
  }
}
