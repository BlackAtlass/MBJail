package com.dev.aaaa.plugins.mbjail.handlers;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;
import com.mbserver.api.events.PlayerMoveEvent;
import com.mbserver.api.events.PlayerTeleportEvent;
import com.mbserver.api.game.Location;

public class MovementHandler implements Listener{

	private Config config;
	
	public MovementHandler(Config config) {
		this.config = config;
	}
	
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		if(e instanceof PlayerTeleportEvent)
			return;
		
		if(config.isInJail(e.getPlayer().getLoginName()))
		{
			if(!config.contains(e.getPlayer().getLocation())){
				e.setCancelled(true);
				Location jail = config.getJailLocation();
				e.getPlayer().teleport(jail.add(5, 2, 5));
				e.getPlayer().sendMessage("[MBJail] You are in jail!");
			}
		}
	}
}
