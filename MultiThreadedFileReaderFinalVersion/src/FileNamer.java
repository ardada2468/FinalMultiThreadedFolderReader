public class FileNamer {
    String StartFileName;
    String NewFileName;
    Integer Number = 1;
    public FileNamer(String startFileName) {
        StartFileName = startFileName;
    }

    public void ChangeFileName(){
        NewFileName = StartFileName + Number.toString();
        Number++;
    }

    public String getNewFileName() {
        ChangeFileName();
        return NewFileName;
    }

}
