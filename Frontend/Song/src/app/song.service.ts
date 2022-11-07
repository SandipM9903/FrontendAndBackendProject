import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  baseUrl:string = "http://localhost:8085/api/v1/";
  constructor(private http:HttpClient) { }

  getAllSong(): Observable<any> {
    return this.http.get<any>(this.baseUrl+"get-all-song");
  }
}
