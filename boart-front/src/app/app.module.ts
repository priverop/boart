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

const appRoutes: Routes = [
  { path: '', component: CoverComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CoverComponent,
    SafePipe
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
