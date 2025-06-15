/*
 * Generate tests for the TimeCard class.
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.TimeCard;

public class TestTimeCard {
    TimeCard testCard;

    /*
     * Set up test instances of the TimeCard class for testing
     */
    @BeforeEach
    public void setUp() {
        // Initialize test instances of PayStub here if needed
        testCard = new TimeCard("E001", 10);
    }


    /**
     * Test the getEmployeeID() method of TimeCard.
     */
    @Test
    public void testGetEmployeeID() {
        assertEquals("E001", testCard.getEmployeeID(), "The employee ID should be E001");
    }

    /**
     * Test the getHoursWorked() method of TimeCard.
     */
    @Test
    public void testGetHoursWorked() {
        assertEquals(10, testCard.getHoursWorked(), "The hours worked should be 10");
    }
}