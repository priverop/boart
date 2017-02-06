import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.scss']
})
export class GroupComponent implements OnInit {

  private publicationsMock;

  constructor() {
    this.publicationsMock = [
      {
        img: "http://i797.photobucket.com/albums/yy260/soyhanechan/01.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://mamiverse.com/es/wp-content/uploads/2016/01/T%C3%A9cnicas-fotogr%C3%A1ficas-El-arte-de-las-fotos-art%C3%ADsticas-Photo3.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "https://fografiasartisticas.files.wordpress.com/2013/04/fotografias-artisticas-2.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://i797.photobucket.com/albums/yy260/soyhanechan/01.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "http://mamiverse.com/es/wp-content/uploads/2016/01/T%C3%A9cnicas-fotogr%C3%A1ficas-El-arte-de-las-fotos-art%C3%ADsticas-Photo3.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },
      {
        img: "https://fografiasartisticas.files.wordpress.com/2013/04/fotografias-artisticas-2.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      },      {
        img: "http://i797.photobucket.com/albums/yy260/soyhanechan/01.jpg",
        text: "Donec a fermentum nisi. Integer dolor est, commodo ut sagittis vitae, egestas at augue. Suspendisse id nulla ac urna vestibulum mattis."
      }
    ]
  }

  ngOnInit() {
  }

}
