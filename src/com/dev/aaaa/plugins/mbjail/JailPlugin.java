package com.dev.aaaa.plugins.mbjail;

import com.dev.aaaa.plugins.mbjail.commands.Jail;
import com.dev.aaaa.plugins.mbjail.commands.JailList;
import com.dev.aaaa.plugins.mbjail.commands.SetJail;
import com.dev.aaaa.plugins.mbjail.commands.UnJail;
import com.dev.aaaa.plugins.mbjail.handlers.BlockHandler;
import com.dev.aaaa.plugins.mbjail.handlers.MovementHandler;
import com.mbserver.api.MBServerPlugin;
import com.mbserver.api.Manifest;
import com.mbserver.api.PluginManager;
import com.mbserver.api.Server;

@Manifest( name = "MBJail" , authors = "AAAA" , config = Config.class)
public class JailPlugin extends MBServerPlugin{
	private Config config;
	
	@Override
	public void onEnable() {
		PluginManager manager = this.getPluginManager();
		Server server = this.getServer();
		config = this.getConfig();
		this.saveConfig();
		
		manager.registerCommand("setjail", new SetJail(config));
		manager.registerCommand("jail", new Jail(config, server));
		manager.registerCommand("unjail", new UnJail(config, server));
		manager.registerCommand("jaillist", new JailList(config));
		
		manager.registerEventHandler(new BlockHandler(config));
		manager.registerEventHandler(new MovementHandler(config));
	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
	}
	
}
