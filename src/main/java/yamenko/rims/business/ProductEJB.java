package yamenko.rims.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import yamenko.rims.persistence.Product;

/**
 * Product EJB
 */
@Stateless
public class ProductEJB {
    /*
    * Attributes
    * */

    @PersistenceContext(unitName = "RIMSPU")
    private EntityManager em;

    /*
    * Public methods
    * */

    public List<Product> findProducts() {
        TypedQuery<Product> query = em.createNamedQuery("findAllProducts", Product.class);

        return query.getResultList();
    }
}
