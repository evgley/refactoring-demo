package com.scrumtrek;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static com.scrumtrek.simplestore.PriceCodes.Childrens;
import static com.scrumtrek.simplestore.PriceCodes.NewRelease;
import static com.scrumtrek.simplestore.PriceCodes.Regular;
import static org.hamcrest.CoreMatchers.containsString;

@Ignore
public class CustomerTest {

    @Test
    public void shouldHaveNameWhenConstructed(){
        Customer c = new Customer("test");

        Assert.assertEquals("test", c.getName());
    }

    @Test
    public void test2(){
        Customer c = new Customer("test");

        System.out.println(c.Statement());
    }

    @Test
    public void addRental(){
        Customer c = new Customer("test");

        Movie m = new Movie("title", Regular);
        Rental r = new Rental(m, 1);

        Movie m2 = new Movie("title1", Childrens);
        Rental r2 = new Rental(m2, 1);

        Movie m3 = new Movie("title2", NewRelease);
        Rental r3 = new Rental(m3, 1);

        c.addRental(r);
        c.addRental(r2);
        c.addRental(r3);

        Assert.assertThat(c.Statement(),  containsString("Amount owed is 6.5"));
        Assert.assertThat(c.Statement(),  containsString("You earned 3 frequent renter points"));

        System.out.println(c.Statement());
    }
}
