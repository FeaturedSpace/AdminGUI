package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class ServerGUI implements GUI {
    
    /**
     * The instance
     */
    static ServerGUI instance = new ServerGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Singular Instance Retrieval
     * 
     * @returns Singular ServerGUI instance
     */
    public static ServerGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private ServerGUI() {}
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        
    }
}
