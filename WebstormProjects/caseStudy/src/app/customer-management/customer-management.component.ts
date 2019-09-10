import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Customer} from '../Customer';
import {CustomerService} from '../customer.service';

@Component({
  selector: 'app-customer-management',
  templateUrl: './customer-management.component.html',
  styleUrls: ['./customer-management.component.scss']
})
export class CustomerManagementComponent implements OnInit {
  customers: Customer[];
  @Output() customerClick = new EventEmitter<Customer>();
  message: string;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit() {
    this.getListCustomer();
  }

  getListCustomer() {
    const listCustomer = this.customerService.getList();
    listCustomer.subscribe(newList => {
      this.customers = newList;
    }, error => this.message = error.message);
  }
  selectCustomer(customer: Customer) {
    this.customerClick.emit(customer);
  }
  deleteCustomer(id: number) {
    this.customerService.delete(id).subscribe( () => {
      this.message = 'Successfully deleted';
      this.getListCustomer();
    }, error => {
      this.message = 'Failed when deleting customer with id = ' + id;
    });
  }
}
