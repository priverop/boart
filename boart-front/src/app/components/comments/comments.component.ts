import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';
import {URLSearchParams} from "@angular/http";

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
    @Input() comments;
    @Input() location_type;
    @Input() location;
    @Output() writtenComment = new EventEmitter();

  constructor(private loginService: LoginService, private ajaxService: AjaxService, private router: Router) { }

  ngOnInit() {
  }

  private sendComment(event:any, text: any){

    event.preventDefault();

    if(this.location_type == "publication"){
      this.sendPublicationComment(text);
    }
    else if(this.location_type == "profile"){
      this.sendProfileComment(text);
    }

  }

  private sendPublicationComment(text: any){

    let formData = new URLSearchParams();

    formData.set('id', this.location);
    formData.set('comment', text);

    const endpoint = 'publication/comment';

    this.ajaxService.postRequest(endpoint, formData).subscribe(
      response => this.writtenComment.emit(response.json()),
      error => console.log(error)
    );

  }

  private sendProfileComment(text: any){

    let formData = new URLSearchParams();

    formData.set('username', this.location);
    formData.set('comment', text);

    const endpoint = 'user/comment';

    this.ajaxService.postRequest(endpoint, formData).subscribe(
        response => this.writtenComment.emit(response.json()),
        error => console.log(error)
    );

  }

}
