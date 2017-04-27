import { Component, OnInit } from '@angular/core';
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

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute) { }

  ngOnInit() {

    this.route.queryParams.subscribe(params => {
      this.filter = params['filter'] || "latest";
    });
    this.getPublications();
  }

  private getPublications() {
    const endpoint = 'publications?filter=' + this.filter;
    this.ajaxService.getRequest(endpoint).subscribe(result => this.publications = result.json().content);
  }

}
