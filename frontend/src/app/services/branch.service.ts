import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BranchComponent } from '../branch/branch.component';
import { Observable } from 'rxjs';
import { Branch } from '../model/branch';

@Injectable({
  providedIn: 'root',
})
export class BranchService {
  addBranchUrl: string;
  updateBranchUrl: string;
  getAllBranchesUrl: string;
  deleteBranchUrl: string;
  getByBranchCodeUrl: string;
  getByDistrictUrl: string;
  getByStateUrl: string;
  getByCountryUrl: string;
  getBranchbyEmail: string = '';

  constructor(private http: HttpClient) {
    //,private branch:BranchComponent ) {
    this.addBranchUrl = 'http://localhost:9097/branch/add';
    this.updateBranchUrl = 'http://localhost:9097/branch/update';
    this.getAllBranchesUrl = 'http://localhost:9097/branch/findAll';
    this.deleteBranchUrl = 'http://localhost:9097/branch/deleteById';
    this.getByBranchCodeUrl = 'http://localhost:9097/branch/findById';
    this.getByDistrictUrl = 'http://localhost:9097/branch/getByDist';
    this.getByStateUrl = 'http://localhost:9097/branch/getByState';
    this.getByCountryUrl = 'http://localhost:9097/branch/getByCountry';
    this.getBranchbyEmail = 'http://localhost:9097/branch/getByemail';
  }

  addBranch(branch: Branch): Observable<Branch> {
    return this.http.post<Branch>(this.addBranchUrl, branch);
  }

  updateBranch(branch: Branch): Observable<Branch> {
    return this.http.put<Branch>(
      this.updateBranchUrl + '/' + branch.branchCode,
      branch
    );
  }

  getAllBranches(): Observable<Branch[]> {
    return this.http.get<Branch[]>(this.getAllBranchesUrl);
  }

  deleteBranch(branch: Branch): Observable<Branch> {
    return this.http.delete<Branch>(
      this.deleteBranchUrl + '/' + branch.branchCode
    );
  }

  getByBranchCode(branch: number): Observable<Branch> {
    return this.http.get<Branch>(this.getByBranchCodeUrl + '/' + branch);
  }

  getByDistrict(branch: string): Observable<Branch[]> {
    return this.http.get<Branch[]>(this.getByDistrictUrl + '/' + branch);
  }

  getByState(branch: string): Observable<Branch[]> {
    return this.http.get<Branch[]>(this.getByStateUrl + '/' + branch);
  }

  getByCountry(branch: string): Observable<Branch[]> {
    return this.http.get<Branch[]>(this.getByCountryUrl + '/' + branch);
  }
  getByEmail(email: string | null): Observable<Branch> {
    return this.http.get<Branch>(this.getBranchbyEmail + '/' + email);
  }
}

//  href="http://localhost:9096/api"

//  getAllBranches():Observable<any>{
//   return this.http.get<any>(this.href+"/findAll");
//  }
