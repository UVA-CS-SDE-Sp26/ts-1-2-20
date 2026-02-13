import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FileHandlerTest {

    @Test
    public void createsFileList() {
        FileHandler fh = new FileHandler();
        Assertions.assertNotNull(fh.getListOfFiles());
    }
}

                                


