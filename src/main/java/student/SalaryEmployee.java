package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends Employee {
    // Fields inherited from Employee

    public SalaryEmployee(
        String name, 
        String id, 
        double payRate, 
        double ytdEarnings, 
        double ytdTaxesPaid, 
        double pretaxDeductions
    ) {
        super(name, id, payRate, "SALARY", ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    /**
     * 
     */
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null; // Skip if less than 0 hours
        } else if (hoursWorked == 0){
            return new PayStub(this, 0.0, 0.0); // No pay for zero hours
        }
        // TODO: Implement the payroll calculation for hourly employees
        BigDecimal grossPay = BigDecimal.valueOf(payRate).divide(BigDecimal.valueOf(24), 6, RoundingMode.HALF_UP); // Salary divided by 24
        BigDecimal taxes = grossPay.subtract(BigDecimal.valueOf(pretaxDeductions)).multiply(BigDecimal.valueOf(taxRate)); // 22.65% tax rate
        BigDecimal netPay = grossPay.subtract(taxes).subtract(BigDecimal.valueOf(pretaxDeductions));

        ytdEarnings += netPay.doubleValue();
        ytdTaxesPaid += taxes.doubleValue();

        // Create a PayStub for this employee
        payStub = new PayStub(
            this,
            netPay.doubleValue(),
            taxes.doubleValue()
        );

        return payStub; 
    }
}
