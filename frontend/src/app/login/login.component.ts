import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ChairmainComponent } from '../chairmain/chairmain.component';

import { UserServiceService } from '../services/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  type: String = '';
  hide = true;
  constructor(private router: Router, private service: UserServiceService) {}

  ngOnInit(): void {}

  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    pwd: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(15),
    ]),
  });
  loginSubmitted() {
    this.service
      .getrole(this.loginForm.value.email, this.loginForm.value.pwd)
      .subscribe(
        (data) => {
          if (data == 'chairmaan') {
            sessionStorage.setItem('chairmainId', this.loginForm.value.email);
            this.router.navigate(['chairman']);
          }
          if (data == 'manager') {
            sessionStorage.setItem('managerId', this.loginForm.value.email);
            this.router.navigate(['manager']);
          }
        },
        (error) => {
          alert('Invalid email and password');
        }
      );
  }
  get Email(): FormControl {
    return this.loginForm.get('email') as FormControl;
  }
  get Password(): FormControl {
    return this.loginForm.get('pwd') as FormControl;
  }
  login() {
    // this.router.navigate(['register'])
  }
}
