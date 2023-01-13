import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BranchComponent } from './branch/branch.component';
import { BranchmanagerComponent } from './branchmanager/branchmanager.component';

import { CardComponent } from './card/card.component';
import { CardlistComponent } from './cardlist/cardlist.component';
import { ChairmainComponent } from './chairmain/chairmain.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ManagerpatientComponent } from './managerpatient/managerpatient.component';
import { RegisterComponent } from './register/register.component';
import { ReportComponent } from './report/report.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'report',
    component: ReportComponent,
  },
  {
    path: 'managerpatient',
    component: ManagerpatientComponent,
  },
  {
    path: 'manager',
    component: BranchmanagerComponent,
  },
  {
    path: 'ulist',
    component: UserListComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'branch',
    component: BranchComponent,
  },
  {
    path: 'cd',
    component: CardlistComponent,
  },
  {
    path: 'cardlist',
    component: CardlistComponent,
  },

  {
    path: 'card',
    component: CardComponent,
  },

  {
    path: 'chairman',
    component: ChairmainComponent,
  },
  {
    path: 'dash',
    component: DashboardComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
