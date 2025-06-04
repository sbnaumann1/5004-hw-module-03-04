package student;

public class HourlyEmployee extends Employee {
    // Fields inherited from Employee

    public HourlyEmployee(
        String name, 
        String id, 
        double payRate, 
        double ytdEarnings, 
        double ytdTaxesPaid, 
        double pretaxDeductions
    ) {
        super(name, id, payRate, "HOURLY", ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        // TODO: Implement the payroll calculation for hourly employees
        return
    {}

    
}
