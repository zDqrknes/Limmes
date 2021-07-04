package de.dqrk.limmes.modules.warpmodule;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Warp {

    String name;
    Location loc;

    public Warp(String name){
        File file = new File("plugins//Limmes//Modules//WarpModule//Warps//" + name + ".yml");

        if(file.exists()) {
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            float Yaw = (float) cfg.getDouble("Yaw");
            float Pitch = (float) cfg.getDouble("Pitch");
            World world = Bukkit.getWorld(cfg.getString("World"));

            Location loc = new Location(world, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), Yaw, Pitch);
            this.loc = loc;
        }
    }

    public boolean save() throws IOException {
        File file = new File("plugins//Limmes//Modules//WarpModule//Warps//" + name + ".yml");

        if(file.exists()){
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

            cfg.set("World", this.loc.getWorld().getName());
            cfg.set("X", this.loc.getX());
            cfg.set("Y", this.loc.getY());
            cfg.set("Z", this.loc.getZ());
            cfg.set("Yaw", this.loc.getYaw());
            cfg.set("Pitch", this.loc.getPitch());

            cfg.save(file);

            return true;
        }else
            return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public boolean exists(){
        File file = new File("plugins//Limmes//Modules//WarpModule//Warps//" + name + ".yml");

        if(file.exists())
            return true;
        return false;
    }

    public void createNewWarp() throws IOException {
        File file = new File("plugins//Limmes//Modules//WarpModule//Warps//" + name + ".yml");

        file.createNewFile();
        save();
    }
}
