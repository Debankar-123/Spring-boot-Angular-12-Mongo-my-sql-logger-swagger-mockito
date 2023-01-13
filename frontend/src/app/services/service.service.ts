import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceService {
  constructor(private http: HttpClient) {}
  GetCard(): Observable<any[]> {
    return this.http.get<any[]>('http://localHost:9092/api/getAll');
  }
  addCard(card: any): Observable<any> {
    const headers = new HttpHeaders()
      .set('content-type', 'application/json')
      .set('Access-Control-Allow-Origin', '*');
    return this.http.post('http://localHost:9092/api/add', card, {
      headers: headers,
    });
  }
  deleteCard(cardNo: any): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:9092/api/deleteAll/${cardNo}/`
    );
  }
  updateCard(card: any): Observable<any> {
    return this.http.put('http://localhost:9092/api/update', card);
  }
  deleteAllCard(): Observable<any> {
    return this.http.delete<any>('http://localhost:9092/api/deleteAll');
  }
  GetCardById(cardNo: string): Observable<any> {
    return this.http.get<any>(`http://localHost:9092/api/getAll/${cardNo}`);
  }
}
