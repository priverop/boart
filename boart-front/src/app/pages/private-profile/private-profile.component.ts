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
  emptyFollowers: boolean = true;
  emptyFollowings: boolean = true;
  emptyGroups: boolean = true;

  constructor(private loginService: LoginService, private ajaxService: AjaxService) { }

  ngOnInit() {
    this.userID = this.loginService.user.id;

    this.getUser();
    this.checkEmptyFollowers();
    this.checkEmptyFollowings();
    this.checkEmptyGroups();
  }

  private getUser(){
    const endpoint = 'user/id/'+this.userID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.user = result.json();
    });
  }

  private checkEmptyFollowers(){
    console.log("followers"+ (this.user['followers'] == 0));
    this.emptyFollowers = this.user['followers'] == 0;
  }
  private checkEmptyFollowings(){
    console.log("following"+ (this.user['following'] == 0));
    this.emptyFollowings = this.user['following'] == 0;
  }
  private checkEmptyGroups(){
    console.log("groups"+ (this.user['groups'] == 0));
    this.emptyGroups = this.user['groups'] == 0;
  }

}
