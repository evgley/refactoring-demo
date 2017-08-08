package com.scrumtrek;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.Rental;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static com.scrumtrek.simplestore.PriceCodes.Childrens;
import static com.scrumtrek.simplestore.PriceCodes.NewRelease;
import static com.scrumtrek.simplestore.PriceCodes.Regular;
import static org.hamcrest.CoreMatchers.containsString;

public class CustomerTest {

    @Test
    @Ignore
    public void shouldHaveNameWhenConstructed(){
        Customer c = new Customer("test");

        Assert.assertEquals("test", c.getName());
    }

    @Test
    @Ignore
    public void test2(){
        Customer c = new Customer("test");

        System.out.println(c.Statement());
    }

    @Test
    public void addRental(){
        Customer c = new Customer("test");

        Movie m = mock(Movie.class);
        when(m.getPriceCode())
                .thenReturn(Regular);
        when(m.getTitle())
                .thenReturn("firstMovie");

        Rental r = new Rental(m, 1);

        Movie m2 = mock(Movie.class);
        when(m2.getPriceCode())
                .thenReturn(NewRelease);
        when(m2.getTitle())
                .thenReturn("secondMovie");
        Rental r2 = new Rental(m2, 1);

        Movie m3 = mock(Movie.class);
        when(m3.getPriceCode())
                .thenReturn(Childrens);
        when(m3.getTitle())
                .thenReturn("firstMovie");
        Rental r3 = new Rental(m3, 1);

        c.addRental(r);
        c.addRental(r2);
        c.addRental(r3);

        Assert.assertThat(c.Statement(),  containsString("Amount owed is 6.5"));
        Assert.assertThat(c.Statement(),  containsString("You earned 3 frequent renter points"));

        System.out.println(c.Statement());
    }
}
