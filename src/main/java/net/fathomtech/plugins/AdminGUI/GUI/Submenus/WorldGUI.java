package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class WorldGUI implements GUI {
    
    /**
     * The instance
     */
    static WorldGUI instance = new WorldGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the singular instance
     * 
     * @returns Singular WorldGUI instance.
     */
    public static WorldGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private WorldGUI() {}
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
