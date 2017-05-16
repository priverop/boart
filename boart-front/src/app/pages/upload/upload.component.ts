import { Component, OnInit } from '@angular/core';
import { AjaxService } from '../../services/ajax.service';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { FormGroup, FormControl, Validators, FormBuilder, ReactiveFormsModule, FormsModule } from '@angular/forms';
import {Title} from '@angular/platform-browser';


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
  private typeFile;
  private filters: Array<any>;

  constructor(private ajaxService: AjaxService, private router: Router,private loginService: LoginService, private titleService: Title) {
  }

  ngOnInit() {
    this.titleService.setTitle("Boart - Nueva Publicación");
    this.userID = this.loginService.user.id;
    this.getUserGroups();
    this.typeFile = {
      optionsRadios: 'img'
    };
    this.filters = [];
  }

  private getUserGroups(){
    const endpoint = 'user/id/'+this.userID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.groups = result.json().groups;
    });
  }

  addPublication(event: any, title:string, description: string, tags:string, audio, video, group){
    event.preventDefault();
    const endpoint = 'upload/';
    let formData:FormData = new FormData();
    formData.append('title', title);
    formData.append('description', description);
    formData.append('tags', tags.split('\n').join(','));
    formData.append('type', this.mediaType);
    formData.append('idGroup', this.selGroup);

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

    this.ajaxService.multipartRequest(endpoint, formData).subscribe(
      response => this.router.navigate(['/'])
    );
  }
  public fileChangeEvent(fileInput: any){
    this.imageFile = fileInput.target.files[0];
  }

  showHide(type){
    let groupImagen = document.getElementById("groupImagen");
    let groupAudio = document.getElementById("groupAudio");
    let groupVideo = document.getElementById("groupVideo");
    let optionsRadios1 = <HTMLInputElement>document.getElementById("optionsRadios1");
    let optionsRadios2 = <HTMLInputElement>document.getElementById("optionsRadios2");
    let optionsRadios3 = <HTMLInputElement>document.getElementById("optionsRadios3");

    groupImagen.style.display = optionsRadios1.checked ? "block" : "none";
    groupAudio.style.display = optionsRadios2.checked ? "block" : "none";
    groupVideo.style.display = optionsRadios3.checked ? "block" : "none";

    (<HTMLInputElement>document.getElementById("inputFile")).value="";
    (<HTMLInputElement>document.getElementById("txtAudio")).value="";
    (<HTMLInputElement>document.getElementById("txtVideo")).value="";
    document.getElementById("divRetoques").style.display = "none";
    this.mediaType= type;
  }
  changeGroup(event){
    this.selGroup = event.target.value;
  }

  readURL(input) {
    if (input.files && input.files[0]) {
      let reader = new FileReader();

      reader.onload = function (e) {
        document.getElementById("image").style.display = "block";
        document.getElementById("image").setAttribute('src', e.target['result']);
      };

      reader.readAsDataURL(input.files[0]);
    }
  }

  editImage () {

  let concatValue = "";

  for (let filter in this.filters) {
    let value = this.filters[filter];
    concatValue = concatValue + ' ' + filter + '(' + value + ')';
  }

  document.getElementById("image").style.filter = concatValue;

};

  setFilter(filter, value) {
    this.filters[filter] = value;
    this.editImage();
  };

  setValue (name, value) {

  switch(name) {
    case 'blur':
      value = value + 'px';
      break;
    case 'hue-rotate':
      value = value + 'deg';
      break;
    case 'opacity':
      value = value + '%';
      break;
    default:
      value;
  }
  return value;
}

  setRange(filter, value) {
    this.setFilter(filter, this.setValue(filter, value));
  }
}
