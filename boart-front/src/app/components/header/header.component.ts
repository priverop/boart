import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  login(){
    let loginComponent = <HTMLElement>document.querySelector('.box_login');
    loginComponent.style.display = "block";
    let overlay = <HTMLElement>document.querySelector('.overlay');
    overlay.style.display = "flex";
  }

  singUp(){
    let singUpComponent = <HTMLElement>document.querySelector('.box_singup');
    singUpComponent.style.display = "block";
    let overlay = <HTMLElement>document.querySelector('.overlay');
    overlay.style.display = "flex";
  }

}
