import { Component, OnInit, Input, OnChanges } from '@angular/core';
import {style, animate, keyframes, transition, trigger} from "@angular/animations";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AjaxService} from '../../services/ajax.service';
import {LoginService} from '../../services/login.service';
import {URLSearchParams} from "@angular/http";

const moveDown = trigger('moveDown', [
  transition('void => *', [
    animate(600, keyframes([
      style({opacity: 0, transform: 'translateY(-400px)', offset: 0}),
      style({opacity: 0.8, transform: 'translateY(50px)', offset: .75}),
      style({opacity: 1, transform: 'translateY(0)', offset: 1}),
    ]))
  ])
]);

@Component({
  selector: 'app-publication-detail',
  templateUrl: './app-publication-detail.component.html',
  styleUrls: ['./app-publication-detail.component.scss'],
animations: [moveDown]

})
export class AppPublicationDetailComponent implements OnInit, OnChanges {
    @Input() publication;
  constructor(private ajaxService: AjaxService,private loginService: LoginService) { }

ngOnChanges(){
    const endpoint = "like/check/" + this.publication.id;
      this.ajaxService.getRequestCredentials(endpoint).subscribe(response => {
        this.publication['ownLike'] = response.json();
      });
  }

public likeHandler(publication) {
      if (this.loginService.isLogged) {
        return publication['ownLike'] ? this.removeLike(publication) : this.addLike(publication) ;
      }
    }

    public addLike(publication) {

      let formData = new URLSearchParams();
      formData.set('publicationId', this.publication.id);

      let endpoint = 'like';

      this.ajaxService.postRequest(endpoint, formData).subscribe(
        response => {
          publication['ownLike'] = true;
          publication['numberOfLikes']++;
        },
        error => console.log(error)
      );
    }

    public removeLike(publication) {

      let endpoint = 'like/' + this.publication.id;

      this.ajaxService.deleteRequest(endpoint).subscribe(
        response => {
          publication['ownLike'] = false;
          publication['numberOfLikes']--;
        },
        error => console.log(error)
      );
    }

  ngOnInit()  {
  
  }

}
