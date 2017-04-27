import { Component, OnInit , Input} from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './app-search.component.html',
  styleUrls: ['./app-search.component.scss']
})
export class AppSearchComponent implements OnInit {
 @Input() tags;
  @Input() filter;
  constructor() { }

  ngOnInit() {
  }

}
