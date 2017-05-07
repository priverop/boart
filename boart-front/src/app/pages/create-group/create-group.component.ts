import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { CoverComponent } from '../../pages/cover/cover.component';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.scss']
})
export class CreateGroupComponent implements OnInit {

  imageFile;

  constructor(private ajaxService: AjaxService, private router: Router) { }

  ngOnInit() {
  }

  createGroup(event: any, title: string, description: string, image: File){
    event.preventDefault();

    const endpoint = 'group/create';
    
    var formData:FormData = new FormData();
    formData.append('title', title);
    formData.append('description', description);
    formData.append('inputImage', this.imageFile);

    this.ajaxService.multipartRequest(endpoint, formData).subscribe(
      response => this.router.navigate(['/'])
      // Return to the new group
    );
  }
  
  public fileChangeEvent(fileInput: any){
    this.imageFile= fileInput.target.files[0];
    console.log(fileInput.target.files[0]);
  }

}
