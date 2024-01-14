package org.example.singleton;

import java.security.acl.Acl;

public class AClazz {

    private SoketClient soketClient;

    public AClazz(){
        this.soketClient = SoketClient.getInstance();
    }

    public  SoketClient getSoketClient(){
        return  soketClient;
    }
}
