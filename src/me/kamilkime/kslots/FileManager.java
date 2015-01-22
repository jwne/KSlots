package me.kamilkime.kslots;

import java.io.File;

import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class FileManager{
	private static File mainDir = KSlots.pl.getDataFolder();
	private static File cfgFile = new File(mainDir, "config.yml");
	
	public static void checkFiles(){
		if(!mainDir.exists()){
			mainDir.mkdir();
}
		if(!cfgFile.exists()){
			try{
				cfgFile.createNewFile();
}
			catch(Exception e){
				Bukkit.getPluginManager().disablePlugin(KSlots.pl);
}
}
		KSlots.pl.getConfig().options().copyDefaults(true);
		KSlots.pl.saveConfig();
}
	public static void load(){
		KSlots.customMotds = KSlots.pl.getConfig().getStringList("customMotds");
		KSlots.enableInfSlots = KSlots.pl.getConfig().getBoolean("enableInfiniteSlots");
		KSlots.enableMotdChange = KSlots.pl.getConfig().getBoolean("enableMotdChange");
		KSlots.enableNormalChange = KSlots.pl.getConfig().getBoolean("normalNumChange.enable");
		KSlots.enablePlusChange = KSlots.pl.getConfig().getBoolean("plusChange.enable");
		KSlots.enableSlotChange = KSlots.pl.getConfig().getBoolean("enableSlotChange");
		KSlots.normalNumSlots = KSlots.pl.getConfig().getInt("normalNumChange.numSlots");
		KSlots.numUntilChange = KSlots.pl.getConfig().getInt("plusChange.numUntilChange");
		KSlots.numToAdd = KSlots.pl.getConfig().getInt("plusChange.numToAdd");
}
	public static void reloadConfig(){
		KSlots.pl.reloadConfig();
		KSlots.pl.saveConfig();
		load();
}
	public static void sendHelp(CommandSender sender){
		sender.sendMessage("§7§l=-=-=-=-=-=-=-=<§6§lKSlots Help§7§l>=-=-=-=-=-=-=-=-=");
		sender.sendMessage("§b/kslots reload §8- §6reloaduje config");
		sender.sendMessage("§b/kslots slots §8- §6wlacza/wylacza wyswietlanie falszywych slotow");
		sender.sendMessage("§b/kslots tryb <num§b|§bplus> §8- §6ustawia tryb wyswietlania slotow");
		sender.sendMessage("§b/kslots infslots §8- §6wlacza/wylacza nieograniczone sloty");
		sender.sendMessage("§b/kslots motd §8- §6wlacza/wylacza zmienne motd");
		sender.sendMessage("§b/kslots motd list §8- §6pokazuje liste zmiennych motd");
		sender.sendMessage("§b/kslots motd add [motd] §8- §6dodaje nowe motd do listy");
		sender.sendMessage("§b/kslots motd remove [id] §8- §6usuwa motd o wybranym id");
		if(sender instanceof Player){
			sender.sendMessage("");
			sendClickableMessage((Player) sender, "§a§lNadal nie wiesz? Klikij te linijke aby poczytac §a§lwiecej!", "§6§lTak jest! Kliknij mnie!", "open_url", "https://github.com/Kamilkime/KSlots");
}
		sender.sendMessage("§7§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
}
	public static void sendClickableMessage(Player p, String baseMsg, String hoverMsg, String action, String toDo){
		IChatBaseComponent comp = ChatSerializer.a("{\"text\":\"" + baseMsg + "\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"" + hoverMsg +"\"},\"clickEvent\":{\"action\":\"" + action + "\",\"value\":\"" + toDo + "\"}}");
		PacketPlayOutChat pack = new PacketPlayOutChat(comp, true);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(pack);
}
}