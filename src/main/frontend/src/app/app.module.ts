import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { AccrualRuleComponent } from './accrual-rule/accrual-rule.component';
import { LoginformComponent } from './loginform/loginform.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule, Routes} from '@angular/router';
import { UserService } from './user.service';
import { AuthguardGuard } from './authguard.guard';

const appRoutes: Routes = [
  {
    path: '',
    component: LoginformComponent
  },
  {
    path: 'accrualRule',
    canActivate: [AuthguardGuard],
    component: AccrualRuleComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    AccrualRuleComponent,
    LoginformComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule
  ],
  providers: [UserService, AuthguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
