import { Component, OnInit , Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './app-search.component.html',
  styleUrls: ['./app-search.component.scss']
})
export class AppSearchComponent implements OnInit {
 @Input() tags;
  @Input() filter;
  @Output() addTagEvent = new EventEmitter<any>();
  @Output() remTagEvent = new EventEmitter<any>();

  constructor() { }

  ngOnInit() {
  }
  
  public addTag(tag){
    this.addTagEvent.emit(tag);
      (<HTMLInputElement>document.getElementById('txtTag')).value= "";
  }
  
  public remTag(tag){
    this.remTagEvent.emit(tag);
  }


}
