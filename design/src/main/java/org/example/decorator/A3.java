package org.example.decorator;

public class A3 extends AudiDecorator{
    public A3(ICar audi, String modelname) {
        super(audi, modelname,1000);
    }
}
