import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import student.Builder;
import student.IEmployee;

public class TestBuilder {
    String testCSV = "SALARY,Nami,s193,200000,1000,17017,4983";

    String illegalCSV0 = "E001,50000.00,SALARY,100000.00,20000.00\n" +
            "E002,20.00,HOURLY,30000.00,5000.00,400.00\n";

    String illegalCSV1 = "wlksdjklshglskg";
    String illegalCSV2 = "wlks,dj,kls,hg,lskg";

    String illegalCSV3 = "John Doe,12345,100000.00,SALARY,1000.00,100.00,1000.00";

    IEmployee employee_nami;
    IEmployee employee_john_doe;

    @BeforeEach
    public void setUp() {
        // Any setup needed before each test can go here
        employee_nami = Builder.buildEmployeeFromCSV(testCSV);
        employee_john_doe = Builder.buildEmployeeFromCSV(illegalCSV3);
    }

    @Test
    void testBuilderFromCSVtooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildEmployeeFromCSV(illegalCSV0);
        });
    }

    @Test
    public void testBuilderFromCSVnoCommas() {
        assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildEmployeeFromCSV(illegalCSV1);
        });
    }

    @Test
    public void testBuilderFromCSVillegalFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildEmployeeFromCSV(illegalCSV2);
        });
    }

    @Test
    public void testBuilderFromCSVJohnDoe() {
        assertThrows(IllegalArgumentException.class, () -> {
            Builder.buildEmployeeFromCSV(illegalCSV3);
        });
    }

    @Test
    public void testBuilderFromCSV() {
        assertEquals("Nami", employee_nami.getName());
    }

    @Test
    public void testBuilderFromCSVJohnDoeGetName() {
        assertEquals("JohnDoe", employee_john_doe.getName());
    }

}
