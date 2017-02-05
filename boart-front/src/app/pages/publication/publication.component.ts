import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.scss']
})
export class PublicationComponent implements OnInit {

  private publicationInfo;

  constructor() { 

  	this.publicationInfo =
  		{
  			title: "Anocheciendo en V",
  			description: "Un anochecer en Las Tetas de Vallecas (de ahí la V).",
  			user: "NicoMisery",
  			url: "https://farm1.staticflickr.com/527/18050905254_bd5018dbe4_z_d.jpg"
  		}

  }

  ngOnInit() {
  }

}
