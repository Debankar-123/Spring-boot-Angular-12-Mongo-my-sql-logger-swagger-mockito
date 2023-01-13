import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BranchService } from '../services/branch.service';
import { PatientService } from '../services/patient.service';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css'],
})
export class ReportComponent implements OnInit {
  totalCard: any[] = [];
  totalPatient: any[] = [];
  totalbranch: any[] = [];

  constructor(
    private service: ServiceService,
    private rout: Router,
    private patient: PatientService,
    private branch: BranchService
  ) {}

  ngOnInit(): void {
    this.service.GetCard().subscribe((data) => (this.totalCard = data));
    this.patient
      .getAllPatient()
      .subscribe((data) => (this.totalPatient = data));
    this.branch.getAllBranches().subscribe((data) => (this.totalbranch = data));
  }
  logOut() {
    //console.log('in ch');

    this.rout.navigate(['/']);
  }
}
