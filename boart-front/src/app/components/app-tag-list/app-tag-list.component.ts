import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tag-list',
  templateUrl: './app-tag-list.component.html',
  styleUrls: ['./app-tag-list.component.scss']
})
export class AppTagListComponent implements OnInit {
  @Input() tags;
  constructor() { }
  ngOnInit() {
  }

}
