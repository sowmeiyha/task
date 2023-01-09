import java.io.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class Main {
    //function for moving file to directory
    public static void pathName(String fileName,String folderName,String path)throws IOException{
        Path temp = Files.move(Paths.get("C:\\Users\\sowmeiyhap\\Documents\\Files\\" + fileName),
                        Paths.get(path + "\\" + fileName));

    }
    public static void main (String args[]) throws IOException {

            String folderName="";
            String path = "";
            String repo= "";
            File directoryPath = new File("C:\\Users\\sowmeiyhap\\Documents\\Files");

            FilenameFilter textFilter = new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    String[] textArr = {".pdf", ".txt", ".doc", ".docx", ".rtf"};
                    String lowercaseName = name.toLowerCase();
                    for (int i = 0; i < textArr.length; i++) {
                        if (lowercaseName.endsWith(textArr[i])) {
                            return true;
                        }
                    }
                    return false;
                }

            };

        FilenameFilter audioFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String[] audioArr = {".mp3",".m4a"};
                String lowercaseName = name.toLowerCase();
                for (int i = 0; i < audioArr.length; i++) {
                    if (lowercaseName.endsWith(audioArr[i])) {
                        return true;
                    }
                }
                return false;
            }

        };
        FilenameFilter videoFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                String[] videoArr = {".mp4",".m4v",".mov",".webM"};
                String lowercaseName = name.toLowerCase();
                for (int i = 0; i < videoArr.length; i++) {
                    if (lowercaseName.endsWith(videoArr[i])) {
                        return true;
                    }
                }
                return false;
            }

        };
            String textFilesList[] = directoryPath.list(textFilter);
            if (textFilesList.length >= 1) {
                path = "C:\\Users\\sowmeiyhap\\Documents\\Files\\";
                folderName="document";
                path = path + folderName;
                File textFile = new File(path);
                textFile.mkdir();

            }
            for (String fileName : textFilesList) {
                pathName(fileName, folderName, path);
                repo=repo+folderName+fileName;


            }




            String audioFilesList[] = directoryPath.list(audioFilter);
            if (audioFilesList.length >= 1) {
                path = "C:\\Users\\sowmeiyhap\\Documents\\Files\\";
                folderName="audio";
                path = path + folderName;
                File audioFile = new File(path);
                audioFile.mkdir();

            }
            for (String fileName : audioFilesList) {
                pathName(fileName, folderName, path);
                repo=repo+folderName+fileName;


            }



           String videoFilesList[] = directoryPath.list(videoFilter);
            if (videoFilesList.length >= 1) {
                path = "C:\\Users\\sowmeiyhap\\Documents\\Files\\";
                folderName="video";
                path = path + folderName;
                File videoFile = new File(path);
                videoFile.mkdir();

            }
            for (String fileName : videoFilesList) {
                pathName(fileName, folderName, path);
                repo=repo+folderName+fileName;


            }
            try {
                FileWriter reportWrite = new FileWriter("C:\\Users\\sowmeiyhap\\Documents\\report.txt");
                reportWrite.write(repo);
                reportWrite.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }





        }
    }


