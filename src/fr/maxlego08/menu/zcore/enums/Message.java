package fr.maxlego08.menu.zcore.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.inventory.ItemStack;

import fr.maxlego08.menu.zcore.utils.nms.NMSUtils;

public enum Message {

	PREFIX("�8(�6zMenu�8) "),
	
	TELEPORT_MOVE("�cYou must not move!"),
	TELEPORT_MESSAGE("�7Teleportation in �3%second% �7seconds!"),
	TELEPORT_ERROR("�cYou already have a teleportation in progress!"),
	TELEPORT_SUCCESS("�7Teleportation done!"),
	
	VINVENTORY_NULL("�cImpossible to find the inventory with the id �6%id%�c."),
	VINVENTORY_CLONE_NULL("�cThe inventory clone is null!"),
	VINVENTORY_OPEN_ERROR("�cAn error occurred with the opening of the inventory �6%id%�c."),
	VINVENTORY_BUTTON_PREVIOUS("�f� �7Previous page"),
	VINVENTORY_BUTTON_NEXT("�f� �7Next page"),
	
	TIME_DAY("%02d %day% %02d %hour% %02d %minute% %02d %second%"),
	TIME_HOUR("%02d %hour% %02d minute(s) %02d %second%"),
	TIME_HOUR_SIMPLE("%02d:%02d:%02d"),
	TIME_MINUTE("%02d %minute% %02d %second%"),
	TIME_SECOND("%02d %second%"),
	
	FORMAT_SECOND("second"),
	FORMAT_SECONDS("seconds"),	
	
	FORMAT_MINUTE("minute"),
	FORMAT_MINUTES("minutes"),
	
	FORMAT_HOUR("hour"),
	FORMAT_HOURS("hours"),
	
	FORMAT_DAY("d"),
	FORMAT_DAYS("days"),
	
	COMMAND_SYNTAXE_ERROR("�cYou must execute the command like this�7: �a%syntax%"),
	COMMAND_NO_PERMISSION("�cYou do not have permission to run this command."),
	COMMAND_NO_CONSOLE("�cOnly one player can execute this command."),
	COMMAND_NO_ARG("�cImpossible to find the command with its arguments."),
	COMMAND_SYNTAXE_HELP("�f%syntax% �7� �7%description%"),
	DOCUMENTATION_INFORMATION("�7Documentation�8: �fhttps://zmenu.groupez.dev/"),
	
	INVENTORY_NOT_FOUND("�cUnable to find the �f%toName% �cinventory in the �f%name%�c inventory."), 
	INVENTORY_ERROR("�cUnable to find the �f%name%�c inventory."), 
	INVENTORY_OPEN_OTHER("�aYou have just opened the inventory �f%name%�a to the �3%player%�a."),
	INVENTORY_OPEN_SUCCESS("�aYou have just opened the inventory �f%name%�a."),
	INVENTORY_OPEN_ERROR_INVENTORY("�cImpossible to find the inventory �f%name%�c."),
	INVENTORY_OPEN_ERROR_COMMAND("�cImpossible to find the command �f%name%�c."),
	INVENTORY_OPEN_ERROR_PLAYER("�cUnable to find the player, please specify."),
	INVENTORY_OPEN_ERROR_CONSOLE("�cOnly one player can open an inventory."),
	
	DESCRIPTION_OPEN("Allows you to open an inventory"),
	DESCRIPTION_RELOAD("Allows you to reload configuration files."),
	DESCRIPTION_VERSION("Show plugin version"),
    DESCRIPTION_CONVERT("Convert other configurations to zmenu"),
	
	RELOAD("�aYou have just reloaded the configuration files."),
	RELOAD_INVENTORY("�aYou have just reloaded the inventories files."),
	RELOAD_INVENTORY_FILE("�aVous have just reloaded the inventory �f%name%�a."),
	RELOAD_COMMAND("�aYou have just reloaded the commands files."),
	RELOAD_COMMAND_FILE("�aVous have just reloaded the command �f%name%�a."),
	RELOAD_COMMAND_ERROR("�cIt is not possible to reload the command �f%name%�c."),
	RELOAD_FILES("�aYou have just reloaded config.json and messages.yml files."),
	
	CONVERT_INFO(
			"�fYou can convert the menu from �eDeluxeMenu�f to �azMenu�f.",
			"�fYou must install the �3zMenuConvert�f plugin.",
			"�fDownload link�8: �7https://groupez.dev/resources/zmenuconvert.266",
			"�fYou must then issue the command �b/zmenu convert�f."
			)
	
	;

	private List<String> messages;
	private String message;
	private Map<String, Object> titles = new HashMap<>();
	private boolean use = true;
	private MessageType type = MessageType.TCHAT;

	private ItemStack itemStack;
	
	/**
	 * 
	 * @param message
	 */
	private Message(String message) {
		this.message = message;
		this.use = true;
	}

	/**
	 * 
	 * @param title
	 * @param subTitle
	 * @param a
	 * @param b
	 * @param c
	 */
	private Message(String title, String subTitle, int a, int b, int c) {
		this.use = true;
		this.titles.put("title", title);
		this.titles.put("subtitle", subTitle);
		this.titles.put("start", a);
		this.titles.put("time", b);
		this.titles.put("end", c);
		this.titles.put("isUse", true);
		this.type = MessageType.TITLE;
	}

	/**
	 * 
	 * @param message
	 */
	private Message(String... message) {
		this.messages = Arrays.asList(message);
		this.use = true;
	}
	
	/**
	 * 
	 * @param message
	 */
	private Message(MessageType type, String... message) {
		this.messages = Arrays.asList(message);
		this.use = true;
		this.type = type;
	}
	
	/**
	 * 
	 * @param message
	 */
	private Message(MessageType type, String message) {
		this.message = message;
		this.use = true;
		this.type = type;
	}

	/**
	 * 
	 * @param message
	 * @param use
	 */
	private Message(String message, boolean use) {
		this.message = message;
		this.use = use;
	}

	public String getMessage() {
		return message;
	}

	public String toMsg() {
		return message;
	}

	public String msg() {
		return message;
	}

	public boolean isUse() {
		return use;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessages() {
		return messages == null ? Arrays.asList(message) : messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public boolean isMessage() {
		return messages != null && messages.size() > 1;
	}

	public String getTitle() {
		return (String) titles.get("title");
	}

	public Map<String, Object> getTitles() {
		return titles;
	}

	public void setTitles(Map<String, Object> titles) {
		this.titles = titles;
		this.type = MessageType.TITLE;
	}

	public String getSubTitle() {
		return (String) titles.get("subtitle");
	}

	public boolean isTitle() {
		return titles.containsKey("title");
	}

	public int getStart() {
		return ((Number) titles.get("start")).intValue();
	}

	public int getEnd() {
		return ((Number) titles.get("end")).intValue();
	}

	public int getTime() {
		return ((Number) titles.get("time")).intValue();
	}

	public boolean isUseTitle() {
		return (boolean) titles.getOrDefault("isUse", "true");
	}

	public String replace(String a, String b) {
		return message.replace(a, b);
	}

	public MessageType getType() {
		return type.equals(MessageType.ACTION) && NMSUtils.isVeryOldVersion() ? MessageType.TCHAT : type;
	}
	
	public ItemStack getItemStack() {
		return itemStack;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
	public void setItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

}

