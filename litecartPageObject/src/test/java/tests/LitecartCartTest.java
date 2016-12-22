package tests;

import org.junit.Test;


/**
 * Created by korotkovay on 14.12.2016.
 */
public class LitecartCartTest extends TestBase{

    @Test
    public void testAddToCart() {

        //Go to Index page

        app.ApplicationopenIndexPage();

        //Add first product
        addProduct(0);
        checkCartQuantity(1);

        //Add second product
        addProduct(1);
        checkCartQuantity(2);

        //Add third product
        addProduct(2);
        checkCartQuantity(3);

        //Go to Cart
        openCart();

        //Delete products from cart
        deleteProducts();
    }











}
