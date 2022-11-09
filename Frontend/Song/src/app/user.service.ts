import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  baseUrl : string = "http://localhost:8081/authservice";
  addUser(userObj:any)
  {
    return this.http.post(this.baseUrl + "/register",userObj);
  }

  loginCheck(userObj:any)
  {
    return this.http.post(this.baseUrl + "/login", userObj);
  }
}
