import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { HealthCard } from '../model/HealthCard';
import { ServiceService } from '../services/service.service';

@Component({
  selector: 'app-card-details',
  templateUrl: './card-details.component.html',
  styleUrls: ['./card-details.component.css'],
})
export class CardDetailsComponent implements OnInit {
  @Input() obj: any = {};
  formvalue!: FormGroup;
  objects: any;
  public hCard = new HealthCard();
  cDetails = {
    cardHolderName: '',
    mobile: 0,
    email: '',
    type: '',
    limit: 0,
    validUpTo: '',
    members: 0,
  };

  bool: boolean = false;
  constructor(
    private service: ServiceService,
    private router: Router,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.formValue();
  }

  deleteMe(cardNo: string) {
    this.service.deleteCard(cardNo).subscribe();
    this.router.navigate(['/cd']);
  }
  showFamily() {
    if (this.bool == false) {
      this.bool = true;
    }
  }
  formValue() {
    this.formvalue = this.fb.group({
      cardHolderName: [''],
      mobile: [],
      email: [''],
      type: [''],
      limit: [],
      validUpTo: [],
      members: [],
    });
  }
  updateMe() {
    //this.formvalue.value.cardHolderName = objs.cardHolderName;
    this.hCard.cardNo = this.objects.cardNo;
    this.hCard.cardHolderName = this.formvalue.value.cardHolderName;
    this.hCard.mobile = this.formvalue.value.mobile;
    this.hCard.email = this.formvalue.value.email;
    this.hCard.type = this.formvalue.value.type;
    this.hCard.limit = this.formvalue.value.limit;
    this.hCard.validUpTo = this.formvalue.value.validUpTo;
    this.hCard.members = this.formvalue.value.members;
    this.hCard.familyMembers = this.objects.familyMembers;

    //this.service.updateCard(this.hCard).subscribe();
    console.log(this.hCard);

    this.formValue();
    //  this.router.navigate(['/cardlist']);
  }
  setFormvalue() {
    this.objects = this.obj;
    this.cDetails.cardHolderName = this.obj.cardHolderName;
    this.cDetails.mobile = this.obj.mobile;
    this.cDetails.email = this.obj.email;
    this.cDetails.type = this.obj.type;
    this.cDetails.limit = this.obj.limit;
    this.cDetails.validUpTo = this.obj.validUpTo;
    this.cDetails.members = this.obj.members;
    console.log(this.obj);
    console.log(this.cDetails);
  }
}
