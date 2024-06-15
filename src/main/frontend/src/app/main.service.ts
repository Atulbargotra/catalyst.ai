import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NwiResponse } from './nwi-response.interface';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor(private httpClient: HttpClient) { }

  getText() {
    console.log(environment.apiUrl, "INN");
    return this.httpClient.get<NwiResponse>(`http://localhost:8090/portal/api/nwi/getText`);
  }
}
