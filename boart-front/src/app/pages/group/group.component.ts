import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { LoginService } from '../../services/login.service';
import { ActivatedRoute } from '@angular/router';
import {Observable} from "rxjs";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.scss']
})
export class GroupComponent implements OnInit {

  group = {

  };
  groupID: number;
  userBelongs = false;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService) { }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.groupID = +params['id'];
    });

    this.route.data.subscribe(data => {
        this.getGroup();
    });

  }

  private getGroup(){
    const endpoint = 'group/'+this.groupID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
        this.group = result.json();
        if(this.loginService.isLogged) {
            this.checkUserBelongs();
        }
    });
  }

  private checkUserBelongs(){
    let userBelongs = this.loginService.user['groups'].filter(group => {
      return group.id == this.groupID;
    });
    console.log(userBelongs);
    this.userBelongs = userBelongs.length ? true : false;
  }

  joinGroup(){
    const endpoint = 'group/join';
    this.ajaxService.postRequest(endpoint, "id=" + this.groupID).subscribe(
      response => {
        this.group = response.json();
        this.userBelongs = true;
      },
      error => console.error(error)
    );
  }

  leaveGroup(){
    const endpoint = 'group/leave/'+this.groupID;
    this.ajaxService.deleteRequest(endpoint).subscribe(
        response => {
          this.group = response.json();
          this.userBelongs = false;
        },
      error => console.error(error)
    );
  }

}
