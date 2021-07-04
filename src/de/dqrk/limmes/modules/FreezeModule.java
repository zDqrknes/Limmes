package de.dqrk.limmes.modules;

import de.dqrk.limmes.Limmes;
import de.dqrk.limmes.utils.Module;
import de.dqrk.limmes.utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

public class FreezeModule implements CommandExecutor, Listener {

    List<Player> freezedPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {

        if(s instanceof Player){
            Player p = (Player) s;
            if(!p.hasPermission("limmes.freeze")){
                p.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "noPermissions"));
            }else
                if(args.length == 0){
                    p.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "Usage"));
                }else if(args.length == 1){
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t != null){
                        if(!freezedPlayers.contains(t)) {
                            freezedPlayers.add(t);
                            p.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "UnFreezed").replace("%player%", t.getName()));
                        }else{
                            freezedPlayers.remove(t);
                            p.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "Freezed").replace("%player%", t.getName()));
                        }
                    }else
                        p.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "PlayerNotFound"));
                }else{
                    p.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "Usage"));
                }
        }else{
            if(args.length == 0){
                s.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "Usage"));
            }else if(args.length == 1){
                Player t = Bukkit.getPlayer(args[0]);
                if(t != null){
                    if(!freezedPlayers.contains(t)) {
                        freezedPlayers.add(t);
                        s.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "UnFreezed").replace("%player%", t.getName()));
                    }else{
                        freezedPlayers.remove(t);
                        s.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "Freezed").replace("%player%", t.getName()));
                    }
                }else
                    s.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "PlayerNotFound"));
            }else {
                s.sendMessage(Limmes.getStrings().getString(Module.FREEZE_MODULE, "Usage"));
            }
        }

        return false;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(freezedPlayers.contains(p))
            e.setCancelled(true);
    }
}
