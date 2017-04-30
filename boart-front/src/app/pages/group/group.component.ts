import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { ActivatedRoute } from '@angular/router';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.scss']
})
export class GroupComponent implements OnInit {

  group = [];
  groupID: number;
  userBelongs = false;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.groupID = +params['id'];
    });
    this.getGroup();
    this.checkUserBelongs();
  }

  private getGroup(){
    const endpoint = 'group/'+this.groupID;
    this.ajaxService.getRequest(endpoint).subscribe(result => this.group = result.json());
  }

  private checkUserBelongs(){
    // var number = this.loginService.user['groups'].find(x => x === this.group['title']);

  }

  joinGroup(){
    const endpoint = 'group/join';
    let data = { id: this.groupID }; // NOT WORKING
    this.ajaxService.postRequest(endpoint, data).subscribe(
      response => console.log(response),
      error => console.error(error)
    );
  }

  leaveGroup(){
    const endpoint = 'group/leave/'+this.groupID;
    this.ajaxService.deleteRequest(endpoint).subscribe();
  }

}
