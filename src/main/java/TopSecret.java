/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        ProgramControl controller = new ProgramControl();
        int fileNumber;

        if (args.length > 2) {
            System.out.println("Invalid number of arguments passed");
            return;
        }

        else if (args.length == 0) {
            controller.displayFileMenu();
            return;
        }

        try{
            fileNumber = Integer.parseInt(args[0]);
            controller.displayFileContents(fileNumber);
        } catch (NumberFormatException e){
            System.out.println("Invalid fileNumber");
            return;
        }

        if (args.length == 2) {
            try {
                controller = new ProgramControl(args[1]);
            } catch (RuntimeException e) {
                System.out.println("Invalid cipher key");
                return;
            }
        }
    }
}
