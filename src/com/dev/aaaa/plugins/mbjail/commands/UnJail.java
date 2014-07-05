package com.dev.aaaa.plugins.mbjail.commands;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;
import com.mbserver.api.Server;
import com.mbserver.api.game.Player;

public class UnJail implements CommandExecutor{

	private Config config;
	private Server server;
	public UnJail(Config config, Server server) {
		this.config = config;
		this.server = server;
	}
	
	@Override
	public void execute(String command, CommandSender sender, String[] args, String label) {
		
		if(sender.hasPermission("mbjail.unjail") || sender.hasPermission("mbjail.*")){
			if(args.length == 0){
				sender.sendMessage("[MBJail] Usage: /unjail <Player Login Name>");
				sender.sendMessage("[MBJail] If player is online use display name");
				return;
			}
			
			if(config.getJailLocation() == null){
				sender.sendMessage("[MBJail] No jail has been set!");
				return;
			}
			
			Player target = server.getPlayer(args[0]);
			
			if(target != null){
				if(!config.deleteMember(target.getLoginName().toLowerCase()))
					sender.sendMessage("[MBJail] The player '" + args[0] + "' is not in jail!");
				
				else{
					target.teleport(config.getJailLocation().add(-1, 0, -1));
					sender.sendMessage("[MBJail] The player '" + args[0] + "' has been unjailed!");
				}
				
				return;
			}
			
			config.deleteMember(args[0].toLowerCase());
			sender.sendMessage("[MBJail] The player '" + args[0] + "' has been unjailed!");
			return;
		}
		
		sender.sendMessage("[MBJail] You don't have permission to use this command!");
	}

}
