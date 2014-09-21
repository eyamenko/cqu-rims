package yamenko.rims.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import yamenko.rims.Rating;
import yamenko.rims.business.ProductEJB;
import yamenko.rims.persistence.Product;

/**
 * Product managed bean
 */
@ManagedBean
@RequestScoped
public class ProductController {
    /*
    * Attributes
    * */

    @EJB
    private ProductEJB productEJB;

    /*
    * Public methods
    * */

    /**
     * Get all ratings.
     *
     * @return an array of all ratings
     */
    public Rating[] getRatings() {
        return Rating.values();
    }

    /**
     * Get all products.
     *
     * @return a list of all products
     */
    public List<Product> getProducts() {
        return productEJB.findProducts();
    }
}
