package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class GameModeGUI implements GUI {
    
    /**
     * The instance
     */
    static GameModeGUI instance = new GameModeGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the singular instance.
     * 
     * @returns Singular GameModeGUI instance
     */
    public static GameModeGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private GameModeGUI() {}
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
