import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-public-profile',
  templateUrl: './public-profile.component.html',
  styleUrls: ['./public-profile.component.scss']
})
export class PublicProfileComponent implements OnInit {

  user = [];
  username: string;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute) { }

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

}
