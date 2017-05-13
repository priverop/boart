import {Component, OnInit} from '@angular/core';
import {AjaxService} from '../../services/ajax.service';
import {Pipe, PipeTransform} from '@angular/core';
import {DomSanitizer, Title} from '@angular/platform-browser';
import {ActivatedRoute} from '@angular/router';
import {LoginService} from '../../services/login.service';
import {style, animate, keyframes, transition, trigger} from "@angular/animations";
import {URLSearchParams} from "@angular/http";

@Pipe({name: 'safe'})
export class SafePipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) {
  }

  transform(url) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}

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
  selector: 'app-cover',
  templateUrl: './cover.component.html',
  styleUrls: ['./cover.component.scss'],
  animations: [moveDown]
})
export class CoverComponent implements OnInit {

  private publications = [];
  filter;
  tags = [];
  private page;
  private userID: number;
  private groups = [];


  constructor(private ajaxService: AjaxService, private route: ActivatedRoute, private loginService: LoginService, private titleService: Title) {
  }

  ngOnInit() {
    this.titleService.setTitle("Boart - Cover");

    this.route.queryParams.subscribe(params => {
      this.filter = params['filter'] || "latest";
      this.tags = params['tags'] || [];
      if (params['nTag'] !== undefined) this.tags.push(params['nTag']);
      if (params['rTag'] !== undefined){
        this.tags.splice(this.tags.indexOf(params['rTag']), 1);
      }
      this.page = 1;
      this.getPublications();
    });

    this.route.data.subscribe(data => {
      this.getUserGroups();
    });
    }

    private getUserGroups(){
      if(this.loginService.isLogged){
        this.groups = this.loginService.user["groups"];
      }
    }

    private getPublications() {
      const endpoint = 'publications?filter=' + this.filter + '&tags=' + this.tags.join(",");
      if (this.tags.length > 1)
      this.ajaxService.getRequest(endpoint).subscribe(result => {
        this.publications = result.json();
        console.log(this.publications);
        this.checkLikes();
      });
      else
      this.ajaxService.getRequest(endpoint).subscribe(result => {
        this.publications = result.json().content;
        this.checkLikes();
      });
    }

    public getMorePublications() {
      const endpoint = 'publications?filter=' + this.filter + '&tags=' + this.tags.join(",") + '&page=' + this.page;
      this.ajaxService.getRequest(endpoint).subscribe(result => Array.prototype.push.apply(this.publications, result.json().content));
      this.page += 1;
    }

    public changeFilter(filter) {
      this.filter = filter;
      this.page = 1;
      this.getPublications();

      document.getElementById('aLikes').className = '';
      document.getElementById('aComments').className = '';
      document.getElementById('aLatest').className = '';

      switch (filter) {
        case 'latest': {
          document.getElementById('aLikes').className = 'active';
          break;
        }
        case 'comments': {
          document.getElementById('aComments').className = 'active';
          break;
        }
        case 'likes': {
          document.getElementById('aLatest').className = 'active';
          break;
        }
      }
    }

    public addTag(tag) {
      this.tags.push(tag);
      this.page = 1;
      this.getPublications();
    }

    public removeTag(tag) {
      this.tags.splice(this.tags.indexOf(tag), 1);
      this.page = 1;
      this.getPublications();
    }

    public checkLikes() {
      for (let i in this.publications) {
        this.checkLike(this.publications[i].id, this.publications[i])
      }
      console.log(this.publications)
    }

    public checkLike(publicationId, publication) {
      const endpoint = "like/check/" + publicationId;
      this.ajaxService.getRequestCredentials(endpoint).subscribe(response => {
        publication['ownLike'] = response.json();
      });
    }

    public likeHandler(publication) {
      console.log(publication)
      if (this.loginService.isLogged) {
        return publication['ownLike'] ? this.removeLike(publication) : this.addLike(publication) ;
      }
    }

    public addLike(publication) {

      let formData = new URLSearchParams();

      formData.set('publicationId', publication.id);

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

      let endpoint = 'like/' + publication.id;

      this.ajaxService.deleteRequest(endpoint).subscribe(
        response => {
          publication['ownLike'] = false;
          publication['numberOfLikes']--;
        },
        error => console.log(error)
      );
    }

  }
