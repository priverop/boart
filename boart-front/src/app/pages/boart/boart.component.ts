import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-boart',
  templateUrl: './boart.component.html',
  styleUrls: ['boart.component.scss']
})
export class BoartComponent implements OnInit {

  private publicationsMock;

  constructor() {
    this.publicationsMock = [
      {
        img: "http://cssdeck.com/uploads/media/items/6/6f3nXse.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/1/1swi3Qy.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/2/2v3VhAp.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/6/6f3nXse.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/1/1swi3Qy.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/2/2v3VhAp.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },      {
        img: "http://cssdeck.com/uploads/media/items/6/6f3nXse.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/1/1swi3Qy.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://cssdeck.com/uploads/media/items/2/2v3VhAp.png",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      }
    ]
  }

  ngOnInit() {
  }

}
