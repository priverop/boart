import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';



@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

      imageFile;
       mediaType = "img";

      

  constructor(private ajaxService: AjaxService, private router: Router) {
  }

  ngOnInit() {
  }

addPublication(event: any, title:string, description: string, tags:string, audio, video){
    event.preventDefault();

console.log(title);
console.log(description);
console.log(tags);

    const endpoint = 'upload/';
    console.log(tags.split('\n').join(','));
    var formData:FormData = new FormData();
    formData.append('title', title);
    formData.append('description', description);
    formData.append('tags', tags.split('\n').join(','));
    formData.append('type', this.mediaType);
    switch (this.mediaType){
        case 'img':{
            formData.append('media', this.imageFile);
            break;
        } 
        case 'audio':{
            formData.append('media', audio);
            break;
        }
        case 'video':{
            formData.append('media', video);
            break;
        }
    }
    
    console.log(formData);

    this.ajaxService.multipartRequest(endpoint, formData).subscribe(
      response => this.router.navigate(['/'])
      // Return to the new group
    );
   }
    public fileChangeEvent(fileInput: any){
      this.imageFile= fileInput.target.files[0];
    console.log(fileInput.target.files[0]);
  }
  
  showHide(type){
	var groupImagen = document.getElementById("groupImagen");
	var groupAudio = document.getElementById("groupAudio");
	var groupVideo = document.getElementById("groupVideo");
	var optionsRadios1 = <HTMLInputElement>document.getElementById("optionsRadios1");
	var optionsRadios2 = <HTMLInputElement>document.getElementById("optionsRadios2");
	var optionsRadios3 = <HTMLInputElement>document.getElementById("optionsRadios3");
	
	groupImagen.style.display = optionsRadios1.checked ? "block" : "none";
	groupAudio.style.display = optionsRadios2.checked ? "block" : "none";
	groupVideo.style.display = optionsRadios3.checked ? "block" : "none";
	
	(<HTMLInputElement>document.getElementById("inputFile")).value="";
	(<HTMLInputElement>document.getElementById("txtAudio")).value="";
	(<HTMLInputElement>document.getElementById("txtVideo")).value="";
	document.getElementById("divRetoques").style.display = "none";
    this.mediaType= type;
};
}
