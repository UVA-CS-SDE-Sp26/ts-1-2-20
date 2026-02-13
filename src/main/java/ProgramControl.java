import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;



public class ProgramControl {
        private FileHandler fileHandler;
        private Cipher cipher;

        public ProgramControl() {
                this.fileHandler = new FileHandler();
                this.cipher = loadCipher("ciphers/key.txt");


        }
        public ProgramControl(String keyFileName) {
                this.fileHandler = new FileHandler();
                this.cipher = loadCipher("ciphers/" + keyFileName);
        }
        private Cipher loadCipher(String keyFilePath){
                File keyFile = new File(keyFilePath);
            List<String> lines = null;
            try {
                lines = Files.readAllLines(keyFile.toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String referenceKey = lines.get(0);
                String cipherKey = lines.get(1);
                return new Cipher(referenceKey,cipherKey);
        }
        public void displayFileMenu(){
                System.out.println("Available Files:");
                File[] files = fileHandler.getListOfFiles();

                if (files == null || files.length == 0) {
                        System.out.println("No files found.");
                        return;
                }


                for (int i=0;i< files.length;i++){
                        System.out.println((i+1)+"."+files[i].getName());
                }



        }
        public void displayFileContents(int fileNumber){
                File[] files = fileHandler.getListOfFiles();
                if (files == null || files.length == 0) {
                        System.out.println("No files found.");
                        return;
                }
                if (fileNumber < 1 || fileNumber > files.length) {
                        System.out.println("Invalid file number passed.");
                        return;
                }
                File file = files[fileNumber-1];
                displayFile(file);


        }

        private void displayFile(File file){
                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                        StringBuilder content = new StringBuilder();
                        String line;
                        while((line = reader.readLine())!=null){
                                content.append(line).append("\n");
                        }
                        String fileContent = content.toString();
                        fileContent = cipher.decipher(fileContent);
                        System.out.println(fileContent);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
