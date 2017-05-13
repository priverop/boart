import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { LoginService } from '../../services/login.service';
import { ActivatedRoute, Router } from '@angular/router';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.scss']
})
export class PublicationComponent implements OnInit {

  publication = [];
  userPublication = [];
  publicationID: number;
  isMine = false;
  hasComments: boolean = false;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService, private router: Router, private titleService: Title) { }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.publicationID = +params['id'];
    });

    this.route.data.subscribe(data => {
      this.getPublication();
    });

  }

  private getPublication(){
    const endpoint = 'publication/'+this.publicationID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.publication = result.json();
      this.titleService.setTitle("Boart - "+this.publication['title']);
      if(this.publication['comments'].length > 0){
        this.hasComments = true;
      }
      this.getUserFromPublication();
    });
  }

  private getUserFromPublication(){
    const endpoint = 'user/' + this.publication['user'];
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.userPublication = result.json();
      if(this.loginService.isLogged) {
        this.checkMyPublication();
      }
    });
  }

  private checkMyPublication(){
    if(this.publication['user'] === this.loginService.user['username'])
      this.isMine = true;
  }

  private deletePublication(event: any){
    event.preventDefault();
    const endpoint = 'publication/' + this.publicationID;
    this.ajaxService.deleteRequest(endpoint).subscribe(
      response => this.router.navigate(['/']),
      error => console.error(error)
    );
  }

  public writtenComment(event) {
    this.publication = event;
  }

}
