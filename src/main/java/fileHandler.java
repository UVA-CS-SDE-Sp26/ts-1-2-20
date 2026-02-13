import java.io.File;

public class fileHandler{
    private File[] listOfFiles;

    public fileHandler(){ // returns list of files if no file name is specified
        
        File files = new File("src/data");
        this.listOfFiles = files.listFiles();

        if(listOfFiles == null){
            System.out.println("No files found in the directory.");
            return; // edge case
        }
        
        for (File f : listOfFiles) {
            System.out.println(f.getName()); // prints out the name of each file to our ArrayList<String>
        }
    }

    public File fileHandler(int key, String fileName){
        try {
            File f = new File("src/data/" + fileName); // finds correct file, creates reference pointer
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
}   

