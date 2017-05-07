import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.scss']
})
export class CommentsComponent implements OnInit {
    @Input() comments;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

}
