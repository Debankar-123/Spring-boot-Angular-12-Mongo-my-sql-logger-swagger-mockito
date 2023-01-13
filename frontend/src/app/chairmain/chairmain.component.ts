import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chairmain',
  templateUrl: './chairmain.component.html',
  styleUrls: ['./chairmain.component.css'],
})
export class ChairmainComponent implements OnInit {
  constructor(private rout: Router) {}

  ngOnInit(): void {}
  logOut() {
    //console.log('in ch');

    this.rout.navigate(['/']);
  }
}
