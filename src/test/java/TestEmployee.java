import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.Employee;


/**
 * Unit tests for the Employee class.
 */
public class TestEmployee {
    Employee employee_bill;
    Employee employee_jane;



    /**
     * Setup some test instances of the Employee class.
     */
    @BeforeEach
    public void setUp() {
        employee_bill = new Employee("Bill", "E001", 50000, "SALARY", 100000, 20000, 600);
        employee_jane = new Employee("Jane", "E002", 20, "HOURLY", 30000, 5000, 400);
    }

    // TODO: This method should return a multiline CSV of all the paystubs not just the first line of details
    /**
     * Test toCSV() method
     */
    @Test
    public void testToCSV() {
        assertEquals("Bill,E001,50000.00,SALARY,100000.00,20000.00,600.00", employee_bill.toCSV());
        assertEquals("Jane,E002,20.00,HOURLY,30000.00,5000.00,400.00", employee_jane.toCSV());
    }

    /**
     * Test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("Employee{name='Bill', id='E001', payRate=50000.00, employeeType='SALARY', ytdEarnings=100000.00, ytdTaxesPaid=20000.00, pretaxDeductions=600.00}", employee_bill.toString());
        assertEquals("Employee{name='Jane', id='E002', payRate=20.00, employeeType='HOURLY', ytdEarnings=30000.00, ytdTaxesPaid=5000.00, pretaxDeductions=400.00}", employee_jane.toString());   
    }

    // Test Employee construction and getters

    /**
     * Test getName() 
     */
    @Test
    public void testGetName() {
        assertEquals("Bill", employee_bill.getName());
        assertEquals("Jane", employee_jane.getName());
    }

    /**
     * Test getID()
     */
    @Test
    public void testGetID() {
        assertEquals("E001", employee_bill.getID());
        assertEquals("E002", employee_jane.getID());   
    }

    /**
     * Test getPayRate()
     */
    @Test
    public void testGetPayRate() {
        assertEquals(50000, employee_bill.getPayRate());
        assertEquals(20, employee_jane.getPayRate());
    }

    /**
     * Test getEmployeeType()
     */
    @Test
    public void testGetEmployeeType() {
        assertEquals("SALARY", employee_bill.getEmployeeType());
        assertEquals("HOURLY", employee_jane.getEmployeeType());
    }
    
    /**
     * Test getYTDEarnings()
     */
    @Test
    public void testGetYTDEarnings() {
        assertEquals(100000, employee_bill.getYTDEarnings());
        assertEquals(30000, employee_jane.getYTDEarnings());
    }

    /**
     * Test getYTDTaxesPaid()
     */
    @Test
    public void testGetYTDTaxesPaid() {
        assertEquals(20000, employee_bill.getYTDTaxesPaid());
        assertEquals(5000, employee_jane.getYTDTaxesPaid());
    }

    /**
     * Test getPretaxDeductions()
     */
    @Test
    public void testGetPretaxDeductions() {
        assertEquals(600, employee_bill.getPretaxDeductions());
        assertEquals(400, employee_jane.getPretaxDeductions());
    }


}
