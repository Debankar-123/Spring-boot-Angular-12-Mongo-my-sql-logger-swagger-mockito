import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './card/card.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { CardlistComponent } from './cardlist/cardlist.component';
import { CardDetailsComponent } from './card-details/card-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { NgxPaginationModule } from 'ngx-pagination';
import { ChairmainComponent } from './chairmain/chairmain.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PatientService } from './services/patient.service';
import { UserListComponent } from './user-list/user-list.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BranchComponent } from './branch/branch.component';
import { BranchmanagerComponent } from './branchmanager/branchmanager.component';
import { ReportComponent } from './report/report.component';
import { ManagerpatientComponent } from './managerpatient/managerpatient.component';
import { PatientPipe } from './pipes/patient.pipe';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    CardlistComponent,
    CardDetailsComponent,
    ChairmainComponent,
    DashboardComponent,
    UserListComponent,
    LoginComponent,
    RegisterComponent,
    BranchComponent,
    BranchmanagerComponent,
    ReportComponent,
    ManagerpatientComponent,
    PatientPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatListModule,
    MatCardModule,
    NgxPaginationModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
