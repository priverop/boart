import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AjaxService } from '../../services/ajax.service';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-private-profile',
  templateUrl: './private-profile.component.html',
  styleUrls: ['./private-profile.component.scss']
})
export class PrivateProfileComponent implements OnInit {

  user = [];
  private userID: number;
  emptyFollowers: boolean = true;
  emptyFollowings: boolean = true;
  emptyGroups: boolean = true;
  imageFile;
  uploadOK:boolean = false;

  constructor(private loginService: LoginService, private ajaxService: AjaxService, private titleService: Title) { }

  ngOnInit() {
    this.titleService.setTitle("Boart - Mi Perfil");
    this.userID = this.loginService.user.id;

    this.getUser();
  }

  private enableControl(event:any){
    event.target.disabled = false;
    (<HTMLInputElement>document.getElementById("send_form")).disabled = false;
  }

  updateUser(event: any, username: string, name: string, surname: string, description: string, inputFile: any){
    event.preventDefault();
    const endpoint = 'private_profile/';

    var formData = new URLSearchParams();
    formData.set('username', username);
    formData.set('name', name);
    formData.set('surname', surname);
    formData.set('description', description);
    formData.set('inputImage', this.imageFile);

    this.ajaxService.multipartPutRequest(endpoint, formData).subscribe(
      response => console.log("ok "+response),
      error => console.log("error "+error)
    );
  }

  private clickImg(){
    (<HTMLInputElement>document.getElementById("inputFile")).click();
  }

  changeImg(fileInput: any){
    this.imageFile = fileInput.target.files[0];
    this.uploadOK = true;
  }

  private getUser(){
    const endpoint = 'user/id/'+this.userID;
    this.ajaxService.getRequest(endpoint).subscribe(result => {
      this.user = result.json();
      this.checkEmptyFollowers();
      this.checkEmptyFollowings();
      this.checkEmptyGroups();
    });
  }

  private checkEmptyFollowers(){
    this.emptyFollowers = this.user['followers'] == 0;
  }
  private checkEmptyFollowings(){
    this.emptyFollowings = this.user['following'] == 0;
  }
  private checkEmptyGroups(){
    this.emptyGroups = this.user['groups'] == 0;
  }

}
