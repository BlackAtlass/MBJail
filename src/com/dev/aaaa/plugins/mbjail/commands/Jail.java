package com.dev.aaaa.plugins.mbjail.commands;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Server;
import com.mbserver.api.game.Player;

public class Jail implements CommandExecutor{

	private Config config;
	private Server server;
	public Jail(Config config, Server server) {
		this.config = config;
		this.server = server;
	}
	
	@Override
	public void execute(String command, CommandSender sender, String[] args, String label) {
		
		if(sender.hasPermission("mbjail.jail") || sender.hasPermission("mbjail.*")){
			if(args.length == 0){
				sender.sendMessage("[MBJail] Usage: /jail <Player Login Name>");
				sender.sendMessage("[MBJail] If player is online use display name");
				return;
			}
			if(config.getJailLocation() == null){
				sender.sendMessage("[MBJail] No jail has been set!");
				return;
			}
			Player target = server.getPlayer(args[0]);
			
			if(target != null){
				if(!config.addMember(target.getLoginName().toLowerCase()))
					sender.sendMessage("[MBJail] The player '" + args[0] + "' is already in jail!");
				
				else
					sender.sendMessage("[MBJail] The player '" + args[0] + "' has been sent to jail");
				
				return;
			}
			
			config.addMember(args[0].toLowerCase());
			sender.sendMessage("[MBJail] The player '" + args[0] + "' has been sent to jail!");
			return;
		}
		
		sender.sendMessage("[MBJail] You don't have permission to use this command!");
	}

}
