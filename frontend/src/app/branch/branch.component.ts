import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormControl,
  Validators,
} from '@angular/forms';
import { NavigationStart, Router } from '@angular/router';
import { Branch } from '../model/branch';
import { BranchService } from '../services/branch.service';

@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css'],
})
export class BranchComponent implements OnInit {
  title = 'my-app';
  //intervalId: any;
  branchDetails!: FormGroup;
  branchObj: Branch = new Branch();
  branchList: Branch[] = [];

  br: Branch = new Branch();

  bCode: number = 0;
  district1: string = '';
  state1: string = '';
  country1: string = '';
  errorMsg!: string;
  subscription: any;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private branchService: BranchService
  ) {}

  ngOnInit(): void {
    this.getAllBranches();
    this.branchDetails = this.formBuilder.group({
      branchCode: [''],
      hospitalId: [''],
      branchName: [''],
      email: [''],
      dist: [''],
      state: [''],
      country: [''],
    });
  }

  // branchDetails= new FormGroup({
  //   hospitalId: new FormControl("",[Validators.required,Validators.minLength(2)]),
  //   branchName: new FormControl("",[Validators.required,Validators.minLength(3),Validators.pattern("[a-zA-Z].*")]),
  //   branchManager: new FormControl("",[Validators.required,Validators.minLength(3),Validators.pattern("[a-zA-Z].*")]),
  //   dist:new FormControl("",[Validators.required,Validators.minLength(3),Validators.pattern("[a-zA-Z].*")]),
  //   state:new FormControl("",[Validators.required,Validators.minLength(3),Validators.pattern("[a-zA-Z].*")]),
  //   country:new FormControl("",[Validators.required,Validators.minLength(3),Validators.pattern("[a-zA-Z].*")])
  // });

  addBranch() {
    if (this.branchDetails.value.hospitalId === 0) {
      this.errorMsg = '*Branch not Added:- hospitalId is not be 0  ';
    } else if (this.branchDetails.value.branchName.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-branch name is should be greater than 3 letters ';
    } else if (this.branchDetails.value.email.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-branch Manager is should be greater than 3 letters ';
    } else if (this.branchDetails.value.dist.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-District is should be greater than 3 letters ';
    } else if (this.branchDetails.value.state.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-State is should be greater than 3 letters ';
    } else if (this.branchDetails.value.country.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-Country is should be greater than 3 letters ';
    } else {
      console.log(this.branchDetails);
      // this.branchObj.branchCode=this.branchDetails.value.branchCode;
      this.branchObj.hospitalId = this.branchDetails.value.hospitalId;
      this.branchObj.branchName = this.branchDetails.value.branchName;
      this.branchObj.email = this.branchDetails.value.email;
      this.branchObj.dist = this.branchDetails.value.dist;
      this.branchObj.state = this.branchDetails.value.state;
      this.branchObj.country = this.branchDetails.value.country;

      this.branchService.addBranch(this.branchObj).subscribe((res) => {
        console.log(res);
        this.getAllBranches();
      });
    }
    // ,(err)=>{
    //   console.log(err);}
    //this.router.navigate(['branch'])
    // TODO: Add branch
    // this.router.navigate(['add-branch'])
  }

  // addBranch() {
  //   console.log(this.branchDetails);
  //   this.branchObj.hospitalId=this.branchDetails.value.hospitalId;
  //   this.branchObj.branchName=this.branchDetails.value.branchName;
  //   this.branchObj.branchManager=this.branchDetails.value.branchManager;
  //   this.branchObj.dist=this.branchDetails.value.dist;
  //   this.branchObj.state=this.branchDetails.value.state;
  //   this.branchObj.country=this.branchDetails.value.country;
  //   this.branchService.addBranch(this.branchObj).subscribe(res=>{
  //     console.log(res);
  //     this.getAllBranches();
  //   });
  // }

  edit(id: number) {
    // this.branchToUpdate=branchi;
    this.branchService.getByBranchCode(id).subscribe((res) => {
      this.br = res;
    });
  }

  updateBranch() {
    //branch : Branch) {
    // this.branchObj.branchCode=this.branchDetails.value.branchCode;
    // this.branchObj.hospitalId=this.branchDetails.value.hospitalId;
    // this.branchObj.branchName=this.branchDetails.value.branchName;
    // this.branchObj.branchManager=this.branchDetails.value.branchManager;
    // this.branchObj.dist=this.branchDetails.value.dist;
    // this.branchObj.state=this.branchDetails.value.state;
    // this.branchObj.country=this.branchDetails.value.country;
    if (this.branchDetails.value.hospitalId === 0) {
      this.errorMsg = '*Branch not Added:- hospitalId is not be 0  ';
    } else if (this.branchDetails.value.branchName.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-branch name is should be greater than 3 letters ';
    } else if (this.branchDetails.value.email.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-branch Manager is should be greater than 3 letters ';
    } else if (this.branchDetails.value.dist.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-District is should be greater than 3 letters ';
    } else if (this.branchDetails.value.state.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-State is should be greater than 3 letters ';
    } else if (this.branchDetails.value.country.trim().length <= 2) {
      this.errorMsg =
        '*Branch not Added:-Country is should be greater than 3 letters ';
    } else {
      this.branchService.updateBranch(this.br).subscribe((res) => {
        console.log(res);
        this.getAllBranches();
      });
    }
    //this.router.navigate(['branch'])
    // , err=>{
    //   console.log(err);
    // })
    // TODO: Update branch
    //this.router.navigate(['update-branch'])
  }

  deleteBranch(branch: Branch) {
    this.branchService.deleteBranch(branch).subscribe((res) => {
      //this.branchObj = res;
      console.log(res);
      alert('Branch is deleted');
      this.getAllBranches();
    });
    // , err=>{
    //   console.log("error while fetching data.")
    // });

    // TODO: Delete branch
  }

  getBranchByCode() {
    //branch : Branch) {
    //this.bCode
    this.branchService.getByBranchCode(this.bCode).subscribe((res) => {
      console.log(res);
      // this.branchList=res;
      this.branchObj = res;
    });

    // , err=>{
    //   console.log("error while fetching data.")
    // });
    // TODO: Get branch by code
  }

  getAllBranches() {
    this.branchService.getAllBranches().subscribe((res) => {
      this.branchList = res;
    });

    // }, err=>{
    //   console.log("error while fetching data.")
    // });
    // TODO: Get all branches
    //this.router.navigate(['getallbranches'])
  }

  getBranchesByDistrict() {
    //branch : Branch) {
    this.branchService.getByDistrict(this.district1).subscribe((res) => {
      this.branchList = res;
    });

    //, err=>{
    //   console.log("error while fetching data.")
    // });
    // TODO: Get branches by district
  }

  getBranchesByState() {
    //branch :Branch) {
    this.branchService.getByState(this.state1).subscribe((res) => {
      this.branchList = res;
    });

    // , err=>{
    //   console.log("error while fetching data.")
    // });

    // TODO: Get branches by state
  }

  getBranchesByCountry() {
    //branch : Branch) {
    this.branchService.getByCountry(this.country1).subscribe((res) => {
      this.branchList = res;
    });

    // , err=>{
    //     console.log("error while fetching data.")
    //   });

    //   // TODO: Get branches by country
    // }
  }
}

/*
import { Component } from '@angular/core';

@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css']
})
export class BranchComponent {

}
*/
