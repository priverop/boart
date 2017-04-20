import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';

@Component({
  selector: 'app-cover',
  templateUrl: './cover.component.html',
  styleUrls: ['./cover.component.scss']
})
export class CoverComponent implements OnInit {

  constructor(private ajaxService: AjaxService) { }

  ngOnInit() {
    this.getPublications();
  }

  private getPublications() {
    const endpoint = 'publications';
    this.ajaxService.getRequest(endpoint).subscribe(result => console.log(result.json()));
  }

}
