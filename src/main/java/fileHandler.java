import java.io.File;

public class FileHandler{
    private File[] listOfFiles;

    public void fileHandler(){ // returns list of files if no file name is specified

        File files = new File("src/data");
        this.listOfFiles = files.listFiles();

        if(listOfFiles == null){
            System.out.println("No files found in the directory.");
            this.listOfFiles = new File[0];
            return; // edge case
        }
        
        for (File f : listOfFiles) {
            System.out.println(f.getName()); // prints out the name of each file to our ArrayList<String>
        }
    }

    public File fileHandler(int key, String fileName){
        try {
            File f = new File(fileName); // finds correct file, creates reference pointer
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

