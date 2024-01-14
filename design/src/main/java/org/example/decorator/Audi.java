package org.example.decorator;

import javax.swing.*;

public class Audi implements ICar {
    private int price;

    public Audi(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("Audi 가격은 "+this.price+"원 입니다.");

    }
}
