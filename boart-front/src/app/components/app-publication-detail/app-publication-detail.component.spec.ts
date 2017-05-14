import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppPublicationDetailComponent } from './app-publication-detail.component';

describe('AppPublicationDetailComponent', () => {
  let component: AppPublicationDetailComponent;
  let fixture: ComponentFixture<AppPublicationDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppPublicationDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppPublicationDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
