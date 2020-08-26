import jdk.dynalink.Operation;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter A Dir: ");
        String UserInputDir = scanner.nextLine();
        Operations operations = new Operations();
//        operations.FolderReader("/home/arnavdadarya/IdeaProjects/MultiThreadedFileReaderFinalVersion/FilesForReaderProgram");

        operations.FolderReader(UserInputDir);

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter Destination dir: ");
        String destinationdir = scanner1.nextLine();

        ArrayList <String> DataList = operations.getDatalist();
        FileNamer fileNamer = new FileNamer("CopyofData");
        String[] FilePaths = operations.GetFilePaths(UserInputDir);
        for(String Path : FilePaths){
           operations.Read(Path);
       }
        int Switch = DataList.size();

        if(Switch >= 4){
            Switch = 4;
        }

        switch (Switch){
            case 1: operations.Write(fileNamer.getNewFileName(), DataList.get(1));
            break;
            case 2:
                MyThread Writer1 = new MyThread(){
                    @Override
                    public void run() {

                        operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(0));
                    }
                }; Writer1.start();

                MyThread Writer2 = new MyThread(){
                    @Override
                    public void run() {
                        operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(1));
                    }
                }; Writer2.start();
                break;
            case 3:
                MyThread Writer5 = new MyThread(){
                    @Override
                    public void run() {
                        operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(0));
                    }
                }; Writer5.start();

                MyThread Writer6 = new MyThread(){
                    @Override
                    public void run() {
                        operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(1));                    }
                }; Writer6.start();

                MyThread Writer7 = new MyThread(){
                    @Override
                    public void run() {
                        operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(2));                    }
                }; Writer7.start();
                break;

                case 4:
                Integer i = 0;
                    System.out.println(DataList.toString());
                    Integer[] finalI = {0};
                for( finalI[0] = 0; finalI[0] < DataList.size(); finalI[0]++){
                    System.out.println("---------------------------------------------");
                    System.out.println("    ");
                    System.out.println(finalI[0]);
                    MyThread Writer3 = new MyThread(){

                        @Override
                        public void run() {
                            System.out.println(DataList.get(finalI[0]));
                            //operations.Write(fileNamer.getNewFileName(),DataList.get(finalI[0]));
                            operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(finalI[0]));                    }

                    };

                    try {
                        Writer3.run();
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Done!!!");
                    }

                    if(finalI[0] > DataList.size() ){
                        System.out.println("Breaking..");
                        break;
                    }

                    MyThread Writer4 = new MyThread(){
                        @Override
                        public void run() {
                            System.out.println(DataList.get(finalI[0]));
//                            operations.Write(fileNamer.getNewFileName(),DataList.get(finalI[0]+1));
                            operations.Write(operations.PathCreator(fileNamer.getNewFileName(),destinationdir),DataList.get(finalI[0]+1));
                            finalI[0]++;
                        }

                    };
                    try {
                        Writer4.run();
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Done!!!");
                    }


                }
                    break;


        }


    }

}
