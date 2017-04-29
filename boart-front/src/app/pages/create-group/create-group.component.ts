import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { CoverComponent } from '../../pages/cover/cover.component';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {

  constructor(private ajaxService: AjaxService, private router: Router) { }

  ngOnInit() {
  }

  createGroup(event: any, title: string, description: string, image: File){
    event.preventDefault();

    const endpoint = 'group/create';
    const options = {
      title: title,
      description: description,
      file: image
    };

    this.ajaxService.postRequest(endpoint, options).subscribe(
      response => this.router.navigate(['/'])
      // Return to the new group
    );
  }

}
