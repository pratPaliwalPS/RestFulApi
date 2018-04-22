import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccrualRuleComponent } from './accrual-rule.component';

describe('AccrualRuleComponent', () => {
  let component: AccrualRuleComponent;
  let fixture: ComponentFixture<AccrualRuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccrualRuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccrualRuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
