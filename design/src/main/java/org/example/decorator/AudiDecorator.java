package main.java.org.example.decorator;

import javax.swing.*;

public class AudiDecorator implements ICar {

    protected ICar audi;
    protected String modelname;
    protected int modelprice;


    public AudiDecorator(ICar audi, String modelname, int modelprice) {
        this.audi = audi;
        this.modelname = modelname;
        this.modelprice = modelprice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + modelprice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelname+"의 가격은 "+getPrice()+"원 입니다.");
    }
}
