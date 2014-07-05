package com.dev.aaaa.plugins.mbjail.commands;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.game.Player;

public class SetJail implements CommandExecutor {

	private Config config;
	
	public SetJail(Config config) {
		this.config = config;
	}
	
	@Override
	public void execute(String command, CommandSender sender, String[] args, String label) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage("[MBJail] This command can only be executed as a player!");
			return;
		}
		
		if(sender.hasPermission("mbjail.setjail") || sender.hasPermission("mbjail.*")){
			Player player = (Player)sender;
			config.setJail(player.getLocation());
			player.sendMessage("[MBJail] Jail set to your location!");
			return;
		}
		
		sender.sendMessage("[MBJail] You don't have permission to use this command!");
	}

}
