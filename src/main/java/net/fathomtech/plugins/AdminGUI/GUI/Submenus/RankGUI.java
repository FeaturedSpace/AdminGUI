package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class RankGUI implements GUI {
    
    /**
     * The instance
     */
    static RankGUI instance = new RankGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the singular instance of RankGUI
     * 
     * @returns A singular instance of RankGUI
     */
    public static RankGUI getInstance() {
        return instance;
    }
    
    /**
     * Initialize a singular instance of RankGUI
     */
    private RankGUI() {
        
    }
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        
    }
}
