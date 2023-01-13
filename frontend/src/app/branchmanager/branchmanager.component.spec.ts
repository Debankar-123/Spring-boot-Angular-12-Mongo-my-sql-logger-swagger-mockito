import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BranchmanagerComponent } from './branchmanager.component';

describe('BranchmanagerComponent', () => {
  let component: BranchmanagerComponent;
  let fixture: ComponentFixture<BranchmanagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BranchmanagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BranchmanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
