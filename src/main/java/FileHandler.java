import java.io.File;

public class FileHandler{
    private File[] listOfFiles;

    public FileHandler(){ // returns list of files if no file name is specified

        File files = new File("data");
        this.listOfFiles = files.listFiles();

        if(listOfFiles == null){
            System.out.println("No files found in the directory.");
            this.listOfFiles = new File[0];
            return; // edge case
        }

    }

    public File fileHandler(int key, String fileName){
        try {
            File f = new File("data/" + fileName); // finds correct file, creates reference pointer
            if(f.exists()){
                System.out.println("File found: " + f.getName());
                return f;
                } 
            }
        catch (Exception e) {
            System.out.println("File not found: " + fileName);
        }
        return null;
    }

    public File[] getListOfFiles() {
        return this.listOfFiles;
    }
}
