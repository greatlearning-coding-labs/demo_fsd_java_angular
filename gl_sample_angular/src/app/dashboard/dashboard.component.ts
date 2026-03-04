import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {

  stocks: any[] = [];

  //constructor(private http: HttpClient) {}
  constructor(private http: HttpClient, private router: Router) {}

  logout() {
    this.router.navigate(['/']);
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.http.get<any[]>('https://9e58b10be662cl2026ev1663776.hlabs-mygreatlearning.net:8080/trades')
      .subscribe(data => {
        this.stocks = data;
      });
  }

  delete(id: number) {
    this.http.delete('https://9e58b10be662cl2026ev1663776.hlabs-mygreatlearning.net:8080/trades' + id)
      .subscribe(() => {
        this.loadData();
      });
  }
}
