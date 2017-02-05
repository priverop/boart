import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

/* ROOT */
import { AppComponent } from './app.component';

/* PAGES */
import { BoartComponent } from './pages/boart/boart.component';
import { PublicComponent } from './pages/public/public.component';
import { PublicationComponent } from './pages/publication/publication.component';
import { SingupComponent } from './pages/singup/singup.component';

/* COMPONENTS */
import { HeaderComponent } from './components/header/header.component';
import { SearchComponent } from './components/search/search.component';
import { TagListComponent } from './components/tag-list/tag-list.component';



const appRoutes: Routes = [
  { path: 'publication', component: PublicationComponent},
  { path: 'boart', component: BoartComponent },
  { path: 'singup', component: SingupComponent },
  { path: '', component: PublicComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    BoartComponent,
    BoartComponent,
    PublicComponent,
    PublicationComponent,
    HeaderComponent,
    SearchComponent,
    TagListComponent,
    SingupComponent
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
