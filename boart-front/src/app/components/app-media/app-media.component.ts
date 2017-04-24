import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-media',
  templateUrl: './app-media.component.html',
  styleUrls: ['./app-media.component.scss']
})
export class AppMediaComponent implements OnInit {
     @Input() url:string;
     @Input() media_type:string;
  constructor() { }

  ngOnInit() {
  }

}
