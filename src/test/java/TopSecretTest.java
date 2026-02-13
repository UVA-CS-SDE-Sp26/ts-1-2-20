import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TopSecretTest {
    @Test
    void noArgumentTest() {
        TopSecret.main(new String[] {});
    }

    @Test
    void validSingleArgumentTest() {
        TopSecret.main(new String[] {"1"});
    }

    @Test
    void invalidIntegerArgumentTest1() {
        TopSecret.main(new String[] {"1a"});
        assertThrows(NumberFormatException.class, () -> Integer.parseInt("1a"));
    }

    @Test
    void invalidIntegerArgumentTest2() {
        TopSecret.main(new String[] {"-5"});
    }

    @Test
    void invalidIntegerArgumentTest3() {
        TopSecret.main(new String[] {"0"});
    }

    @Test
    void validSecondArgumentTest() {
        TopSecret.main(new String[] {"1", "alternateKeyFile.txt"});
    }

    @Test
    void invalidSecondArgumentTest() {
        TopSecret.main(new String[] {"1", "alternateKeyFile.t"});
    }

    @Test
    void invalidNumberOfArgumentsTest() {
        TopSecret.main(new String[] {"2", "alternateKeyFile.txt", "3"});
    }
}
