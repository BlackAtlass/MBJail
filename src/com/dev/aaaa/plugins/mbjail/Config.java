package com.dev.aaaa.plugins.mbjail;

import java.util.ArrayList;

import com.mbserver.api.game.Location;
import com.mbserver.api.game.Material;
import com.mbserver.api.game.World;

public class Config {
	private short material;
	private short material2;
	private Location jail;
	
	private ArrayList<String> names;
	
	public Config() {
		material = Material.OBSIDIAN.getID();
		material2 = Material.GLASS.getID();
		names = new ArrayList<String>();
	}
	
	public void disposeJail(){
		
		if(jail == null)
			return;
		
		World world = jail.getWorld();
		
		for(int x = jail.getBlockX() ; x < jail.getBlockX() + 10 ; x++){
			for(int z = jail.getBlockZ() ; z < jail.getBlockZ() + 10 ; z++){
				for(int y = jail.getBlockY() ; y < jail.getBlockY() + 6 ; y++){
					world.setBlockWithoutUpdate(x, y, z, Material.AIR);
				}
			}
		}
		jail = null;
	}
	
	public void createJail(){
		World world = jail.getWorld();
		short schem[][][] = this.getJailBlocks();
		
		int x,y,z;
		x = jail.getBlockX();
		y = jail.getBlockY();
		z = jail.getBlockZ();
		
		for(int X = 0; X < schem[0].length ; X++)
			for(int Z = 0; Z < schem[0][0].length ; Z++)
				for(int Y = 0; Y < schem.length ; Y++) {
					world.setBlockWithoutUpdate(X + x, Y + y, Z + z, schem[Y][X][Z]);
				}
		
	}
		
	
	public void setJail(Location location){
		this.disposeJail();
		this.jail = location;
		this.createJail();
	}
	
	public Location getJailLocation(){
		return jail;
	}
	
	private short[][][] getJailBlocks(){
		short m = material;
		short g = material2;
		
		short blocks[][][] = {
				{
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
				},
				{
					{m,m,m,m,m,m,m,m,m,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,m,m,m,m,m,m,m,m,m},
				},
				{
					{g,g,g,g,g,g,g,g,g,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,0,0,0,0,0,0,0,0,g},
					{g,g,g,g,g,g,g,g,g,g},
				},
				{
					{m,m,m,m,m,m,m,m,m,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,m,m,m,m,m,m,m,m,m},
				},
				{
					{m,m,m,m,m,m,m,m,m,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,0,0,0,0,0,0,0,0,m},
					{m,m,m,m,m,m,m,m,m,m},
				},
				{
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,g,g,g,g,m,m,m},
					{m,m,m,g,g,g,g,m,m,m},
					{m,m,m,g,g,g,g,m,m,m},
					{m,m,m,g,g,g,g,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
					{m,m,m,m,m,m,m,m,m,m},
				}
				
		};
		
		return blocks;
	}
	
	public boolean contains(Location e){
		for(int x = jail.getBlockX() ; x < jail.getBlockX() + 10 ; x++){
			for(int z = jail.getBlockZ() ; z < jail.getBlockZ() + 10 ; z++){
				for(int y = jail.getBlockY() ; y < jail.getBlockY() + 6 ; y++){
					if( x == e.getBlockX() && y == e.getBlockY() && z == e.getBlockZ())
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean addMember(String login){
		if(!names.contains(login)){
			names.add(login);
			return true;
		}
		return false;
	}
	
	public boolean deleteMember(String login){
		return names.remove(login);
	}
	
	public boolean isInJail(String login){
		return names.contains(login);
	}
	
	public String[] getMembers(){
		return names.toArray(new String[0]);
	}
}
