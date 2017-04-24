import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppMediaComponent } from './app-media.component';

describe('AppMediaComponent', () => {
  let component: AppMediaComponent;
  let fixture: ComponentFixture<AppMediaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppMediaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppMediaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
