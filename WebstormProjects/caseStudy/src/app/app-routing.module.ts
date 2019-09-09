import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserloginComponent} from './userlogin/userlogin.component';
import {MessageFormComponent} from './messageForm/messageForm.component';
import {RegisterComponent} from './register/register.component';



const routes: Routes = [
  {path: 'login', component: UserloginComponent},
  {path: 'messageForm', component: MessageFormComponent},
  {path: 'register', component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
