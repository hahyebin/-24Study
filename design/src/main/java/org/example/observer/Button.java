package main.java.org.example.observer;

public class Button {

    private String buttonName;
    private IButtonListener iButtonListener;


    public Button(String buttonName) {
        this.buttonName = buttonName;
    }

    public void click(String msg){
        iButtonListener.clickEvent(msg);
    }
    public void addListener(IButtonListener iButtonListener) {
        this.iButtonListener = iButtonListener;
    }
}