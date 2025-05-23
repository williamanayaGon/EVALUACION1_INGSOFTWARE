import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Festivo {
  id: number;
  nombre: string;
  fecha: string;
}

@Injectable({
  providedIn: 'root'
})
export class FestivoService {
  private apiUrl = 'http://localhost:8080/api/holidays'; // Ajusta si tu puerto o path cambia

  constructor(private http: HttpClient) {}

  getAll(): Observable<Festivo[]> {
    return this.http.get<Festivo[]>(this.apiUrl);
  }

  getById(id: number): Observable<Festivo> {
    return this.http.get<Festivo>(`${this.apiUrl}/${id}`);
  }

  create(festivo: Festivo): Observable<Festivo> {
    return this.http.post<Festivo>(this.apiUrl, festivo);
  }

  update(id: number, festivo: Festivo): Observable<Festivo> {
    return this.http.put<Festivo>(`${this.apiUrl}/${id}`, festivo);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
