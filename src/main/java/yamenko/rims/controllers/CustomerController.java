package yamenko.rims.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import yamenko.rims.business.CustomerEJB;
import yamenko.rims.persistence.Customer;

/**
 * Customer managed bean
 */
@ManagedBean
@ViewScoped
public class CustomerController {
    /*
    * Attributes
    * */

    @EJB
    private CustomerEJB customerEJB;
    private Customer customer = new Customer();
    private List<Customer> customerList;

    /*
    * Public methods
    * */

    public void doFindCustomers() {
        setCustomerList(customerEJB.findCustomers());
    }

    public void doCreateCustomer() {
        customerEJB.createCustomer(getCustomer());
        setCustomer(new Customer()); // reset customer field
    }

    public void doDeleteCustomer(Customer customer) {
        customerEJB.deleteCustomer(customer);
    }

    /*
    * Getters & Setters
    * */

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
