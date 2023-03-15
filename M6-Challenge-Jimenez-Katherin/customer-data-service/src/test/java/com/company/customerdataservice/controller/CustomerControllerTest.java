package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    // ObjectMapper used to convert Java objects to JSON and vice versa
    @MockBean
    CustomerRepository customerRepository;
    private ObjectMapper mapper = new ObjectMapper();

    // Testing GET /customers/{id}
    @Test
    public void shouldGetCustomerByID() throws Exception {
        Customer cust = new Customer();
        cust.setFirstName("Tom");
        cust.setLastName("Hanks");
        cust.setEmail("tomhanks@gmail.com");
        cust.setCompany("Google");
        cust.setPhone("6096341212");
        cust.setAddress1("100 Ocean Ave");
        cust.setAddress2("Building 3");
        cust.setCity("Los Angeles");
        cust.setState("CA");
        cust.setCountry("USA");
        cust.setId(2);

        String outputJson = mapper.writeValueAsString(cust);

        mockMvc.perform(get("/customers/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // Testing POST /customer
    @Test
    public void shouldCreateNewCustomer() throws Exception {
        Customer cust = new Customer();
        cust.setFirstName("Tom");
        cust.setLastName("Hanks");
        cust.setEmail("tomhanks@gmail.com");
        cust.setCompany("Google");
        cust.setPhone("6096341212");
        cust.setAddress1("100 Ocean Ave");
        cust.setAddress2("Building 3");
        cust.setCity("Los Angeles");
        cust.setState("CA");
        cust.setCountry("USA");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(cust);

        Customer outputCust = new Customer();
        cust.setFirstName("John");
        cust.setLastName("Doe");
        cust.setEmail("johndoe@gmail.com");
        cust.setCompany("Facebook");
        cust.setPhone("6097874532");
        cust.setAddress1("121 Maple Ave");
        cust.setAddress2("Building 2");
        cust.setCity("Los Angeles");
        cust.setState("CA");
        cust.setCountry("USA");

        String outputJson = mapper.writeValueAsString(outputCust);

        // ACT
        mockMvc.perform(
                        post("/customers")              // Perform the POST request
                                .content(inputJson)             // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                // Print results to console
                .andExpect(status().isCreated());        // ASSERT (status code is 201)
    }

    // Testing PUT /book
    @Test
    public void shouldUpdateExistingCustomerByID() throws Exception {
        Customer cust = new Customer();
        cust.setFirstName("Tom");
        cust.setLastName("Hanks");
        cust.setEmail("tomhanks@gmail.com");
        cust.setCompany("Google");
        cust.setPhone("6096341212");
        cust.setAddress1("100 Ocean Ave");
        cust.setAddress2("Building 3");
        cust.setCity("Los Angeles");
        cust.setState("CA");
        cust.setCountry("USA");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(cust);

        mockMvc.perform(put("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing DELETE /book/{id}
    @Test
    public void shouldDeleteCustomerByID() throws Exception {
        Customer cust = new Customer();
        cust.setFirstName("Tom");
        cust.setLastName("Hanks");
        cust.setEmail("tomhanks@gmail.com");
        cust.setCompany("Google");
        cust.setPhone("6096341212");
        cust.setAddress1("100 Ocean Ave");
        cust.setAddress2("Building 3");
        cust.setCity("Los Angeles");
        cust.setState("CA");
        cust.setCountry("USA");

        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing GET /customers/state/{state}
    @Test
    public void shouldGetCustomersByState() throws Exception {
        Customer cust = new Customer();
        cust.setFirstName("Tom");
        cust.setLastName("Hanks");
        cust.setEmail("tomhanks@gmail.com");
        cust.setCompany("Google");
        cust.setPhone("6096341212");
        cust.setAddress1("100 Ocean Ave");
        cust.setAddress2("Building 3");
        cust.setCity("Los Angeles");
        cust.setState("CA");
        cust.setCountry("USA");

        mockMvc.perform(get("/customers/state/CA"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
