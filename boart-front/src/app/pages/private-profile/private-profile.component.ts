import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { AjaxService } from '../../services/ajax.service';
import {Title} from '@angular/platform-browser';
import { Router } from '@angular/router';


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
  objImg;

  constructor(private loginService: LoginService, private ajaxService: AjaxService, private titleService: Title, private router: Router) { }

  ngOnInit() {
    this.titleService.setTitle("Boart - Mi Perfil");
    this.userID = this.loginService.user.id;

    this.getUser();
  }

  private enableControl(event:any){
    event.target.disabled = false;
    (<HTMLInputElement>document.getElementById("send_form")).disabled = false;
  }

  updateUser(event: any, username: string, name: string, surname: string, description: string, inputImage: any){
    event.preventDefault();
    const endpoint = 'private_profile/';

    var formData = new URLSearchParams();
    formData.set('username', username);
    formData.set('name', name);
    formData.set('surname', surname);
    formData.set('description', description);

    this.ajaxService.putRequest(endpoint, formData).subscribe(
      response => console.log("ok "+response),
      error => console.log("error "+error)
    );
    
    if (this.objImg !== undefined) {
        var formData2:FormData = new FormData();
        formData2.append('inputImage', this.imageFile);
        this.ajaxService.multipartPutRequest(endpoint, formData2).subscribe(
          response => console.log("ok "+response),
          error => console.log("error "+error)
        );
    }
    
    this.router.navigate(['/']);
  }

  private clickImg(){
      this.objImg = document.getElementById("avatar");
    (<HTMLInputElement>document.getElementById("inputFile")).click();
  }

  changeImg(fileInput: any){
   if (fileInput.target.files && fileInput.target.files[0]) {
    var reader = new FileReader();

    reader.onload = (event) => {
     this.objImg.src= (<FileReader>event.target).result;
    }

    reader.readAsDataURL(fileInput.target.files[0]);
  }
  
  
    this.imageFile = fileInput.target.files[0];
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
