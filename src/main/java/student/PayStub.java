package student;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A PayStub is created by a combination of information from Employee and
 * TimeCard.
 */
public class PayStub implements IPayStub {
    /** Employee associated with this PayStub. */
    private Employee employee; 
    /** Net pay for this pay period. */
    private final double netPay;
    /** Net taxes paid for this pay period. */
    private final double netTaxesPaid;
    /** Standard decimal formatting. */
    private final DecimalFormat df = new DecimalFormat("0.0#"); // Elimnate trailing zeros in decimal output

    /**
     * Constructor for PayStub.
     * 
     * @param employee      The Employee object associated with this pay stub.
     * @param netPay       The net pay for this pay period.
     * @param netTaxesPaid The net taxes paid for this pay period.
     */
    public PayStub(
            Employee employee,
            double netPay,
            double netTaxesPaid) {
        this.employee = employee;
        this.netPay = netPay;
        this.netTaxesPaid = netTaxesPaid;
        df.setRoundingMode(RoundingMode.HALF_UP); // Round to nearest cent

    }

    // Getters and Setters Below
    @Override
    public double getPay() {
        return netPay;
    }

    @Override
    public double getTaxesPaid() {
        return netTaxesPaid;
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%s", employee.getName(), df.format(netPay), df.format(netTaxesPaid),
                df.format(employee.getYTDEarnings()), df.format(employee.getYTDTaxesPaid()));
        // return String.format("%s,%.2f,%.2f,%.2f,%.2f", employeeName, netPay,
        // netTaxesPaid, ytdPay, ytdTaxesPaid);
    }

}
