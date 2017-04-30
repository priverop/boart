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

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.username = params['username'];
    });
    this.getUser();
  }

  private getUser(){
    const endpoint = 'user/'+this.username;
    this.ajaxService.getRequest(endpoint).subscribe(result => this.user = result.json());
  }

  checkFollowing(){

  }

  followUser(){
    const endpoint = 'user/following';
    let data = { id: this.user['id'] }; // NOT WORKING
    this.ajaxService.postRequest(endpoint, data).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

  unfollowUser(){
    const endpoint = 'user/following/'+this.user['id'];
    this.ajaxService.deleteRequest(endpoint).subscribe();
  }

}
