package net.fathomtech.plugins.AdminGUI;

import java.util.ArrayList;
import java.util.TimerTask;

import net.fathomtech.plugins.AdminGUI.Commands.CommandLoader;
import net.fathomtech.plugins.AdminGUI.Config.Config;
import net.fathomtech.plugins.AdminGUI.GUI.AdminGUI;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Ben12345rocks.AdvancedCore.AdvancedCoreHook;
import com.Ben12345rocks.AdvancedCore.CommandAPI.CommandHandler;

public class Main extends JavaPlugin {
    
    /** Config */
    public static Config config;
    
    /** Plugin */
    public static Main plugin;
    
    private boolean update;
    
    public boolean getUpdate() {
        return update;
    }
    
    public void setUpdate(boolean newUpdate) {
        update = newUpdate;
    }
    
    private boolean updateStarted;
    
    public boolean getUpdateStarted() {
        return updateStarted;
    }
    
    private ArrayList<CommandHandler> adminCommand;
    
    public ArrayList<CommandHandler> getAdminCommand() {
        return adminCommand;
    }
    
    public void setAdminCommand(ArrayList<CommandHandler> newAdminCommand) {
        adminCommand = newAdminCommand;
    }
    
    /**
	 * Debug.
	 *
	 * @param message
	 *            the message
	 */
	public void debug(String message) {
		AdvancedCoreHook.getInstance().debug(plugin, message);
	}
	
	private void loadTimer() {
		Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				AdvancedCoreHook.getInstance().getTimer().schedule(new TimerTask() {

					@Override
					public void run() {
						update();
					}
				}, 1000, 1000 * 60 * Config.getInstance().getUpdateDelay());
			}
		}, 40L);

	}
	
	
	/**
	 * Register commands.
	 */
	private void registerCommands() {
	    CommandLoader.getInstance().loadCommands();
	    CommandLoader.getInstance().loadAliases();
	    
	    getCommand("admin").setExecutor(new CommandAdmin(this));
	    getCommand("admin").setTabCompleter(new AdminTabCompleter());
	    getCommand("admingui").setExecutor(new CommandAdmin(this));
	    getCommand("admingui").setTabCompleter(new AdminTabCompleter());
	    
	    plugin.debug("Loaded commands.");
	    
	}
	
	/**
	 * Register Events
	 */
	private void registerEvents() {
	    PluginManager pm = getServer().getPluginManager();
	    
	    pm.registerEvents(new PlayerInteract(this), this);
	    
	    plugin.debug("Loaded events.");
	}
    
    /* ENABLE/DISABLE/RELOAD */
    @Override
    public void onEnable() {
        plugin = this;
        
        setupFiles();
        updateAdvancedCoreHook();
        AdvancedCoreHook.getInstance().loadHook(this);
        registerCommands();
        registerEvents();
        
        // Load our GUI!
        AdminGUI.getInstance().loadHook();
        
        // Update every so often :D
        loadTimer();
        
        plugin.getLogger().info("Enabled AdminGUI " + plugin.getDescription().getVersion());
    }
    
    @Override
    public void onDisable() {
        HandlerList.unregisterAll(plugin);
        plugin = null;
    }
    
    public void reload() {
        config.reloadData();
        config.loadValues();
        
    }
    
    private void setupFiles() {
        
        try {
            config = Config.getInstance();
            config.setup();
            config.loadValues();
        } catch(Exception e) {
            e.printStackTrace();
			Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {
                
				@Override
				public void run() {
					plugin.getLogger().severe("Failed to load Config.yml");
					e.printStackTrace();
				}
			}, 10);
        }
        
        plugin.debug("Config.yml loaded!");
        
    }
    
    public void updateAdvancedCoreHook() {
        AdvancedCoreHook.getInstance().getJavascriptEngine().put("AdminGUI", this);
        AdvancedCoreHook.getInstance().setConfigData(Config.getInstance().getData());
    }
    
    public void update() {
        
    }
    
}
