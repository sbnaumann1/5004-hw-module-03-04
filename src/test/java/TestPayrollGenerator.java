/*
 * Students, build off this class. We are providing one sample test case as file reading is new to
 * you.
 * 
 * NOTE: you may end up changing this completely depending on how you setup your project.
 * 
 * we are just using .main() as we know that is an entry point that we specified.
 * 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import student.PayrollGenerator;

public class TestPayrollGenerator {

    @TempDir
    static Path tempDir;


    @Test
    public void testFinalPayStub() throws IOException {
        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees, StandardCopyOption.REPLACE_EXISTING);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);


        // you could also read lines and compared the lists


    }

    @Test
    public void testFinalEmployeeCSV() throws IOException{

        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees, StandardCopyOption.REPLACE_EXISTING);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);
    }

    /*
     * 
     * Test badCSV File Reading
     */
    @Test
    public void testBadCSVFileReadingEmployee() throws IOException {
        // This test is to ensure that the PayrollGenerator handles bad CSV files.

        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees_test.csv");
        Files.copy(Paths.get("resources/employees_test.csv"), employees, StandardCopyOption.REPLACE_EXISTING);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        assertThrows(IllegalArgumentException.class, () -> {
            PayrollGenerator.main(args);
        });
    }


    /*
     * 
     * Test bad time card file reading
     */
    @Test
    public void testBadCSVFileReadingTimeCard() throws IOException {
        // This test is to ensure that the PayrollGenerator handles bad CSV files.

        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees, StandardCopyOption.REPLACE_EXISTING);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards_test1.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        assertThrows(IllegalArgumentException.class, () -> {
            PayrollGenerator.main(args);
        });
    }


    /**
     * 
     * Test some alternative employees and outcomes 
     */
    @Test
    public void testFinalEmployeeCSV2() throws IOException{

        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees2.csv");
        Files.copy(Paths.get("resources/employees2.csv"), employees, StandardCopyOption.REPLACE_EXISTING);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards_short.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/pay_stubs_solution_to_original_diffEmp.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);
    }


    /**
     * 
     * Test some alternative time cards and outcomes
     */
    @Test
    public void testFinalTimeCard3() throws IOException{

        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees_short.csv");
        Files.copy(Paths.get("resources/employees_short.csv"), employees, StandardCopyOption.REPLACE_EXISTING);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards2.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/pay_stubs_solution_to_original_diffTime.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);
    }
}
