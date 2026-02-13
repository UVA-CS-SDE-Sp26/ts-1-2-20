import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TopSecretTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void noArgumentTest() {
        TopSecret.main(new String[] {});
        String output = outputStream.toString();
        assertTrue(output.contains("Available Files:"));
    }

    @Test
    void validSingleArgumentTest() {
        TopSecret.main(new String[] {"2"});
        String output = outputStream.toString();
        assertTrue(output.contains("Carnivore, later renamed DCS1000"));
    }

    @Test
    void invalidIntegerArgumentTest1() {
        TopSecret.main(new String[] {"1a"});
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("1a"));
    }

    @Test
    void invalidIntegerArgumentTest2() {
        TopSecret.main(new String[] {"-5"});
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid file number passed"));
    }

    @Test
    void invalidIntegerArgumentTest3() {
        TopSecret.main(new String[] {"0"});
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid file number passed"));
    }

    @Test
    void validSecondArgumentTest() {
        TopSecret.main(new String[] {"1", "alternateKey.txt"});
        String output = outputStream.toString();
        assertTrue(output.contains("THIS IS A SECRET MESSAGE ENCRYPTED WITH THE ALTERNATE KEY."));
    }

    @Test
    void invalidSecondArgumentTest() {
        TopSecret.main(new String[] {"1", "alternateKey.t"});
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid cipher key"));
    }

    @Test
    void invalidNumberOfArgumentsTest() {
        TopSecret.main(new String[] {"2", "alternateKey.txt", "3"});
        String output = outputStream.toString();
        assertTrue(output.contains("Invalid number of arguments passed"));
    }
}
