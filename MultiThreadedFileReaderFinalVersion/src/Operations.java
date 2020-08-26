import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

    private String Filepath;
    private String data;
    private ArrayList <String> DataList = new ArrayList();
    private String Color;
    private String Destination;

    public void FolderReader(String dirPath){
        File dir = new File(dirPath);
        String[] files = dir.list();
        ArrayList<File> list = new ArrayList<>();
        System.out.println(dir.getPath());
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (String aFile : files) {
                System.out.println(aFile);
            }
        }

    }


    public String[] GetFilePaths(String dirPath){
        File dir = new File(dirPath);
        String[] files = dir.list();
        //String[] FilesPaths = dir.list();
        ArrayList<String> FilePaths = new ArrayList<>();
        String FolderPath = dir.getPath();
        String FilePath = "";
        if (files.length == 0) {
            System.out.println("The directory is empty");
        } else {
            for (String aFile : files) {
                FilePath = aFile;
                System.out.println(FilePath);
                FilePaths.add(FolderPath+"/"+FilePath);
            }
        }
        System.out.println(FilePaths.toString());
        return FilePaths.toArray(String[]::new);
    }

    public String getData(){
        return data;
    }


    public void Read(String FilePath){
        data = "";
        this.Filepath = FilePath;
        System.out.println("Reading Data...");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(Filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Closing File");
        }
        while (scanner.hasNext()){
            data = data + scanner.next();
        }
        System.out.println("Completed Reading Data!");
        DataList.add(data);
    }

    public ArrayList getDatalist(){
        return DataList;
    }

    public void Write(String destination, String data){
        FileWriter locFile = null;
        try {
            locFile = new FileWriter(destination);
            System.out.println("Writing Data To : " + destination);
            locFile.write(data);
        } catch(IOException e) {
            System.out.println("In catch block for file: " + destination);
            e.printStackTrace();
        } finally {
            System.out.println("in finally block for file: " + destination);
            try {
                if(locFile != null) {
                    System.out.println("Attempting to close file: " + destination);
                    locFile.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String PathCreator(String FileName, String DirPath){
        String FinalPath = DirPath + "/" + FileName;
        return FinalPath;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void Copy(){
        System.out.println(Color + "Reading Data...");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(Filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Color + "Closing File ");
        }
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            data = data + scanner.next();
        }
        System.out.println(Color + "Completed Reading Data!");


        FileWriter locFile = null;
        try {
            locFile = new FileWriter(Destination);
            System.out.println("Writng Data");
            locFile.write(data);
        } catch(IOException e) {
            System.out.println("In catch block");
            e.printStackTrace();
        } finally {
            System.out.println("in finally block");
            try {
                if(locFile != null) {
                    System.out.println("Attempting to close " + Destination);
                    locFile.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }



    }

}
