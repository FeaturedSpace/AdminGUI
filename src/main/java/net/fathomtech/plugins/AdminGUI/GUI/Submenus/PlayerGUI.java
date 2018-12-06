package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class PlayerGUI implements GUI {
    
    /**
     * The instance
     */
    static PlayerGUI instance = new PlayerGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the singular instance
     * 
     * @return Singular PlayerGUI instance
     */
    public static PlayerGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private PlayerGUI() {}
    
    
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
