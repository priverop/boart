import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { LoginService } from '../../services/login.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-public-profile',
  templateUrl: './public-profile.component.html',
  styleUrls: ['./public-profile.component.scss']
})
export class PublicProfileComponent implements OnInit {

  user = [];
  username: string;
  isFollowing = false;
  userLogged: boolean;
  isOwnProfile: boolean = true;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.username = params['username'];
    });
    this.loginService.userUpdated.subscribe(
      (userLogged) => {
      this.userLogged = userLogged;
        this.getUser();
      }
    )
  }

  private getUser(){
    const endpoint = 'user/'+this.username;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.user = result.json();
      if(this.userLogged) {
        this.checkOwnProfile();
      }
    });
  }

  private checkOwnProfile() {
    if(this.loginService.isLogged) {
      this.isOwnProfile = this.loginService.user['username'] == this.user['username'] ? true : false;
      this.checkFollowing();
    }
  }

  private checkFollowing(){
    let followers = this.loginService.user['followers'].filter(follower => {
      return follower == '@' + this.user['username'];
    });
    this.isFollowing = followers.length ? true : false;
  }

  followUser(){
    const endpoint = 'user/following';
    this.ajaxService.postRequest(endpoint, "id=" + this.user['id']).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

  unfollowUser(){
    const endpoint = 'user/following/'+this.user['id'];
    this.ajaxService.deleteRequest(endpoint).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

}
