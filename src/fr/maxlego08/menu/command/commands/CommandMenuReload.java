package fr.maxlego08.menu.command.commands;

import fr.maxlego08.menu.MenuPlugin;
import fr.maxlego08.menu.api.InventoryManager;
import fr.maxlego08.menu.api.command.CommandManager;
import fr.maxlego08.menu.command.VCommand;
import fr.maxlego08.menu.save.Config;
import fr.maxlego08.menu.zcore.enums.Message;
import fr.maxlego08.menu.zcore.enums.Permission;
import fr.maxlego08.menu.zcore.utils.commands.CommandType;

public class CommandMenuReload extends VCommand {

	public CommandMenuReload(MenuPlugin plugin) {
		super(plugin);
		this.addSubCommand("reload", "rl");
		this.setDescription(Message.DESCRIPTION_RELOAD);
		this.setPermission(Permission.ZMENU_RELAOD);
	}

	@Override
	protected CommandType perform(MenuPlugin plugin) {

		InventoryManager inventoryManager = plugin.getInventoryManager();
		
		plugin.getMessageLoader().load(plugin.getPersist());
		Config.getInstance().load(plugin.getPersist());
		
		inventoryManager.deleteInventories(plugin);
		inventoryManager.loadInventories();
		
		CommandManager commandManager = plugin.getCommandManager();
		commandManager.loadCommands();
		
		message(this.sender, Message.RELOAD);
		
		return CommandType.SUCCESS;
	}

}