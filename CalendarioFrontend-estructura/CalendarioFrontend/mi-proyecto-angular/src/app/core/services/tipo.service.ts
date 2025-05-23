import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Tipo {
  id: number;
  nombre: string;
}

@Injectable({
  providedIn: 'root'
})
export class TipoService {
  private apiUrl = 'http://localhost:8080/api/calendar-types'; // Asegúrate de que este endpoint exista

  constructor(private http: HttpClient) {}

  getAll(): Observable<Tipo[]> {
    return this.http.get<Tipo[]>(this.apiUrl);
  }


}
