package com.dev.aaaa.plugins.mbjail.handlers;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.events.BlockEvent;
import com.mbserver.api.events.EventHandler;
import com.mbserver.api.events.Listener;

public class BlockHandler implements Listener{
	private Config config;
	
	public BlockHandler(Config config) {
		this.config = config;
	}
	
	@EventHandler
	public void blockEvent(BlockEvent e){
		
		if(config.isInJail(e.getPlayer().getLoginName().toLowerCase())){
			e.setCancelled(true);
			e.getPlayer().sendMessage("[MBJail] You are in jail!");
			return;
		}
		
		if(config.contains(e.getLocation())){
			e.getPlayer().sendMessage("[MBJail] Cannot modify jail!");
			e.setCancelled(true);
		}
	}
}
