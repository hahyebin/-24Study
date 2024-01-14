package org.example.adapter;

public class AirConditional implements Electronic220V{
    

    @Override
    public void connect() {
        System.out.println("에어컨 220V");
    }


}
