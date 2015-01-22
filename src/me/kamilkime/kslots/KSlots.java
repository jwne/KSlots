package me.kamilkime.kslots;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KSlots extends JavaPlugin{

	public static KSlots pl;
	public static Boolean enableSlotChange;
	public static Boolean enablePlusChange;
	public static Boolean enableNormalChange;
	public static Boolean enableInfSlots;
	public static Boolean enableMotdChange;
	public static int numUntilChange;
	public static int normalNumSlots;
	public static int numToAdd;
	public static List<String> customMotds = new ArrayList<String>();
	
	public void onEnable(){
		pl = this;
		FileManager.checkFiles();
		FileManager.load();
		getCommand("kslots").setExecutor(new Cmds(this));
		getCommand("kslots").setTabCompleter(new TabCompletion(this));
		Bukkit.getPluginManager().registerEvents(new ServerListPingListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(this), this);
}
}