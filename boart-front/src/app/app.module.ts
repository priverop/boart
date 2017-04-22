import { BrowserModule } from '@angular/platform-browser';
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
import { UploadComponent } from './pages/upload/upload.component';
import { PublicationComponent } from './pages/publication/publication.component';
import { GroupComponent } from './pages/group/group.component';
import { PublicProfileComponent } from './pages/public-profile/public-profile.component';
import { PrivateProfileComponent } from './pages/private-profile/private-profile.component';
import { CreateGroupComponent } from './pages/create-group/create-group.component';
import { AppHeaderComponent } from './components/app-header/app-header.component';
import { AppTagListComponent } from './components/app-tag-list/app-tag-list.component';
import { AppSearchComponent } from './components/app-search/app-search.component';

const appRoutes: Routes = [
  { path: '', component: CoverComponent}
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
    AppSearchComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule
  ],
  providers: [
    AjaxService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
