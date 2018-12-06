package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class ChatGUI implements GUI {
    
    /**
     * The instance
     */
    static ChatGUI instance = new ChatGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the singular instance
     * 
     * @returns Singular ChatGUI instance
     */
    public static ChatGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private ChatGUI() {}
    
    
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
