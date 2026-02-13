/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        ProgramControl controller = new ProgramControl();
        if (args.length == 0) {
            controller.displayFileMenu();
        }

        else if (args.length == 1 || args.length == 2) {
            String filename = args[0];
            controller.displayFileContents(filename);
        }

        else {
            System.out.println("Invalid number of arguments passed.");
        }
    }
}
