package de.dqrk.limmes.modules;

import de.dqrk.limmes.Limmes;
import de.dqrk.limmes.utils.Module;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GamemodeModule implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {

        if(s instanceof Player){
            Player p = (Player) s;
            if(args.length == 2){
                if(!p.hasPermission("limmes.gamemode.other")){
                    p.sendMessage(Limmes.getStrings().getString(Module.GAMEMODE_MODULE, "UsageSelf"));
                }else{
                    Player t = Bukkit.getPlayer(args[1]);
                    if(t != null){
                        
                    }else
                        p.sendMessage(Limmes.getStrings().getString(Module.GAMEMODE_MODULE, "PlayerNotFound"));
                }
            }
        }

        return false;
    }
}
