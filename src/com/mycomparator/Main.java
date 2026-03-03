/**
 *  Java program to use comparator.
 */

package com.mycomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 *  Main class.
 */
public class Main {

    // Entry point to run java program.
    public static void main(String[] args) {

        // Creating instances.
        Customer customer = new Customer(3, "Fiona");
        Customer customer1 = new Customer(1, "Dan");
        Customer customer2 = new Customer(2, "Leon");

        // Adding customers to a list.
        ArrayList<Customer> alc = new ArrayList<>();
        alc.add(customer);
        alc.add(customer1);
        alc.add(customer2);

        // Printing original collection.
        System.out.println("Original collection: " + alc);

        // Sorting.
        Collections.sort(alc, new CustomerComparator()); // Output: Original collection: [Customer{id=3, name='Fiona'},
                                                         // Customer{id=1, name='Dan'}, Customer{id=2, name='Leon'}]


        // Printing sorted collection.
        System.out.println("Sorted collection: " + alc); // Output: Sorted collection: [Customer{id=3, name='Fiona'},
                                                         // Customer{id=2, name='Leon'}, Customer{id=1, name='Dan'}]
    }
}

// Class Customer.
class Customer {

    // Fields of a class.
    int id;
    String name;

    // Constructor of a class Customer.
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to set id of a Customer.
    public void setId(int id) {
        this.id = id;
    }

    // Method to set name of a Customer.
    public void setName(String name) {
        this.name = name;
    }

    // Method to get id of a Customer.
    public int getId() {
        return id;
    }

    // Method to get name of a Customer.
    public String getName() {
        return name;
    }

    // Method to compare objects of Customer class.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name);
    }

    // Method to get hash code of an object Customer.
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // Method to print Customers appropriate.
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

// Class to implement comparator for class Customer.
class CustomerComparator implements Comparator<Customer> {

    // Method compare().
    @Override
    public int compare(Customer c1, Customer c2) {

        int result = c2.getId() - c1.getId();

        // Return statement.
        return result;

    }
}