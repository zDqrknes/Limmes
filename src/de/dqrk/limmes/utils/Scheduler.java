package de.dqrk.limmes.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Scheduler {

    int taskID;

    public Scheduler(){

    }

    public void scheduleSyncRepeatingTask(Plugin plugin, Runnable runnable, long ticks){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, runnable, 0, ticks);
    }

    public void cancelTask(){
        Bukkit.getScheduler().cancelTask(taskID);
    }

}
