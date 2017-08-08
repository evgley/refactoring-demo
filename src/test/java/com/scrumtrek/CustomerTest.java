package com.scrumtrek;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
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

    public Movie CreateMovie(String title, PriceCodes priceCode)
    {
        Movie m = mock(Movie.class);
        when(m.getPriceCode())
                .thenReturn(priceCode);
        when(m.getTitle())
                .thenReturn(title);

        return m;
    }

    public Rental CreateRentalStub(Movie m, int daysRented)
    {
        Rental r = mock(Rental.class);

        when(r.getDaysRented())
                .thenReturn(daysRented);
        when(r.getMovie())
                .thenReturn(m);

        return r;
    }

    @Test
    public void addRental(){
        Customer c = new Customer("test");

        Movie m = CreateMovie("firstMovie", Regular);
        Movie m2 = CreateMovie("secondMovie", NewRelease);
        Movie m3 = CreateMovie("thirdMovie", Childrens);

        Rental r = CreateRentalStub(m, 1);
        Rental r2 = CreateRentalStub(m2, 2);
        Rental r3 = CreateRentalStub(m3, 3);

        c.addRental(r);
        c.addRental(r2);
        c.addRental(r3);

        Assert.assertThat(c.Statement(),  containsString("Amount owed is 9.5"));
        Assert.assertThat(c.Statement(),  containsString("You earned 4 frequent renter points"));

        System.out.println(c.Statement());
    }
}
