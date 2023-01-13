import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-cardlist',
  templateUrl: './cardlist.component.html',
  styleUrls: ['./cardlist.component.css'],
})
export class CardlistComponent implements OnInit {
  AllHealthCard: any = [];
  p: any;
  constructor(private service: ServiceService, private router: Router) {}

  ngOnInit(): void {
    this.getData();
  }
  getData() {
    this.service.GetCard().subscribe((data) => (this.AllHealthCard = data));
  }
  logOut() {
    //console.log('in ch');

    this.router.navigate(['/']);
  }
}
