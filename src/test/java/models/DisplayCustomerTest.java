package models;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.example.assignment1_20104720.DisplayCustomerList;
import org.example.assignment1_20104720.TheatreCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayCustomerTest {
    private DisplayCustomerList customerList;
    private TheatreCustomer customer1;
    private TheatreCustomer customer2;

    @BeforeEach
    void setUp() {
        customerList = new DisplayCustomerList();
        customer1 = new TheatreCustomer("Alice", "alice@example.com", "1234567890");
        customer2 = new TheatreCustomer("Bob", "bob@example.com", "0987654321");
    }

    @Test
    void testAddTheatreCustomer() {
        customerList.addTheatreCustomer(customer1);
        assertNotNull(customerList.head);
        assertEquals(customer1, customerList.head.contents);

        customerList.addTheatreCustomer(customer2);
        assertEquals(customer2, customerList.head.contents);
        assertEquals(customer1, customerList.head.nextNode.contents);
    }

    @Test
    void testRemoveTheatreCustomer() {
        // Add customer1 and customer2 to the list
        customerList.addTheatreCustomer(customer1);
        customerList.addTheatreCustomer(customer2);

        // Attempt to delete customer1 (expected to be in the list)
        boolean success = customerList.deleteTheatreCustomer(customer1);
        assertTrue(success, "Customer1 should be successfully deleted.");

        // After deleting customer1, customer2 should be the head of the list
        assertNotNull(customerList.head, "List head should not be null.");
        assertEquals(customer2, customerList.head.contents, "Head should now be customer2.");
        assertNull(customerList.head.nextNode, "Customer2 should be the only element in the list.");

        // Attempt to delete customer2
        success = customerList.deleteTheatreCustomer(customer2);
        assertTrue(success, "Customer2 should be successfully deleted.");

        // After deleting customer2, the list should be empty
        assertNull(customerList.head, "List should now be empty.");

        // Attempt to delete customer2 again (it should return false, as customer2 no longer exists)
        success = customerList.deleteTheatreCustomer(customer2);
        assertFalse(success, "Deleting customer2 again should return false.");
    }


}
