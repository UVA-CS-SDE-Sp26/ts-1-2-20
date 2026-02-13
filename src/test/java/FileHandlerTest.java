import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileHandlerTest {

    @Test
    public void createsFileList() {
        FileHandler fh = new FileHandler();
        Assertions.assertNotNull(fh.getListOfFiles());
    }

    @Test
    void fileDoesNotExistReturnsNull() {
        FileHandler fh = new FileHandler();
        Assertions.assertNull(fh.fileHandler(0, "thisFileDoesNotExist.txt"));
    }

}

                                


