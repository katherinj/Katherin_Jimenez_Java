package com.company;

//import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void shouldGetBalance(){
        Customer cust = new Customer(1,"John Doe", new AccountRecord(400, "12-01-2021"));
        assertEquals( 400,cust.getBalance());
    }

    @Test
    public void shouldUpdateAndAddToBalance() {
        Customer cust = new Customer(1,"John Doe", new AccountRecord(400, "12-01-2021"));
        cust.addCharge(100, "12-11-2021");
        assertEquals( 500, cust.getBalance());
    }

    @Test
    public void shouldUpdateAndSubtractFromBalance() {
        Customer cust = new Customer(1,"John Doe", new AccountRecord(400, "12-01-2021"));
        cust.addCharge(-300, "12-11-2021");
        assertEquals( 100, cust.getBalance());

        cust.addCharge(-500, "12-12-2021");
        assertEquals(-400, cust.getBalance());
    }

    @Test
    public void shouldConvertToString() {
        Customer cust = new Customer(1,"John Doe", new AccountRecord(400, "12-01-2021"));
        assertEquals("Customer ID: 1 -- Name: John Doe -- Balance: 400", cust.toString());
    }
}