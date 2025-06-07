package student;

import java.math.BigDecimal;

public class HourlyEmployee extends Employee {
    // Fields inherited from Employee

    public HourlyEmployee(
            String name,
            String id,
            double payRate,
            double ytdEarnings,
            double ytdTaxesPaid,
            double pretaxDeductions // TODO : Pretax deductions not used for hourly employees
    ) {
        super(name, id, payRate, "HOURLY", ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        if (pretaxDeductions != 0) {
            throw new IllegalArgumentException("Pretax deductions must be zero for hourly employees.");
        }
    }

    @Override
    /**
     * 
     */
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null; // Skipp if less than 0 hours
        } else if (hoursWorked > 40) {
            hoursWorked = 40 + (hoursWorked - 40) * 1.5; // Overtime pay for hours over 40
        } else if (hoursWorked == 0) {
            return new PayStub(this, 0.0, 0.0); // No pay for zero hours
        }
        BigDecimal grossPay = BigDecimal.valueOf(hoursWorked).multiply(BigDecimal.valueOf(getPayRate()));
        BigDecimal taxes = grossPay.multiply(BigDecimal.valueOf(taxRate)); // 22.65% tax rate
        BigDecimal netPay = grossPay.subtract(taxes);

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
