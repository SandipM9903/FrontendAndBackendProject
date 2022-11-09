import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SongService {

  baseUrl = "http://localhost:8085/api/v1";
  constructor(private http:HttpClient) { }

  getAllSong()
  {
    return this.http.get(this.baseUrl+"/get-all-song");
  }

  addSong(songobj:any)
  {
    return this.http.post(this.baseUrl+"/add-song", songobj);
  }

  deleteSong(songId:any)
  {
    return this.http.delete(this.baseUrl+"/song/" + songId);
  }

  updateSong(songId:any, songobj:any)
  {
    return this.http.put(this.baseUrl+"/song/" + songId, songobj);
  }
}
