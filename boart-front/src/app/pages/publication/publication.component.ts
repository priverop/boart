import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.scss']
})
export class PublicationComponent implements OnInit {

  private publication = [];
  publicationID: number;

  constructor(private ajaxService: AjaxService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.publicationID = +params['id'];
    });
    this.getPublication();
  }

  private getPublication(){
    const endpoint = 'publication/'+this.publicationID;
    this.ajaxService.getRequest(endpoint).subscribe(result => this.publication = result.json());
  }
}
