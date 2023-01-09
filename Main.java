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
    //function to print filename in report
    public static String fileReport(String fname){
        String file = fname;

        String fileNameWithoutExtension = file.substring(0, file.lastIndexOf('.'));
        return fileNameWithoutExtension;
    }

    //function to print extensions in report
    public static String extensions(String fname)throws IOException {
        String file = fname.toString();
        int index = file.lastIndexOf('.');
        if (index > 0) {
            String extension = file.substring(index + 1);
            return extension;
        }
        return null;
    }
    //C:\Users\sowmeiyhap\Documents\Files
    //C:\Users\sowmeiyhap\Documents\report.txt
    public static void main (String args[]) throws IOException {

            String folderName="";
            String path = "";
            String repo= "";
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String directory=sc.nextLine();

            File directoryPath = new File(directory);
            System.out.println(directoryPath);
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
                path = directory+"\\";
                folderName="document";
                path = path + folderName;
                File textFile = new File(path);
                textFile.mkdir();
            }
            for (String fileName : textFilesList) {
                pathName(fileName, folderName, path);
                repo=repo+fileReport(fileName)+"\t"+extensions(fileName)+"\t"+folderName+"\n";
            }
            String audioFilesList[] = directoryPath.list(audioFilter);
            if (audioFilesList.length >= 1) {
                path = directory+"\\";
                folderName="audio";
                path = path + folderName;
                File audioFile = new File(path);
                audioFile.mkdir();

            }
            for (String fileName : audioFilesList) {
                pathName(fileName, folderName, path);
                repo=repo+fileReport(fileName)+"\t"+extensions(fileName)+"\t"+folderName+"\n";

            }
            String videoFilesList[] = directoryPath.list(videoFilter);
            if (videoFilesList.length >= 1) {
                path = directory+"\\";
                folderName="video";
                path = path + folderName;
                File videoFile = new File(path);
                videoFile.mkdir();
            }
            for (String fileName : videoFilesList) {
                pathName(fileName, folderName, path);
                repo=repo+fileReport(fileName)+"\t"+extensions(fileName)+"\t"+folderName+"\n";


            }

            System.out.println("Enter the path for report.txt");
            String reportPath=sc.nextLine();


            try {
                FileWriter reportWrite = new FileWriter(reportPath);
                reportWrite.write(repo);
                reportWrite.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }



