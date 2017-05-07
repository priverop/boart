import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl, Validators, FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';



@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {

      imageFile;
       mediaType = "img";
  private userID: number;
      groups = [];
      selGroup = "0";

  constructor(private ajaxService: AjaxService, private router: Router,private loginService: LoginService) {
  }

  ngOnInit() {
    this.userID = this.loginService.user.id;
    this.getUserGroups();
  }
  
    private getUserGroups(){
    const endpoint = 'user/id/'+this.userID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.groups = result.json().groups;
    });
}

addPublication(event: any, title:string, description: string, tags:string, audio, video, group){
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
    formData.append('idGroup', this.selGroup);
    
    console.log(group);
    
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
    changeGroup(event){
        this.selGroup = event.target.value;
    }
}
