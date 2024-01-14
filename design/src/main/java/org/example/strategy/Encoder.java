package main.java.org.example.strategy;

public class Encoder {

    private EncodingStrategy ecodingStrategy;

    public String getMsg(String msg){
        return this.ecodingStrategy.encode(msg);
    }
    public void setEcodingStrategy(EncodingStrategy ecodingStrategy){
        this.ecodingStrategy = ecodingStrategy;
    }
}
