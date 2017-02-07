import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-self-profile',
  templateUrl: './self-profile.component.html',
  styleUrls: ['./self-profile.component.scss']
})
export class SelfProfileComponent implements OnInit {

	private userInfoMock;
	private userGalleryMock;
    private userGroupsMock;


  constructor() { 

  	this.userInfoMock = [
  		{
  			avatar: "http://www.dagmedya.net/wp-content/uploads/2013/07/Mariano-Rajoy.jpg",
  			nickname: "@perrorojo",
  			name: "Alfonso",
  			surname: "Felipe Muñoz",
  			aboutme: "Aficionado a la fotografía, me gusta fotografiar naturaleza, en especial aves."
  		}
  	],

  	this.userGalleryMock = [
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
		],
        
        this.userGroupsMock = [
			{
              name: "Fotógrafos en Vallekas",
			  url: "/group"
			}
		]
        
		
  }

  ngOnInit() {
  }

}
