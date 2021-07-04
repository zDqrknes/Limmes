package de.dqrk.limmes.modules.warpmodule;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WarpManager {

    private static WarpManager instance;

    public static WarpManager getInstance(){
        if(instance == null){
            instance = new WarpManager();
        }
        return instance;
    }

    public Warp getWarp(String name){
        return new Warp(name);
    }

    public void setWarp(String name, Location loc) throws IOException {
        Warp warp = new Warp(name);
        warp.setLoc(loc);
        warp.createNewWarp();
    }

}
