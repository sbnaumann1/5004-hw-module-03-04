package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A SalaryEmployee is a type of Employee that is paid a fixed salary regardless of hours worked.
 * It extends the Employee class and implements payroll calculations specific to salaried employees.
 */
public class SalaryEmployee extends Employee {
    // Fields inherited from Employee

    public SalaryEmployee(
            String name,
            String id,
            double payRate,
            double ytdEarnings,
            double ytdTaxesPaid,
            double pretaxDeductions) {
        super(name, id, payRate, "SALARY", ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    /**
     *
     */
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null; // Skip if less than 0 hours
        } else if (hoursWorked == 0) {
            return new PayStub(this, 0.0, 0.0); // No pay for zero hours
        }
        BigDecimal grossPay = BigDecimal.valueOf(getPayRate()).divide(BigDecimal.valueOf(24), 6, RoundingMode.HALF_UP);
        BigDecimal taxes = grossPay.subtract(BigDecimal.valueOf(getPretaxDeductions()))
                .multiply(BigDecimal.valueOf(taxRate)); // 22.65% tax rate
        BigDecimal netPay = grossPay.subtract(taxes).subtract(BigDecimal.valueOf(getPretaxDeductions()));

        setYTDEarnings(getYTDEarnings() + netPay.doubleValue());
        setYTDTaxesPaid(getYTDTaxesPaid() + taxes.doubleValue());

        // Create a PayStub for this employee
        payStub = new PayStub(
                this,
                netPay.doubleValue(),
                taxes.doubleValue());

        return payStub;
    }
}
