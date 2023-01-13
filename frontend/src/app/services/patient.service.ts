import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import { Patient } from '../modal/patient';
import { Observable } from 'rxjs';
import { Patient } from '../model/patient';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  constructor(private http: HttpClient) {}
  addPatient(patient: Patient): Observable<Patient> {
    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*');
    return this.http.post<Patient>(
      'http://localhost:9096/patient/add',
      patient,
      {
        headers: headers,
      }
    );
  }
  getAllPatient(): Observable<Patient[]> {
    return this.http.get<any>('http://localhost:9096/patient/findAll');
  }
  deleteCard(patientId: any): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:9096/patient/deleteByPatientId/${patientId}/`
    );
  }
  getPatientbyId(patientId: number): Observable<Patient> {
    return this.http.get<Patient>(
      `http://localhost:9096/patient/findByPatientId/${patientId}`
    );
  }
  updatePatient(patient: Patient): Observable<Patient> {
    return this.http.put<Patient>(
      'http://localhost:9096/patient/update',
      patient
    );
  }
}
