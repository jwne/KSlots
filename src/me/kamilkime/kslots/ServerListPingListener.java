package me.kamilkime.kslots;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener{
	
	public ServerListPingListener(KSlots pl){}
	
	@EventHandler
	public void onPing(ServerListPingEvent e){
		if(KSlots.enableSlotChange){
			if(KSlots.enablePlusChange){
				if(KSlots.enableNormalChange){
					KSlots.enableNormalChange = false;
					KSlots.enablePlusChange = true;
					KSlots.pl.getConfig().set("normalNumChange.enable", false);
					KSlots.pl.getConfig().set("plusChange.enable", true);
					KSlots.pl.saveConfig();
}
				if(e.getNumPlayers() < KSlots.numUntilChange){
					e.setMaxPlayers(KSlots.numUntilChange);
}
				else{
					e.setMaxPlayers(e.getNumPlayers() + KSlots.numToAdd);
}
}
			if(KSlots.enableNormalChange){
				if(KSlots.enablePlusChange){
					KSlots.enableNormalChange = true;
					KSlots.enablePlusChange = false;
					KSlots.pl.getConfig().set("normalNumChange.enable", true);
					KSlots.pl.getConfig().set("plusChange.enable", false);
					KSlots.pl.saveConfig();
}
				e.setMaxPlayers(KSlots.normalNumSlots);
}
}
		if(KSlots.enableMotdChange){
			Random r = new Random();
			int id = r.nextInt(KSlots.customMotds.size());
			String motd1 = KSlots.customMotds.get(id);
			String motd2 = ChatColor.translateAlternateColorCodes('&', motd1);
			String motd3 = ChatColor.translateAlternateColorCodes('$', motd2);
			e.setMotd(motd3);
}
}
}