package de.dqrk.limmes.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    // Copyright zDqrknes®

    private static FileManager instance;

    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }

    public void loadFiles() throws IOException {
        // folders
        File mainFolder = new File("plugins//Limmes");
        File modulesFolder = new File("plugins//Limmes//Modules");
        File warpModuleFolder = new File("plugins//Limmes//Modules//WarpModule");
        File warpModuleWarpFolder = new File("plugins//Limmes//Modules//WarpModules//Warps");
        File freezeModuleFolder = new File("plugins//Limmes//Modules//FreezeModule");
        File gamemodeModuleFolder = new File("plugins//Limmes//Modules//GamemodeModule");
        File joinquitModuleFolder = new File("plugins//Limmes//Modules//JoinQuitModule");

        if(!mainFolder.exists())
            mainFolder.mkdir();
        if(!modulesFolder.exists())
            modulesFolder.mkdir();
        if(!warpModuleFolder.exists())
            warpModuleFolder.mkdir();
        if(!warpModuleWarpFolder.exists())
            warpModuleWarpFolder.mkdir();
        if(!freezeModuleFolder.exists())
            freezeModuleFolder.mkdir();
        if(!gamemodeModuleFolder.exists())
            gamemodeModuleFolder.mkdir();
        if(!joinquitModuleFolder.exists())
            joinquitModuleFolder.mkdir();

        // files
        File mainFile = new File("plugins//Limmes//config.yml");
        File freezeModuleFile = new File("plugins//Limmes//config.yml");
        File gamemodeModuleFile = new File("plugins//Limmes//config.yml");
        File joinquitModuleFile = new File("plugins//Limmes//config.yml");
        File warpModuleFile = new File("plugins//Limmes//config.yml");

        if(!mainFile.exists()){
            mainFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(mainFile);
        }
        if(!freezeModuleFile.exists()){
            freezeModuleFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(freezeModuleFile);
        }
        if(!gamemodeModuleFile.exists()){
            gamemodeModuleFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(gamemodeModuleFile);
        }
        if(!joinquitModuleFile.exists()){
            joinquitModuleFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(joinquitModuleFile);
        }
        if(!warpModuleFile.exists()){
            warpModuleFile.createNewFile();
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(warpModuleFile);
        }
    }

}
