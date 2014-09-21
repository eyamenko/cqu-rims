package yamenko.rims.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import yamenko.rims.persistence.Customer;
import yamenko.rims.persistence.Rent;

/**
 * Rent EJB
 */
@Stateless
public class RentEJB {
    /*
    * Attributes
    * */

    @PersistenceContext(unitName = "RIMSPU")
    private EntityManager em;

    /*
    * Public methods
    * */

    public Rent createRent(Customer customer, Rent rent) {
        em.persist(rent);
        customer.addRent(rent); // link with a customer
        em.merge(customer);

        return rent;
    }

    public void deleteRent(Customer customer, Rent rent) {
        em.remove(em.merge(rent));
        customer.removeRent(rent); // unlink
        em.merge(customer);
    }
}
