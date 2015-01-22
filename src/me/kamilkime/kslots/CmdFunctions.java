package me.kamilkime.kslots;

import org.bukkit.command.CommandSender;

public class CmdFunctions{

	public static void listMotds(CommandSender sender){
		sender.sendMessage("§7§l=-=-=-=-=-=-=-=<§6§lKSlots MOTDs§7§l>=-=-=-=-=-=-=-=-=");
		for(int i = 0; i < KSlots.customMotds.size(); i++){
			sender.sendMessage("§7§l[§6§lID: §b§l" + i + "§7§l]§r " + KSlots.customMotds.get(i));
}
		sender.sendMessage("§7§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
}
	public static void addMotd(CommandSender sender, String motd){
		KSlots.customMotds.add(motd);
		KSlots.pl.getConfig().set("customMotds", KSlots.customMotds);
		KSlots.pl.saveConfig();
		sender.sendMessage("§7§l=-=-=-=-=-=-=-=<§6§lKSlots MOTDs§7§l>=-=-=-=-=-=-=-=-=");
		sender.sendMessage("§a§lDodano motd o nowym id §6§l" + (KSlots.customMotds.size() - 1));
		sender.sendMessage("");
		sender.sendMessage("§a§lZaktualizowana lista motd:");
		for(int i = 0; i < KSlots.customMotds.size(); i++){
			sender.sendMessage("§7§l[§6§lID: §b§l" + i + "§7§l]§r " + KSlots.customMotds.get(i));
}
		sender.sendMessage("§7§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
}
	public static void removeMotd(CommandSender sender, String stringToId){
		try{
			int id = Integer.parseInt(stringToId);
			KSlots.customMotds.remove(id);
			KSlots.pl.getConfig().set("customMotds", KSlots.customMotds);
			KSlots.pl.saveConfig();
			sender.sendMessage("§7§l=-=-=-=-=-=-=-=<§6§lKSlots MOTDs§7§l>=-=-=-=-=-=-=-=-=");
			sender.sendMessage("§a§lUsunieto motd o id §6§l" + id);
			sender.sendMessage("");
			sender.sendMessage("§a§lZaktualizowana lista motd:");
			for(int i = 0; i < KSlots.customMotds.size(); i++){
				sender.sendMessage("§7§l[§6§lID: §b§l" + i + "§7§l]§r " + KSlots.customMotds.get(i));
}
			sender.sendMessage("§7§l=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
}
		catch(Exception e){
			sender.sendMessage(Cmds.ks + "§cPoprawne uzycie: /kslots motd remove <id>");
}
}
}