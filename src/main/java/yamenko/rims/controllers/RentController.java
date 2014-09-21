package yamenko.rims.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import yamenko.rims.business.CustomerEJB;
import yamenko.rims.business.RentEJB;
import yamenko.rims.persistence.Customer;
import yamenko.rims.persistence.Rent;

/**
 * Rent managed bean
 */
@ManagedBean
@ViewScoped
public class RentController {
    /*
    * Attributes
    * */

    @EJB
    private RentEJB rentEJB;
    @EJB
    private CustomerEJB customerEJB;
    private Rent rent = new Rent();
    private Customer customer;

    /*
    * Post construct methods
    * */

    /**
     * Initialize customer field.
     */
    @PostConstruct
    public void initCustomer() {
        Long customerID = null;
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        // get all parameters
        Map<String, String> params = externalContext.getRequestParameterMap();
        // look for customerID parameter
        String customerIDString = params.get("customerID");

        try {
            // if customerID wasn't provided
            if (customerIDString == null || customerIDString.isEmpty())
                externalContext.responseSendError(404, "customerID must be provided");

            // try to parse customerID
            try {
                customerID = Long.valueOf(customerIDString);
            } catch (NumberFormatException e) {
                externalContext.responseSendError(404, "Wrong value for customerID");
            }

            // find customer by id
            Customer searchedCustomer = customerEJB.findCustomer(customerID);

            // if customer wasn't found
            if (searchedCustomer == null)
                externalContext.responseSendError(404, "Wrong customerID");

            // finally assign it
            setCustomer(searchedCustomer);
        } catch (IOException e) {
            // if any errors, complete a response
            context.responseComplete();
        }
    }

    /*
    * Public methods
    * */

    public void doCreateRent() {
        rentEJB.createRent(getCustomer(), getRent());
        setRent(new Rent()); // reset rent field
    }

    public void doDeleteRent(Rent rent) {
        rentEJB.deleteRent(getCustomer(), rent);
    }

    /*
    * Getters & Setters
    * */

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Rent> getRentList() {
        return getCustomer().getRents();
    }
}
