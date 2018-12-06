package net.fathomtech.plugins.AdminGUI.Commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Ben12345rocks.AdvancedCore.CommandAPI.CommandHandler;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.Config.Config;
import net.fathomtech.plugins.AdminGUI.GUI.AdminGUI;

public class CommandLoader {
    /**
     * The config.
     */
    static Config config = Config.getInstance();
    
    /**
     * The instance.
     */
    static CommandLoader instance = new CommandLoader();
    
    /**
     * The plugin,
     */
    static Main plugin = Main.plugin;
    
    /**
	 * Gets the single instance of CommandLoader.
	 *
	 * @return single instance of CommandLoader
	 */
	public static CommandLoader getInstance() {
		return instance;
	}
	
	/**
	 * The commands.
	 */
	private HashMap<String, CommandHandler> commands;
	
	/**
	 * The permissions.
	 */
	private String ownerPerm = "AdminGUI.Owner";
	private String adminPerm = "AdminGUI.Admin";
	private String seniorModPerm = "AdminGUI.SrMod";
	private String modPerm = "AdminGUI.Mod";
	private String juniorModPerm = "AdminGUI.JrMod";
	private String helperPerm = "AdminGUI.Helper";
	
	/**
	 * Instantiates a new CommandLoader
	 */
	private CommandLoader() {
	    
	}
	
	/**
	 * Instantiates a new command loader.
	 *
	 * @param plugin
	 *            the plugin
	 */
	public CommandLoader(Main plugin) {
		CommandLoader.plugin = plugin;
	}
	
	/**
	 * @return the ownerPerm
	 */
	public String getOwnerPerm() {
	    return ownerPerm;
	}
	
	/**
	 * @return the adminPerm
	 */
	public String getAdminPerm() {
		return adminPerm;
	}
	
    /**
     * @return the seniorModPerm
     */
	public String getSeniorModPerm() {
	    return seniorModPerm;
	}
	
	/**
	 * @return modPerm
	 */
	public String getModPerm() {
	    return modPerm;
	}
	
	/**
	 * @return juniorModPerm
	 */
	public String getJuniorModPerm() {
	    return juniorModPerm;
	}
	
	/**
	 * @return helperPerm
	 */
	public String getHelperPerm() {
	    return helperPerm;
	}
	
    /**
     * Get's the commands.
     * 
     * @return the commands
     */
    public HashMap<String, CommandHandler> getCommands() {
        return commands;
    }
    
    /**
     * Load the AdminGUI Command
     */
    private void loadAdminCommand() {
        plugin.setAdminCommand(new ArrayList<CommandHandler>());
        
        plugin.getAdminCommand().add(new CommandHandler(new String[] {""},
                                "AdminGUI.Open|" + ownerPerm + "|" + adminPerm + "|" + seniorModPerm + "|" + modPerm + "|" + juniorModPerm + "|" + helperPerm,
                                "Open AdminGUI") {
                                    
            @Override
            public void execute(CommandSender sender, String[] args) {
                
                // Check if the sender is actually a Player
                if(sender instanceof Player) {
                    Player player = (Player) sender;
                    
                    if(args.length == 0) {
                        AdminGUI.getInstance().viewGUI(player);
                        return;
                    } else if(args.length >= 1) {
                        AdminGUI.getInstance().openGUI(player, Bukkit.getServer().getPlayer(args[0]));
                        return;
                    }
                }
                
            }
            
        });
        
        
    }
    
    
}
