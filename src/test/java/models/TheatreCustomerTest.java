package models;

import org.example.assignment1_20104720.TheatreCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TheatreCustomerTest {
    private TheatreCustomer validTheatreCustomer;

    @BeforeEach
    void setUp() {
        validTheatreCustomer = new TheatreCustomer("Yi Jie", "yijie.lim@gmail.com","0834211475");
    }

    @Nested
    class Constructor {
        @Test
        void testConstructor() {
            TheatreCustomer customer = new TheatreCustomer("Peter", "peter@gmail.com", "0892533397");
            assertEquals("Peter", customer.getName());
            assertEquals("peter@gmail.com", customer.getEmailAddress());
            assertEquals("0892533397", customer.getPhoneNumber());
        }
    }


    @Nested
    class GettersAndSetters {
        @Test
        void testGetAndSetName() {
            validTheatreCustomer.setName("YiJie"); // valid - just below upper boundary
            assertEquals("YiJie", validTheatreCustomer.getName());
            validTheatreCustomer.setName("Peter");
            assertEquals("Peter", validTheatreCustomer.getName());
            validTheatreCustomer.setName("Harry");
            assertEquals("Harry", validTheatreCustomer.getName());
        }

        @Test
        void testGetAndSetEmailAddress() {
            validTheatreCustomer.setEmailAddress("yijie.lim@gmail.com"); // valid - just below upper boundary
            assertEquals("yijie.lim@gmail.com", validTheatreCustomer.getEmailAddress());
            validTheatreCustomer.setName("peter@gmail.com");
            assertEquals("peter@gmail.com", validTheatreCustomer.getName());
            validTheatreCustomer.setName("harry@gmail.com");
            assertEquals("harry@gmail.com", validTheatreCustomer.getName());
        }

        @Test
        void testGetAndSetPhoneNumber() {
            validTheatreCustomer.setPhoneNumber("0843214567"); // valid - just below upper boundary
            assertEquals("0843214567", validTheatreCustomer.getPhoneNumber());
            validTheatreCustomer.setPhoneNumber("0897654321");
            assertEquals("0897654321", validTheatreCustomer.getPhoneNumber());
            validTheatreCustomer.setPhoneNumber("0137886980");
            assertEquals("0137886980", validTheatreCustomer.getPhoneNumber());
        }
    }

   @Nested
   class ToString {
       @Test
       void testToString() {
           // Create TheatreCustomer instance
           TheatreCustomer validCustomer = new TheatreCustomer("Yi Jie", "yijie@gmail.com", "0834211475");
           // Check if the toString output contains each expected field value with single quotes
           assertTrue(validCustomer.toString().contains("name='Yi Jie'"));
           assertTrue(validCustomer.toString().contains("emailAddress='yijie@gmail.com'"));
           assertTrue(validCustomer.toString().contains("phoneNumber='0834211475'"));
       }
   }


}
