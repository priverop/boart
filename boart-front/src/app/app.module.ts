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

/* COMPONENTS */

const appRoutes: Routes = [
  { path: 'boart', component: BoartComponent },
  { path: '', redirectTo: 'boart', pathMatch: 'full' },
];

@NgModule({
  declarations: [
    AppComponent,
    BoartComponent,
    BoartComponent
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
