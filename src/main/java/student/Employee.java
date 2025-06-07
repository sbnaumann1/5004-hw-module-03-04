package student;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * An abstract class representing a generic Employee.
 */
abstract class Employee implements IEmployee {
    /** Employee's name. */
    private String name;
    /** Employee's ID. */
    private String id;
    /** Employee's pay rate. */
    private double payRate;
    /** Type of employee (e.g., hourly, salary). */
    private String employeeType;
    /** Year-to-date earnings. */
    private double ytdEarnings;
    /** Year-to-date taxes paid. */
    private double ytdTaxesPaid;
    /** Pretax deductions. */
    private double pretaxDeductions;
    /** Default tax rate for all employees. */
    private double taxRate = 0.2265; // 22.65% tax rate for all employees - This field is here in case future
                                     // iterations of the program want to change it.
    /** TimeCard for this employee. */
    private ITimeCard timeCard;
    /** PayStub for this employee. */
    private IPayStub payStub;
    /** Standard decimal formatting. */
    private final DecimalFormat df = new DecimalFormat("0.0#"); // Elimnate trailing zeros in decimal output

    Employee(
            String name,
            String id,
            double payRate,
            String employeeType,
            double ytdEarnings,
            double ytdTaxesPaid,
            double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.employeeType = employeeType;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
        df.setRoundingMode(RoundingMode.HALF_UP); // Round to nearest cent

    }

    /**
     * This method is a placeholder for the payroll calculation logic.
     * It should be overridden by subclasses like HourlyEmployee or SalaryEmployee.
     * 
     * @param hoursWorked The number of hours worked in the pay period.
     * @return An IPayStub object representing the pay stub for this employee.
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        // This method should be implemented in subclasses
        throw new UnsupportedOperationException("runPayroll implemented in subclasses");
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
            employeeType, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }

    @Override
    public String toString() {

        return String.format(
                "Employee{name='%s', id='%s', payRate=%s, " 
                +
                "employeeType='%s', ytdEarnings=%s, ytdTaxesPaid=%s, pretaxDeductions=%s}",
                name, id, df.format(payRate), employeeType, df.format(ytdEarnings), df.format(ytdTaxesPaid),
                df.format(pretaxDeductions));
        // return String.format("Employee{name='%s', id='%s', payRate=%.2f,
        // employeeType='%s', ytdEarnings=%.2f, ytdTaxesPaid=%.2f,
        // pretaxDeductions=%.2f}",
        // name, id, payRate, employeeType, ytdEarnings, ytdTaxesPaid,
        // pretaxDeductions);
    }

    // Getters and Setters Below

    public void setTimeCard(ITimeCard timeCard) {
        this.timeCard = timeCard;
    }

    public ITimeCard getTimeCard() {
        return timeCard;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public String getEmployeeType() {
        return employeeType;
    }

    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    public void setYTDEarnings(double ytdEarnings) {
        this.ytdEarnings = ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    public void setYTDTaxesPaid(double ytdTaxesPaid) {
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    public double getTaxRate() {
        return taxRate;
    }


    public IPayStub getPayStub() {
        return payStub;
    }

    public void setPayStub(IPayStub payStub) {
        this.payStub = payStub;
    }
}
