import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {

  private commentsMocks;

  constructor() { 
	  this.commentsMocks = [
			{
	  			user: "LocoRoco",
	  			text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
	  		},
	  		{
	  			user: "Marico34",
	  			text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
	  		},
	  		{
	  			user: "EstupendoWatson99",
	  			text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
	  		}
	  	]

  }

  ngOnInit() {
  }

}
