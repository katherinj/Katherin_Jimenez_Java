package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this
        List<Customer> customerAccounts = new ArrayList();

        for (String[] data : customerData){
            boolean found = false;
            for( Customer cust : customerAccounts){
                if(cust.getId() == Integer.parseInt(data[0])){
                    found = true;
                    cust.addCharge(Integer.parseInt(data[2]), data[3]);
                }
            }
            if(found == false){
                customerAccounts.add(new Customer(Integer.parseInt(data[0]), data[1], new AccountRecord(Integer.parseInt(data[2]), data[3])));
            }
        }

        System.out.println("Positive accounts:");
        for( Customer cust : customerAccounts ) {
            if( cust.getBalance() >= 0 ) {
                System.out.println(cust);
            }
        }

        System.out.println("Negative accounts:");
        for( Customer cust : customerAccounts ) {
            if( cust.getBalance() < 0 ) {
                System.out.println(cust);
            }
        }
    }
}
