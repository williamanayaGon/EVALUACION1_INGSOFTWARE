import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Injectable } from '@angular/core';

export interface Pais {
  id: number;
  nombre: string;
  codigo: string;
}

@Injectable({
  providedIn: 'root'
})
export class PaisService {
  private apiUrl = 'http://localhost:8080/api/countries';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Pais[]> {
    return this.http.get<Pais[]>(this.apiUrl);
  }

  
}
