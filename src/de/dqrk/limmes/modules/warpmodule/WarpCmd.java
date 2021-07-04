package de.dqrk.limmes.modules.warpmodule;

import de.dqrk.limmes.Limmes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {

        if(s instanceof Player){
            Player p = (Player) s;
            if(args.length == 2){
                if(!p.hasPermission(Limmes.getStrings().getString(Mo)))
            }
        }

        return false;
    }
}
