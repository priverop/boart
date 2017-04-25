import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.scss']
})
export class GroupComponent implements OnInit {

  group = [];
  groupID: number;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.groupID = +params['id'];
    });
    this.getGroup();
  }

  private getGroup(){
    const endpoint = 'group/'+this.groupID;
    this.ajaxService.getRequest(endpoint).subscribe(result => this.group = result.json());
  }

}
