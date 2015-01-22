package me.kamilkime.kslots;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class PlayerLoginListener implements Listener{

	public PlayerLoginListener(KSlots pl){}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e){
		if(e.getResult().equals(Result.KICK_FULL)){
			if(KSlots.enableInfSlots){
				e.allow();
}
}
}
}