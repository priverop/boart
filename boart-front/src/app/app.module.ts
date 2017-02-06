import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

/* ROOT */
import { AppComponent } from './app.component';

/* PAGES */
import { PublicComponent } from './pages/public/public.component';
import { PublicationComponent } from './pages/publication/publication.component';
import { SingupComponent } from './pages/singup/singup.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SelfProfileComponent } from './pages/self-profile/self-profile.component';
import { GroupComponent } from './pages/group/group.component';
import { UploadComponent } from './pages/upload/upload.component';



/* COMPONENTS */
import { HeaderComponent } from './components/header/header.component';
import { SearchComponent } from './components/search/search.component';
import { TagListComponent } from './components/tag-list/tag-list.component';
import { CommentsComponent } from './components/comments/comments.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginOverlayComponent } from './components/login-overlay/login-overlay.component';



const appRoutes: Routes = [
  { path: 'profile', component: ProfileComponent},
  { path: 'selfprofile', component: SelfProfileComponent},
  { path: 'publication', component: PublicationComponent},
  { path: 'upload', component: UploadComponent },
  { path: 'group', component: GroupComponent },
  { path: '', component: PublicComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    PublicComponent,
    PublicationComponent,
    HeaderComponent,
    SearchComponent,
    TagListComponent,
    SingupComponent,
    LoginComponent,
    ProfileComponent,
    CommentsComponent,
    SelfProfileComponent,
    GroupComponent,
    FooterComponent,
    UploadComponent,
    LoginOverlayComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
