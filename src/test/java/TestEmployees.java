/**
 * 
 * DEPRECATED now that this class is abstract.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.HourlyEmployee;
import student.SalaryEmployee;


/**
 * Unit tests for the Employee class.
 */
public class TestEmployees {
    SalaryEmployee employee_bill;
    HourlyEmployee employee_jane;
    SalaryEmployee employee_doe;



    /**
     * Setup some test instances of the Employee class.
     */
    @BeforeEach
    public void setUp() {
        employee_bill = new SalaryEmployee("Bill", "E001", 50000.0, 100000.0, 20000.0, 600.0);
        employee_jane = new HourlyEmployee("Jane", "E002", 20.0, 30000.0, 5000.0, 400.0);
        employee_doe = new SalaryEmployee("John Doe", "12345", 10, 0, 0, 0);
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

    /*
     * Test runPayroll() for both Salary and Hourly Employees
     */
    @Test
    public void testRunPayrollEmployees() {
        // Test salary employee
        // Test with 0 hours worked
        assertEquals(0, employee_bill.runPayroll(0).getPay());
        // Test with negative hours worked
        assertEquals(null, employee_bill.runPayroll(-5));
        // Test 35 hours with full PayStub CSV : employee_name,net_pay,taxes,ytd_earnings,ytd_taxes_paid
        assertEquals("Bill,1011.46,471.87,101011.46,20471.87", employee_bill.runPayroll(35).toCSV());

        // Test hourly employee
        // Test with 0 hours worked
        assertEquals(0, employee_jane.runPayroll(0).getPay());
        // Test with negative hours worked
        assertEquals(null, employee_jane.runPayroll(-5));
        // Test with 35 hours worked
        assertEquals(541.45, employee_jane.runPayroll(35).getPay(), 0.01);
        // Test with 45 hours worked (overtime)
        assertEquals(734.82, employee_jane.runPayroll(45).getPay(), 0.01);

    }

}
