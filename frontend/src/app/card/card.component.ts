import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Family } from '../model/Family';
import { HealthCard } from '../model/HealthCard';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css'],
})
export class CardComponent implements OnInit {
  family: any = [];
  alert: boolean = false;
  formvalues!: FormGroup;
  formvalue!: FormGroup;
  public familys = new Family();
  public hCard = new HealthCard();

  constructor(
    private fb: FormBuilder,
    private service: ServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.modalVal();
    this.formval();
  }
  formval() {
    this.formvalue = this.fb.group({
      cardHolderName: ['', [Validators.required]],
      mobile: [, [Validators.pattern('[0-9]{10}'), Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      type: [''],
      limit: [''],
      validUpTo: [''],
      members: [],
    });
  }
  cardType() {
    if ((this.formvalue.value.type = 'Gold')) {
      var today = new Date();
      var year = today.getFullYear();
      var month = today.getMonth();
      var day = today.getDate();
      this.formvalue.value.limit = 800000;
      this.formvalue.value.validUpTo = new Date(year + 3, month, day);
      this.formvalue.value.members = 3;
    }
  }
  modalVal() {
    this.formvalues = new FormGroup({
      relation: new FormControl(''),
      name: new FormControl(''),
      age: new FormControl(0),
    });
  }
  closeAlert() {
    this.alert = false;
    this.router.navigate(['/cardlist']);
  }
  get cardHolderName() {
    return this.formvalue.get('cardHolderName');
  }
  get mobile() {
    return this.formvalue.get('mobile');
  }
  get email() {
    return this.formvalue.get('email');
  }
  addFamily() {
    //alert(JSON.stringify(this.formvalues.value));

    this.familys.relation = this.formvalues.value.relation;
    this.familys.name = this.formvalues.value.name;
    this.familys.age = this.formvalues.value.age;
    this.family.push(this.familys);
    this.modalVal();
    this.familys = new Family();
  }
  saveFamily() {}
  deleteMe(i: number) {
    this.family.splice(i, 1);
  }
  submitMe() {
    this.hCard.cardHolderName = this.formvalue.value.cardHolderName;
    this.hCard.mobile = this.formvalue.value.mobile;
    this.hCard.email = this.formvalue.value.email;
    this.hCard.type = this.formvalue.value.type;
    this.hCard.limit = this.formvalue.value.limit;
    this.hCard.validUpTo = this.formvalue.value.validUpTo;
    this.hCard.members = this.formvalue.value.members;
    this.hCard.familyMembers = this.family;
    this.hCard.cardNo =
      '' +
      this.hCard.cardHolderName.substring(0, 4).toUpperCase() +
      '' +
      Math.floor(Math.random() * 10000);
    this.alert = true;
    this.service.addCard(this.hCard).subscribe(
      (data) => {},
      (error) => {
        alert('cant save' + JSON.stringify(error));
      }
    );
    this.family = [];
  }
  logOut() {
    //console.log('in ch');

    this.router.navigate(['/']);
  }
}
