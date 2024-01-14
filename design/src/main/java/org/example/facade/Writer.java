package main.java.org.example.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void writer(){
        String msg = String.format("writer %s로 파일쓰기를 합니다. ", fileName);
        System.out.println(msg);
    }

    public void fileConnect(){
        String msg = String.format("writer %s 연결합니다. ", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("writer %s 연결종료합니다. ", fileName);
        System.out.println(msg);
    }
}
