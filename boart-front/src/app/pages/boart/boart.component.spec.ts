/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { BoartComponent } from './boart.component';

describe('BoartComponent', () => {
  let component: BoartComponent;
  let fixture: ComponentFixture<BoartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
