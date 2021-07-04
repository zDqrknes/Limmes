package de.dqrk.limmes;

import de.dqrk.limmes.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Limmes extends JavaPlugin {

    public static ConsoleCommandSender console;

    @Override
    public void onEnable() {

        console = Bukkit.getConsoleSender();















    }

    @Override
    public void onDisable() {

    }

    public static Strings getStrings(){
        return Strings.getInstance();
    }

    public static

}
