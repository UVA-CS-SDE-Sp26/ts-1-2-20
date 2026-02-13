import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CipherTest
{
    private final String REF = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private final String KEY = "bcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890a";

    @Test
    public void testValidDecryption() {
        Cipher cipher = new Cipher(REF, KEY);
        assertEquals("dog", cipher.decipher("eph"));
    }

    @Test   //test special chars
    public void testSpecialCharactersIgnored() {
        Cipher cipher = new Cipher(REF, KEY);
        assertEquals("dog! dog", cipher.decipher("eph! eph"));
    }

    @Test   //test throw exception, use lambda because asserts has only 1 function, functional programming
    public void testDuplicateKeyThrowsError() {
        // This checks if the code INSIDE the lambda () -> { } throws the error
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("abc", "aba");
        });
    }

    @Test
    public void testLengthMismatchThrowsError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("abc", "ab");
        });
    }
}
