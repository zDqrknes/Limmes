package de.dqrk.limmes.utils;

import java.util.HashMap;
import java.util.Map;

public class Strings {

    private static Strings instance;

    public static Strings getInstance(){
        if(instance == null){
            instance = new Strings();
        }
        return instance;
    }

    Map<String, String> saves = new HashMap<>();

    public Strings(){

    }

    public String getString(Module module, String name){
        return saves.get(name);
    }

}
