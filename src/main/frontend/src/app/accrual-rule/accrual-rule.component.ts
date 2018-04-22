import { Component, OnInit } from '@angular/core';
import { AccrualRule} from './accrual-rule';
import { UserService } from '../user.service';

@Component({
  selector: 'app-accrual-rule',
  templateUrl: './accrual-rule.component.html',
  styleUrls: ['./accrual-rule.component.css']
})
export class AccrualRuleComponent implements OnInit {

  accrualRules = [
    new AccrualRule('Prashant Gupta', 1),
    new AccrualRule('Priyank Gupta', 2)
  ];

  constructor(private user: UserService) { }

  ngOnInit() {
  }

}
