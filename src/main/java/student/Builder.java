package student;

/**
 * This is a static class (essentially functions) that will help you build
 * objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders
 * are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }

    /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at
     * the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        // Ensure csv not empty
        if (csv == null || csv.isEmpty()) {
            return null; // Invalid input
        }
        String[] csvSplit = csv.split(",");
        if (csvSplit.length != 7) {
            throw new IllegalArgumentException("Invalid CSV format for employee: " + csv);
        }
        // Parse the CSV string into its components
        String name = csvSplit[1];
        String id = csvSplit[2];
        double payRate;
        double pretaxDeductions;
        double ytdEarnings;
        double ytdTaxesPaid;
        try {
            payRate = Double.parseDouble(csvSplit[3]);
            pretaxDeductions = Double.parseDouble(csvSplit[4]);
            ytdEarnings = Double.parseDouble(csvSplit[5]);
            ytdTaxesPaid = Double.parseDouble(csvSplit[6]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("CSV formatted incorrectly to get double values for data: " + csv, e);
        }
        
        // Ensure that all numeric values are positive
        if (payRate < 0 || pretaxDeductions < 0 || ytdEarnings < 0 || ytdTaxesPaid < 0) {
            throw new IllegalArgumentException("Negative values found in CSV: " + csv);
        }

        // Check if the first element of csv string is HOURLY or SALARY
        if ("HOURLY".equals(csvSplit[0])) {
            return new HourlyEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        } else if ("SALARY".equals(csvSplit[0])) {
            return new SalaryEmployee(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        } else {
            throw new IllegalArgumentException("Invalid employee type in CSV: " + csvSplit[0]);
        }

    }

    /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        // Ensure csv not empty
        if (csv == null || csv.isEmpty()) {
            return null; // Invalid input
        }
        String[] csvSplit = csv.split(",");
        if (csvSplit.length != 2) {
            throw new IllegalArgumentException("Invalid CSV format for employee: " + csv);
        }

        String employeeId = csvSplit[0];
        double hoursWorked = Double.parseDouble(csvSplit[1]);

        return new TimeCard(employeeId, hoursWorked);
    }
}
