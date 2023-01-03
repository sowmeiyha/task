import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String args[]) throws IOException {
        String folderName="";
        String path="";
        File directoryPath = new File("C:\\Users\\sowmeiyhap\\Documents\\Files");
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".pdf") || lowercaseName.endsWith(".txt")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        FilenameFilter audioFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".mp3")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        FilenameFilter videoFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".mp4")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        String textFilesList[] = directoryPath.list(textFilter);
        if(textFilesList.length>=1){
              path="C:\\Users\\sowmeiyhap\\Documents\\Files\\";
              folderName="document";
              path = path+folderName;
            File file = new File(path);
            file.mkdir();

        }

        for (String fileName : textFilesList) {

            Path temp = Files.move
                    (Paths.get("C:\\Users\\sowmeiyhap\\Documents\\Files\\"+fileName),
                            Paths.get(path+"\\"+fileName));


        }

        String audioFilesList[] = directoryPath.list(audioFilter);
        if(audioFilesList.length>=1){
            path="C:\\Users\\sowmeiyhap\\Documents\\Files\\";
            folderName="audio";
            path = path+folderName;
            File file = new File(path);
            file.mkdir();
        }

        for (String fileName : audioFilesList) {

            Path temp = Files.move
                    (Paths.get("C:\\Users\\sowmeiyhap\\Documents\\Files\\"+fileName),
                            Paths.get(path+"\\"+fileName));
        }

        String videoFilesList[] = directoryPath.list(videoFilter);
        if(videoFilesList.length>=1){
            path="C:\\Users\\sowmeiyhap\\Documents\\Files\\";
            folderName="video";
            path = path+folderName;
            File file = new File(path);
            file.mkdir();

        }
        for (String fileName : videoFilesList) {
                Path temp = Files.move
                        (Paths.get("C:\\Users\\sowmeiyhap\\Documents\\Files\\"+fileName),
                                Paths.get(path+"\\"+fileName));
            }

        }
}

