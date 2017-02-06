import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login-overlay',
  templateUrl: './login-overlay.component.html',
  styleUrls: ['./login-overlay.component.scss']
})
export class LoginOverlayComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  submit(){
    let loginComponent = <HTMLElement>document.querySelector('.box_login');
    loginComponent.style.display = "none";
    let singUpComponent = <HTMLElement>document.querySelector('.box_singup');
    singUpComponent.style.display = "none";
    let overlay = <HTMLElement>document.querySelector('.overlay');
    overlay.style.display = "none";
  }

}
