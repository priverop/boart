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
  emptyPublications: boolean;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.username = params['username'];
      this.getUser();
    });
    this.loginService.userUpdated.subscribe(
      (userLogged) => {
      this.userLogged = userLogged;
      }
    )
  }

  private getUser(){
    const endpoint = 'user/'+this.username;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.user = result.json();
      if(this.userLogged) {
        this.checkOwnProfile();
        this.checkFollowing();
        this.checkEmptyPublications();
      }
    });
  }

  private checkEmptyPublications(){
    this.emptyPublications = this.user['publications'] == 0;
  }

  private checkOwnProfile() {
      this.isOwnProfile = this.loginService.user['username'] == this.user['username'] ? true : false;
  }

  private checkFollowing(){
    let following = this.loginService.user['following'].filter(following => {
      return following.username == this.user['username'];
    });
    this.isFollowing = following.length ? true : false;
  }

  followUser(){
    const endpoint = 'user/following';
    this.ajaxService.postRequest(endpoint, "id=" + this.user['id']).subscribe(
      response => {
        this.user = response.json();
        this.isFollowing = true;
      },
      error => console.error(error)
    );
  }

  unfollowUser(){
    const endpoint = 'user/following/'+this.user['id'];
    this.ajaxService.deleteRequest(endpoint).subscribe(
      response => {
        this.user = response.json();
        this.isFollowing = false;
      },
      error => console.error(error)
    );
  }

  public writtenComment(event) {
    this.user = event;
  }

}
