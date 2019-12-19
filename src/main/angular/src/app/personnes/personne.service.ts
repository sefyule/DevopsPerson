import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Personne} from './personne';


@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  constructor(private httpClient: HttpClient) { }

  getAllPersonnes() : Observable<Array<Personne>> {
      return this.httpClient.get<Array<Personne>>('/personnes')
  }

  deletePersonne(id: number) : Observable<any>{
  return this.httpClient.delete('/personnes/' + id);
  }
}
