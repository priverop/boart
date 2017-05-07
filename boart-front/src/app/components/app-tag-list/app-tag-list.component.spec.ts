import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppTagListComponent } from './app-tag-list.component';

describe('AppTagListComponent', () => {
  let component: AppTagListComponent;
  let fixture: ComponentFixture<AppTagListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppTagListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppTagListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
