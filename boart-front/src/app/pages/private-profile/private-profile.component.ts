import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AjaxService } from '../../services/ajax.service';

@Component({
  selector: 'app-private-profile',
  templateUrl: './private-profile.component.html',
  styleUrls: ['./private-profile.component.scss']
})
export class PrivateProfileComponent implements OnInit {

  user = [];
  private userID: number;

  constructor(private loginService: LoginService, private ajaxService: AjaxService) { }

  ngOnInit() {
    this.userID = this.loginService.user.id;
    this.getUser();
  }

  private getUser(){
    const endpoint = 'user/id/'+this.userID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.user = result.json();
    });
  }

}
