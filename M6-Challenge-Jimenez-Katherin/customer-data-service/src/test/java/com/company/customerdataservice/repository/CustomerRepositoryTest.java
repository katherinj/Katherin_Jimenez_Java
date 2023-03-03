package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception { customerRepo.deleteAll(); }

    @Test
    public void shouldCreateNewCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setPhone("111-222-3456");
        customer.setCompany("BigCo");

        //Act...
        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@workday.com");
        customer.setCompany("Workday");
        customer.setPhone("111-222-3456");
        customer.setAddress1("100 Main St");
        customer.setAddress2("Building 3");
        customer.setCity("Hightstown");
        customer.setState("New Jersey");
        customer.setPostalCode("08520");
        customer.setCountry("USA");
        customerRepo.save(customer);

        //Act...
        customer.setFirstName("UPDATED");

        customerRepo.save(customer);

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());

        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldDeleteCustomer() {
        //Arrange...
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setLastName("Smith");
        customer.setEmail("joesmith@workday.com");
        customer.setCompany("Workday");
        customer.setPhone("111-222-3456");
        customer.setAddress1("100 Main St");
        customer.setAddress2("Building 3");
        customer.setCity("Hightstown");
        customer.setState("New Jersey");
        customer.setPostalCode("08520");
        customer.setCountry("USA");
        customerRepo.save(customer);

        //Act...
        customerRepo.deleteById(customer.getId());

        //Assert...
        Optional<Customer> customer1 = customerRepo.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void shouldGetCustomerByID() {
        //Arrange...

        //Act...
        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Smith");
        customer1.setEmail("joesmith@workday.com");
        customer1.setCompany("Workday");
        customer1.setPhone("111-222-3456");
        customer1.setAddress1("100 Main St");
        customer1.setAddress2("Building 3");
        customer1.setCity("Hightstown");
        customer1.setState("New Jersey");
        customer1.setPostalCode("08520");
        customer1.setCountry("USA");
        customerRepo.save(customer1);

        Optional<Customer> foundCustomer = customerRepo.findById(customer1.getId());

        //Assert...
        assertEquals(foundCustomer.get(), customer1);
    }

    @Test
    public void shouldGetAllCustomersByState() {
        //Arrange...

        //Act...
        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Smith");
        customer1.setEmail("joesmith@workday.com");
        customer1.setCompany("Workday");
        customer1.setPhone("111-222-3456");
        customer1.setAddress1("100 Main St");
        customer1.setAddress2("Building 3");
        customer1.setCity("Hightstown");
        customer1.setState("New Jersey");
        customer1.setPostalCode("08520");
        customer1.setCountry("USA");
        customerRepo.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Katherin");
        customer2.setLastName("Jimenez");
        customer2.setEmail("katherinjimenez@netflix.com");
        customer2.setCompany("Netflix");
        customer2.setPhone("111-222-3456");
        customer2.setAddress1("123 Ellen St");
        customer2.setAddress2("Building 7");
        customer2.setCity("Hamilton");
        customer2.setState("New Jersey");
        customer2.setPostalCode("08690");
        customer2.setCountry("USA");
        customerRepo.save(customer2);

        List<Customer> customerList = customerRepo.findByState("New Jersey");

        //Assert...
        assertEquals(2, customerList.size());
    }
}