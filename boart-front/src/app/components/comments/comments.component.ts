import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
    @Input() comments;
    @Input() location_type;
    @Input() location;

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
    const endpoint = 'publication/' + this.location;
    this.ajaxService.postRequest(endpoint, "comment="+text).subscribe(
      response => this.router.navigate([endpoint]),
      error => console.log(error)
    );
  }

  private sendProfileComment(text: any){
    const endpoint = 'user/' + this.location;
    this.ajaxService.postRequest(endpoint, "comment="+text).subscribe(
      response => this.router.navigate([endpoint]),
      error => console.log(error)
    );
  }

}
