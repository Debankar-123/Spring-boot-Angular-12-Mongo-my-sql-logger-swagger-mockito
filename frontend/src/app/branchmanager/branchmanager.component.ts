import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BranchService } from '../services/branch.service';

@Component({
  selector: 'app-branchmanager',
  templateUrl: './branchmanager.component.html',
  styleUrls: ['./branchmanager.component.css'],
})
export class BranchmanagerComponent implements OnInit {
  constructor(private rout: Router, private br: BranchService) {}

  ngOnInit(): void {
    this.br
      .getByEmail(sessionStorage.getItem('managerId'))
      .subscribe((data) => {
        sessionStorage.setItem('branchId', data.branchCode + '');
        console.log(data.branchCode);
      });
  }
  logOut() {
    this.rout.navigate(['/']);
    sessionStorage.clear();
    localStorage.clear();
  }
}
