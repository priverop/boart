import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

/* ROOT */
import { AppComponent } from './app.component';

/* PAGES */
import { CoverComponent } from './pages/cover/cover.component';
import { SafePipe } from './pages/cover/cover.component';

/* COMPONENTS */

/* SERVICES */
import { AjaxService } from "./services/ajax.service";
import { LoginService } from './services/login.service';

import { UploadComponent } from './pages/upload/upload.component';
import { PublicationComponent } from './pages/publication/publication.component';
import { GroupComponent } from './pages/group/group.component';
import { PublicProfileComponent } from './pages/public-profile/public-profile.component';
import { PrivateProfileComponent } from './pages/private-profile/private-profile.component';
import { CreateGroupComponent } from './pages/create-group/create-group.component';
import { AppHeaderComponent } from './components/app-header/app-header.component';
import { AppTagListComponent } from './components/app-tag-list/app-tag-list.component';
import { AppSearchComponent } from './components/app-search/app-search.component';
import { AppFooterComponent } from './components/app-footer/app-footer.component';

import { AppMediaComponent } from './components/app-media/app-media.component';
import { LoginComponent } from './pages/login/login.component';
import { CommentsComponent } from './components/comments/comments.component';
import { RegisterComponent } from './pages/register/register.component';
import {UserResolve} from "./services/resolver";

const appRoutes: Routes = [
  { path: '', component: CoverComponent, resolve: {items: UserResolve}},
  { path: 'publication/:id', component: PublicationComponent, resolve: {items: UserResolve}},
  { path: 'upload', component: UploadComponent, canActivate: [LoginService], resolve: {items: UserResolve}},
  { path: 'group/:id', component: GroupComponent, resolve: {items: UserResolve}},
  { path: 'public-profile/:username', component: PublicProfileComponent, resolve: {items: UserResolve}},
  { path: 'private-profile', component: PrivateProfileComponent, canActivate: [LoginService], resolve: {items: UserResolve}},
  { path: 'create-group', component: CreateGroupComponent, canActivate: [LoginService], resolve: {items: UserResolve}},
  { path: 'login', component: LoginComponent, resolve: {items: UserResolve}},
  { path: 'register', component: RegisterComponent, resolve: {items: UserResolve}},
  { path: '**', component: CoverComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    CoverComponent,
    SafePipe,
    UploadComponent,
    PublicationComponent,
    GroupComponent,
    PublicProfileComponent,
    PrivateProfileComponent,
    CreateGroupComponent,
    AppHeaderComponent,
    AppTagListComponent,
    AppSearchComponent,
    AppFooterComponent,
    AppMediaComponent,
    LoginComponent,
    CommentsComponent,
    RegisterComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpModule,
    NgbModule
  ],
  providers: [
    AjaxService,
    LoginService,
    UserResolve
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
