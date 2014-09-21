package yamenko.rims.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import yamenko.rims.persistence.Customer;

/**
 * Customer EJB
 */
@Stateless
public class CustomerEJB {
    /*
    * Attributes
    * */

    @PersistenceContext(unitName = "RIMSPU")
    private EntityManager em;

    /*
    * Public methods
    * */

    public Customer createCustomer(Customer customer) {
        em.persist(customer);

        return customer;
    }

    public List<Customer> findCustomers() {
        TypedQuery<Customer> query = em.createNamedQuery("findAllCustomers", Customer.class);

        return query.getResultList();
    }

    public Customer findCustomer(Long id) {
        return em.find(Customer.class, id);
    }

    public void deleteCustomer(Customer customer) {
        em.remove(em.merge(customer));
    }
}
