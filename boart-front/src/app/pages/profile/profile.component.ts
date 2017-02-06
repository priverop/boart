import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  private userInfoMocks;
  private userPublicationMocks;
  private userGalleryMocks;
  private userRRSSMocks;
	
  constructor() {

  	this.userInfoMocks = [
  		{
  			avatar: "http://www.dagmedya.net/wp-content/uploads/2013/07/Mariano-Rajoy.jpg",
  			nickname: "@perrorojo",
  			name: "Alfonso",
  			surname: "Felipe Muñoz",
  			aboutme: "Aficionado a la fotografía, me gusta fotografiar naturaleza, en especial aves."
  		}
  	],

  	this.userPublicationMocks = [
  		{
  			name: "Anochecer con V",
  			description: "Fotografía de un anochecer en Vallekas City.",
  			url: "#",
  			redes : [
  						{
							  url: "https://image.flaticon.com/icons/png/128/59/59439.png"
							},
							{
								url: "https://image.flaticon.com/icons/png/128/33/33671.png"
							},
							{
								url: "https://image.flaticon.com/icons/png/128/34/34227.png"
							}
				]
			}
		],
  			
		this.userGalleryMocks = [
			{
			  url: "http://cssdeck.com/uploads/media/items/6/6f3nXse.png"
			},
			{
			  url: "http://cssdeck.com/uploads/media/items/1/1swi3Qy.png"
			},
			{
			  url: "http://cssdeck.com/uploads/media/items/2/2v3VhAp.png"
			},
			{
			  url: "http://cssdeck.com/uploads/media/items/6/6f3nXse.png"
			},
			{
			  url: "http://cssdeck.com/uploads/media/items/1/1swi3Qy.png"
			}
		]

	}

  ngOnInit() {
  }

}
