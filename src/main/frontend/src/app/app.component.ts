import { Component } from '@angular/core';
import { AccrualRuleComponent } from './accrual-rule/accrual-rule.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app1';
  vehicles: Vehicle[];

  constructor(){
    this.vehicles = this.getVehicles();
  }

 getVehicles(){
    return [
      {'owner': 'prashant gupta', 'maker': 'Ford Figo'},
      {'owner': 'Pratima gupta', 'maker': 'Ford Eco-Sport'}
    ];
  }

}

export interface Vehicle{
  owner: string;
  maker: string;
}
