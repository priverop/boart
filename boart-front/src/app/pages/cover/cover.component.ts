import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { Pipe, PipeTransform } from '@angular/core';
import { DomSanitizer} from '@angular/platform-browser';

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

  constructor(private ajaxService: AjaxService) { }

  ngOnInit() {
    this.getPublications();
  }

  private getPublications() {
    const endpoint = 'publications';
    this.ajaxService.getRequest(endpoint).subscribe(result => this.publications = result.json().content);
  }

}
