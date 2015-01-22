package me.kamilkime.kslots;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabCompletion implements TabCompleter{

	public TabCompletion(KSlots instance){}
	
		@Override
		public List<String> onTabComplete(CommandSender sender, Command cmd, String commandLabel, String[] args){
			if(cmd.getName().equalsIgnoreCase("kslots")){
				List<String> arg = new ArrayList<String>();
				if(sender.hasPermission("kslots.cmd")){
					if(args.length == 1){
						if(args[0].toLowerCase().startsWith("r")){
							arg.add("reload");
							return arg;
	}
						if(args[0].toLowerCase().startsWith("m")){
							arg.add("motd");
							return arg;
	}
						if(args[0].toLowerCase().startsWith("i")){
							arg.add("infslots");
							return arg;
	}
						if(args[0].toLowerCase().startsWith("t")){
							arg.add("tryb");
							return arg;
	}
						if(args[0].toLowerCase().startsWith("s")){
							arg.add("slots");
							return arg;
	}
						if(args[0].toLowerCase().startsWith("")){
							arg.add("reload");
							arg.add("slots");
							arg.add("infslots");
							arg.add("motd");
							arg.add("tryb");
							return arg;
	}
	}
					if(args.length == 2){
						if(args[0].equalsIgnoreCase("tryb")){
							if(args[1].toLowerCase().startsWith("p")){
								arg.add("plus");
								return arg;
	}
							if(args[1].toLowerCase().startsWith("n")){
								arg.add("num");
								return arg;
	}
							if(args[1].toLowerCase().startsWith("")){
								arg.add("plus");
								arg.add("num");
								return arg;
	}
	}
						if(args[0].equalsIgnoreCase("motd")){
							if(args[1].toLowerCase().startsWith("a")){
								arg.add("add");
								return arg;
	}
							if(args[1].toLowerCase().startsWith("l")){
								arg.add("list");
								return arg;
	}
							if(args[1].toLowerCase().startsWith("r")){
								arg.add("remove");
								return arg;
	}
							if(args[1].toLowerCase().startsWith("")){
								arg.add("remove");
								arg.add("add");
								arg.add("list");
								return arg;
	}
	}
	}
	}
				return null;
	}
			return null;
	}
}