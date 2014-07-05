package com.dev.aaaa.plugins.mbjail.commands;

import com.dev.aaaa.plugins.mbjail.Config;
import com.mbserver.api.CommandExecutor;
import com.mbserver.api.CommandSender;

public class JailList implements CommandExecutor{

	private Config config;
	
	public JailList(Config config) {
		this.config = config;
	}
	
	@Override
	public void execute(String command, CommandSender sender, String[] args, String label) {
		
		if(sender.hasPermission("mbjail.jaillist") || sender.hasPermission("mbjail.*")){
			sender.sendMessage("[MBJail] Players in jail");
			for(String name : config.getMembers()){
				sender.sendMessage(name);
			}
			return;
		}
		
		sender.sendMessage("[MBJail] You don't have permission to use this command!");
	}

}
