package tests;

import org.junit.Test;

/**
 * Created by korotkovay on 14.12.2016.
 */
public class LitecartCartTest extends TestBase{

    @Test
    public void testAddToCart() {

        //Go to Index page
        app.openIndexPage();

        //Add first product
        app.addProduct(0);
        app.checkCartQuantity(1);

        //Add second product
        app.addProduct(1);
        app.checkCartQuantity(2);

        //Add third product
        app.addProduct(2);
        app.checkCartQuantity(3);

        //Go to Cart
        app.openCart();

        //Delete products from cart
        app.deleteProducts();
    }











}
