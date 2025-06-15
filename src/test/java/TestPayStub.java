

/*
 * Generate tests for the PayStub class.
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.PayStub;
import student.SalaryEmployee;

public class TestPayStub {
    SalaryEmployee testEmployee;
    PayStub testStub;

    /*
     * Set up test instances of the PayStub class for testing
     */
    @BeforeEach
    public void setUp() {
        // Initialize test instances of PayStub here if needed
        testEmployee = new SalaryEmployee("Test Employee", "E001", 50000.0, 100000.0, 20000.0, 600.0);
        testStub = new PayStub(testEmployee, 100, 10);
    }

    /**
     * Test the getPay() method of PayStub.
     */
    @Test
    public void testGetPay() {
        assertEquals(100, testStub.getPay(), "The pay should be 100");
    }

    /**
     * Test the getTaxesPaid() method of PayStub.
     */
    @Test
    public void testGetTaxesPaid() {
        assertEquals(10, testStub.getTaxesPaid(), "The taxes paid should be 10");
    }

    /**
     * Test the toCSV() method of PayStub.
     */
    @Test
    public void testToCSV() {
        String expectedCSV = "Test Employee,100.0,10.0,100000.0,20000.0";
        assertEquals(expectedCSV, testStub.toCSV(), "The CSV output should match the expected format");
    }
}
