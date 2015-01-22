package me.kamilkime.kslots;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Cmds implements CommandExecutor{

	public Cmds(KSlots pl){}
	public static String ks = "§7§l[KSlots] §6";

//onCommand ----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]){
		if(cmd.getName().equalsIgnoreCase("kslots")){
			if(!sender.hasPermission("kslots.cmd")){
				sender.sendMessage("§cNie masz uprawnien!");
				return true;
}
//args.lenght == 0 ----------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(args.length == 0){
				FileManager.sendHelp(sender);
				return true;
}
//args.lenght == 1 ----------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("reload")){
					FileManager.reloadConfig();
					sender.sendMessage(ks + "Przeladowano config!");
					return true;
}
				if(args[0].equalsIgnoreCase("slots")){
					if(KSlots.enableSlotChange){
						KSlots.enableSlotChange = false;
						KSlots.pl.getConfig().set("enableSlotChange", false);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "§cWylaczono §6wyswietlanie falszywych slotow");
						return true;
}
					else{
						KSlots.enableSlotChange = true;
						KSlots.pl.getConfig().set("enableSlotChange", true);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "§aWlaczono §6wyswietlanie falszywych slotow");
						return true;
}
}
				if(args[0].equalsIgnoreCase("infslots")){
					if(KSlots.enableInfSlots){
						KSlots.enableInfSlots = false;
						KSlots.pl.getConfig().set("enableInfSlots", false);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "§cWylaczono §6nieograniczone sloty");
						return true;
}
					else{
						KSlots.enableInfSlots = true;
						KSlots.pl.getConfig().set("enableInfSlots", true);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "§aWlaczono §6nieograniczone sloty");
						return true;
}
}
				if(args[0].equalsIgnoreCase("motd")){
					if(KSlots.enableMotdChange){
						KSlots.enableMotdChange = false;
						KSlots.pl.getConfig().set("enableMotdChange", false);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "§cWylaczono §6zmienne motd");
						return true;
}
					else{
						KSlots.enableMotdChange = true;
						KSlots.pl.getConfig().set("enableMotdChange", true);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "§aWlaczono §6zmienne motd");
						return true;
}
}
				else{
					sender.sendMessage(ks + "§cPoprawne uzycie: /kslots <reload/slots/infslots/tryb/motd>");
					return true;
}
}
//args.lenght >= 2 ----------------------------------------------------------------------------------------------------------------------------------------------------------------
			if(args.length >= 2){
				if(args[0].equalsIgnoreCase("tryb")){
					if(args[1].equalsIgnoreCase("num")){
						KSlots.enableNormalChange = true;
						KSlots.enablePlusChange = false;
						KSlots.pl.getConfig().set("normalNumChange.enable", true);
						KSlots.pl.getConfig().set("plusChange.enable", false);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "Tryb wyswietlania slotow zostal zmieniony na §bnormalNumChange");
						return true;
}
					if(args[1].equalsIgnoreCase("plus")){
						KSlots.enableNormalChange = false;
						KSlots.enablePlusChange = true;
						KSlots.pl.getConfig().set("normalNumChange.enable", false);
						KSlots.pl.getConfig().set("plusChange.enable", true);
						KSlots.pl.saveConfig();
						sender.sendMessage(ks + "Tryb wyswietlania slotow zostal zmieniony na §bplusChange");
						return true;
}
					if(args[1].startsWith("n")){
						sender.sendMessage(ks + "Czy chodzilo ci o: §b/kslots tryb num§6?");
						return true;
}
					if(args[1].startsWith("p")){
						sender.sendMessage(ks + "Czy chodzilo ci o: §b/kslots tryb plus§6?");
						return true;
}
					else{
						sender.sendMessage(ks + "§cPoprawne uzycie: /kslots tryb <num/plus>");
						return true;
}
}
				if(args[0].equalsIgnoreCase("motd")){
					if(args[1].equalsIgnoreCase("list")){
						CmdFunctions.listMotds(sender);
						return true;
}
					if(args[1].equalsIgnoreCase("add")){
						StringBuilder str = new StringBuilder();
						for(int i = 2; i<args.length; i++){
							str.append(args[i] + " ");
}
						String motd = str.toString();
						CmdFunctions.addMotd(sender, motd);
						return true;
}
					if(args[1].equalsIgnoreCase("remove")){
						CmdFunctions.removeMotd(sender, args[2]);
						return true;
}
					else{
						sender.sendMessage(ks + "§cPoprawne uzycie: /kslots motd <list/add/remove>");
						return true;
}
}
}
}
		return false;
}
}