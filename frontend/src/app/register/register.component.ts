import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  alert: boolean = false;
  constructor(private service: UserServiceService, private rout: Router) {}
  ngOnInit(): void {
    // this.service.RegisterUser().subscribe((data)=>(this.UserRegister=data));
  }
  registerForm = new FormGroup({
    userName: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.pattern('[a-zA-Z].*'),
    ]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(15),
    ]),
    role: new FormControl('', [Validators.required]),
  });

  registerSubmited() {
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
  get Password(): FormControl {
    return this.registerForm.get('password') as FormControl;
  }
  get Role(): FormControl {
    return this.registerForm.get('role') as FormControl;
  }
  closeAlert() {
    this.alert = false;
  }

  logOut() {
    //console.log('in ch');

    this.rout.navigate(['/']);
  }
}
