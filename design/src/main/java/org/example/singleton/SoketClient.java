package main.java.org.example.singleton;

public class SoketClient {

    private static SoketClient soketClient = null;

    private  SoketClient(){

    }

    public  static  SoketClient getInstance(){

        if(soketClient == null){
            soketClient = new SoketClient();
        }
        return  soketClient;
    }

    public void connect(){
        System.out.println("connect");
    }
}
