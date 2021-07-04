package de.dqrk.limmes.modules;

import de.dqrk.limmes.Limmes;
import de.dqrk.limmes.utils.Module;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinquitModule implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();

        e.setJoinMessage(Limmes.getStrings().getString(Module.JOINQUIT_MODULE, "JoinMessage")
                .replace("%player%", p.getName().replace("%max_players%", String.valueOf(Bukkit.getMaxPlayers()))
                        .replace("%online_players%", String.valueOf(Bukkit.getOnlinePlayers()))));

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        e.setQuitMessage(Limmes.getStrings().getString(Module.JOINQUIT_MODULE, "QuitMessage")
                .replace("%player%", p.getName().replace("%max_players%", String.valueOf(Bukkit.getMaxPlayers()))
                        .replace("%online_players%", String.valueOf(Bukkit.getOnlinePlayers()))));

    }

}