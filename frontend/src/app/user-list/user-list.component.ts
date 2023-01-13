import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../model/user.model';

import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent {
  alert: boolean = false;
  r: string = '';
  list: User[] = [];
  //manager:string='';
  userId: number = 0;
  u: number = 0;
  l: any = '';
  user: User = new User();

  constructor(private service: UserServiceService) {}

  ngOnInit(): void {
    this.find();
    // ({
    //   userId:[''],
    //   userName:[''],
    //   email:[''],
    //   role:['']
    // })
  }
  find() {
    this.service.findall().subscribe((res) => {
      this.list = res;
      console.log(this.list);
    });
  }
  delete(userId: number) {
    this.service.delete(userId).subscribe((res) => {
      console.log(res);
      this.find();
    });
  }
  getById(userId: number) {
    this.service.findById(userId).subscribe((res) => {
      console.log(res);
      this.l = res;
    });
  }
  registerForm = new FormGroup({
    userName: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.pattern('[a-zA-z].*'),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    role: new FormControl('', [Validators.required]),
  });

  userSubmited() {
    console.log(this.registerForm.value);
    this.service.adduser(this.registerForm.value).subscribe();
    this.alert = true;
    this.registerForm.reset({});
  }
  get Name(): FormControl {
    return this.registerForm.get('userName') as FormControl;
  }
  get Email(): FormControl {
    return this.registerForm.get('email') as FormControl;
  }

  get Role(): FormControl {
    return this.registerForm.get('role') as FormControl;
  }
  closeAlert() {
    this.alert = false;
  }

  edit(id: number) {
    this.service.findById(id).subscribe((data) => (this.user = data));
    console.log(id);
    console.log(this.user);
  }

  updateuser() {
    this.service.update(this.user).subscribe();
  }
}
