import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {

  constructor(private router: Router,private user: UserService) { }

  ngOnInit() {
  }

  login(e){
    e.preventDefault();
    const username = e.target.elements[0].value ;
    const password = e.target.elements[0].value ;
    if(username === 'admin' && password === 'admin') {
      this.router.navigate(['/accrualRule']);
      this.user.setIsUserLoggedIn();
    }
  }

}
