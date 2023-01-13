import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Patient } from '../model/patient';
import { PatientService } from '../services/patient.service';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-managerpatient',
  templateUrl: './managerpatient.component.html',
  styleUrls: ['./managerpatient.component.css'],
})
export class ManagerpatientComponent implements OnInit {
  patientDetails!: FormGroup;
  patientobj: Patient = new Patient();
  patientList: Patient[] = [];
  patient: Patient = new Patient();
  resultList: Patient[] = [];
  bool1: Boolean = false;
  bool2: Boolean = false;

  bIiD: any = sessionStorage.getItem('branchId');
  branchII: number = +this.bIiD | 0;
  bid: number = this.branchII;
  constructor(
    private formBuilder: FormBuilder,
    private patientService: PatientService,
    private service: ServiceService
  ) {}
  ngOnInit(): void {
    this.getAllPatient();
    this.patientDetails = this.formBuilder.group({
      //patientId:[''],
      patientTransectionId: [],
      patientCardNo: [''],
      patientName: [''],
      patientBranchId: [],
      branchName: [''],
      patientDistrictName: [''],
      patientStateName: [''],
      patientDateOfUsage: [],
    });
  }
  addPatient() {
    console.log(this.patientDetails);
    //this.patientobj. patientId=this.patientDetails.value. patientId;
    this.patientobj.patientTransectionId =
      this.patientDetails.value.patientTransectionId;
    this.patientobj.patientCardNo = this.patientDetails.value.patientCardNo;
    this.patientobj.patientName = this.patientDetails.value.patientName;
    this.patientobj.patientBranchId = this.bid;
    this.patientobj.branchName = this.patientDetails.value.branchName;
    this.patientobj.patientDistrictName =
      this.patientDetails.value.patientDistrictName;
    this.patientobj.patientStateName =
      this.patientDetails.value.patientStateName;
    this.patientobj.patientDateOfUsage =
      this.patientDetails.value.patientDateOfUsage;

    this.patientService.addPatient(this.patientobj).subscribe(
      (res) => {
        console.log(res);
        this.getAllPatient();
      },
      (err) => {
        console.log(err);
      }
    );
  }
  getAllPatient() {
    var bID: any = sessionStorage.getItem('branchId');
    let branchI: number = +bID | 0;
    this.patientService.getAllPatient().subscribe(
      (res) => {
        this.patientList = res;
        this.resultList = this.patientList.filter(
          (p) => p.patientBranchId == branchI
        );
      },
      (err) => {
        console.log('error while fetching data.');
      }
    );
  }
  editPatient(id: number) {
    //this.patientDetails.controls['patientId'].setValue(patient.patientId);
    this.patientService
      .getPatientbyId(id)
      .subscribe((data) => (this.patient = data));
  }
  deleteMe(id: number) {
    this.patientService.deleteCard(id).subscribe();
    this.getAllPatient();
  }
  updateMe() {
    this.patientService.updatePatient(this.patient).subscribe();
    this.getAllPatient();
  }
  checkCard() {
    console.log(this.patientDetails.value.patientCardNo);
    this.service.GetCardById(this.patientDetails.value.patientCardNo).subscribe(
      (data) => {
        // this.bool1 = true;
        if (data != null) {
          this.bool1 = true;
          this.bool2 = false;
        } else {
          this.bool2 = true;
          this.bool1 = false;
        }
      },
      (error) => {
        this.bool2 = true;
        this.bool1 = false;
      }
    );
  }
}
