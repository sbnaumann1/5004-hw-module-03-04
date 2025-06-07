package student;

/**
 * TimeCard tracks an employess worked hours 
 * The Employee class is a composition that includes a TimeCard object. 
 * (It can go in Employee because there is no difference between SalaryEmployee and HourlyEmployee TimeCards)
 * 
 */
public class TimeCard implements ITimeCard {
    private final String employeeId;
    private final double hoursWorked;

    public TimeCard(String employeeId, double hoursWorked) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
    }

    // Getters for TimeCard
    @Override
    public String getEmployeeID() {
        return employeeId;
    }
    @Override
    public double getHoursWorked() {
        return hoursWorked; 
    }
}
