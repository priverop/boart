import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';

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
