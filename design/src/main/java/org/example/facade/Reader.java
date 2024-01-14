package org.example.facade;

public class Reader {
    // 파일 읽음

    private  String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("READER %s로 연결합니다. ", fileName);
        System.out.println(msg);
    }

    public void fileRead(){
        String msg = String.format("READER %s의 내용일 읽어 옵니다. ", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("READER %s로 연결을 종료합니다. ", fileName);
        System.out.println(msg);
    }

}
