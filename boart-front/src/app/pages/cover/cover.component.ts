import { Component, OnInit} from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer} from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
@Pipe({ name: 'safe' })
export class SafePipe implements PipeTransform {
  constructor(private sanitizer: DomSanitizer) {}
  transform(url) {
    return this.sanitizer.bypassSecurityTrustResourceUrl(url);
  }
}

@Component({
  selector: 'app-cover',
  templateUrl: './cover.component.html',
  styleUrls: ['./cover.component.scss']
})
export class CoverComponent implements OnInit {

  private publications = [];
	filter;
	tags = [];
private page;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute) { }

  ngOnInit() {
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
  }

  private getPublications() {
    const endpoint = 'publications?filter=' + this.filter + '&tags=' + this.tags.join(",");
    if (this.tags.length > 1)
        this.ajaxService.getRequest(endpoint).subscribe(result => this.publications = result.json());
    else
        this.ajaxService.getRequest(endpoint).subscribe(result => this.publications = result.json().content);
  }
  
  public getMorePublications(){
  const endpoint = 'publications?filter=' + this.filter + '&tags=' + this.tags.join(",") + '&page=' + this.page;
    this.ajaxService.getRequest(endpoint).subscribe(result => Array.prototype.push.apply(this.publications,result.json().content));
    this.page +=1;
  }
  
  public changeFilter(filter){
    this.filter = filter;
    this.page = 1;
    this.getPublications();
    
    document.getElementById('aLikes').className ='';
	document.getElementById('aComments').className ='';
	document.getElementById('aLatest').className ='';
    
    switch(filter){
        case 'latest': {
                document.getElementById('aLikes').className ='active';
                break;
        }
        case 'comments': {
                document.getElementById('aComments').className ='active';
                break;
        }
        case 'likes': {
                document.getElementById('aLatest').className ='active';
                break;
        }
    }
  }
  
  public addTag(tag){
    this.tags.push(tag);
        this.page = 1;
    this.getPublications();
  }
  
public removeTag(tag){
    this.tags.splice(this.tags.indexOf(tag), 1);
        this.page = 1;
    this.getPublications();
  }

}
