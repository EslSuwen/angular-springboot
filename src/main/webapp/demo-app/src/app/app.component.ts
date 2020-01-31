import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'demo-app';
  img;
  ngOnInit() {
    this.img = 'http://localhost:8090/login/createImageCode';
  }
  refresh() {
    this.img = 'http://localhost:8090/login/createImageCode' + '?' + Math.random();
  }
}
