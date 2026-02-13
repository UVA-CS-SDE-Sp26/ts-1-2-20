import java.util.logging.FileHandler;



public class ProgramControl {
        private FileHandler fileHandler;

        public ProgramControl(FileHandler fileHandler) {
                this.fileHandler = fileHandler;

        }

        public void displayFileMenu(){
                System.out.println("Available Files:");
                List<String> files = fileHandler.listFiles();

                if (files.isEmpty()) {
                        System.out.println("No Files Found");
                        return;
                }

                for (int i=0;files.size();i++){
                        System.out.prinln((i+1)+"."+files.get(i));
                }



        }
        public void displayFileContents(String fileName){
                System.out.println("Reading file: "+fileName);

                String contents = fileHandler.readFile(fileName);
                System.out.println(contents);

        }
}
