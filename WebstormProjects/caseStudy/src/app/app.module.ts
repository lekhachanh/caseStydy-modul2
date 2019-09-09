import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';


import {ReactiveFormsModule} from '@angular/forms';
import {MessageFormComponent} from './messageForm/messageForm.component';
import {UserloginComponent} from './userlogin/userlogin.component';
import {RegisterComponent} from './register/register.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    AppComponent,
    UserloginComponent,
    MessageFormComponent,
    RegisterComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
