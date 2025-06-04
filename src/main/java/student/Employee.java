package student;

public class Employee implements IEmployee{
    private String name;
    private String id;
    private double payRate;
    private String employeeType;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;

    public Employee(
        String name, 
        String id, 
        double payRate, 
        String employeeType, 
        double ytdEarnings, 
        double ytdTaxesPaid,
        double pretaxDeductions
    ) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.employeeType = employeeType;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }


    @Override
    public IPayStub runPayroll(double hoursWorked){
        // TODO Auto-generated method stub
        return null;    
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%.2f,%s,%.2f,%.2f,%.2f", 
                name, id, payRate, employeeType, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String toString() {  
        return String.format("Employee{name='%s', id='%s', payRate=%.2f, employeeType='%s', ytdEarnings=%.2f, ytdTaxesPaid=%.2f, pretaxDeductions=%.2f}",
                name, id, payRate, employeeType, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }


    // Getters and Setters Below
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
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

}