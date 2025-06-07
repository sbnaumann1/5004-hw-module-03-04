import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import student.Builder;

public class TestBuilder {
    String testCSV = "E001,50000.00,SALARY,100000.00,20000.00,600.00\n" +
                    "E002,20.00,HOURLY,30000.00,5000.00,400.00\n";

    String illegalCSV0 = "E001,50000.00,SALARY,100000.00,20000.00\n" +
                    "E002,20.00,HOURLY,30000.00,5000.00,400.00\n";

    String illegalCSV1 = "wlksdjklshglskg";
    String illegalCSV2 = "wlks,dj,kls,hg,lskg";

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


    // @Test
    // public void testBuilderFromCSV() {
    //     assertEquals(buildEmployeeFromCSV(testCSV);
    // }

}
