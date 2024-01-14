package main.java.org.example.adapter;

public class SoketAdapter implements Electronic110V {

    private Electronic220V electronic220V;

    public  SoketAdapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }
    @Override
    public void powerOn() {
        electronic220V.connect();

    }
}
