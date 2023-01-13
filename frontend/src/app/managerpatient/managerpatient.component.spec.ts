import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerpatientComponent } from './managerpatient.component';

describe('ManagerpatientComponent', () => {
  let component: ManagerpatientComponent;
  let fixture: ComponentFixture<ManagerpatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerpatientComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerpatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
