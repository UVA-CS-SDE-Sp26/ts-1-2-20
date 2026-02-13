import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramControlTest {

    @Test
    void displayFileMenu() {
        ProgramControl pc = new ProgramControl();
        pc.displayFileMenu();
    }

    @Test
    void displayFileContents() {
        ProgramControl pc = new ProgramControl();
        pc.displayFileContents(1);
    }
}