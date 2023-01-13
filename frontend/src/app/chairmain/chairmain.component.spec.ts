import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChairmainComponent } from './chairmain.component';

describe('ChairmainComponent', () => {
  let component: ChairmainComponent;
  let fixture: ComponentFixture<ChairmainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChairmainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChairmainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
