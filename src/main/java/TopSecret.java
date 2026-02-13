/**
 * Commmand Line Utility
 */
public class TopSecret {
    public static void main(String[] args) {
        ProgramControl controller = new ProgramControl();
        if (args.length == 0) {
            controller.displayFileMenu();
            return;
        }

        try{
            int fileNumber = Integer.parseInt(args[0]);
            controller.displayFileContents(fileNumber);
        } catch (NumberFormatException e){
            System.out.println("Invalid fileNumber");
        }
    }
}
