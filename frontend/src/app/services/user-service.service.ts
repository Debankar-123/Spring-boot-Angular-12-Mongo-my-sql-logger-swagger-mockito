import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService {
  constructor(private http: HttpClient) {}
  //RegisterUser(user:any): Observable<any>{
  //  return this.http.post('http://localhost:9098/register',user);
  //}
  getrole(email: any, password: any): Observable<any> {
    return this.http.get(
      `http://localhost:9098/user/findbyEmailAndPassword/${email}/${password}`,
      { responseType: 'text' }
    );
  }
  adduser(user: any): Observable<any> {
    return this.http.post('http://localhost:9098/user/register', user);
  }
  findall(): Observable<any> {
    return this.http.get('http://localhost:9098/user/getByRole/manager');
  }
  delete(id: number): Observable<any> {
    return this.http.delete(`http://localhost:9098/user/deleteUser/${id}`, {
      responseType: 'text',
    });
  }
  findById(id: number): Observable<any> {
    return this.http.get('http://localhost:9098/user/findById' + '/' + id);
  }

  update(user: any): Observable<any> {
    return this.http.put<any>('http://localhost:9098/user/update', user);
  }
}
