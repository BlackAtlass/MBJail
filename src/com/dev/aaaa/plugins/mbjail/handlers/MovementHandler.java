package com.dev.aaaa.plugins.mbjail.handlers;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerMoveEvent;
import com.mbserver.api.events.PlayerTeleportEvent;
//Remove in 1.13
import com.mbserver.api.events.RunMode;
import com.mbserver.api.game.Location;
import com.mbserver.api.game.Player;

public class MovementHandler implements Listener{

	private final Config config;
	
	public MovementHandler(final Config config) {
		this.config = config;
	}
	
	//Remove concurrency in 1.13
	@EventHandler(concurrency = RunMode.THREADED)
	public void onMove(final PlayerMoveEvent e){
		
		if(e instanceof PlayerTeleportEvent)
			return;
		final Player player = e.getPlayer();
		if(config.isInJail(player.getLoginName()))
		{
			if(!config.contains(player.getLocation())){
				//Enable cancelability in 1.13
				//e.setCancelled(true);
				final Location jail = config.getJailLocation();
				player.teleport(jail.add(5, 2, 5));
				player.sendMessage("[MBJail] You are in jail!");
			}
		}
	}
}
