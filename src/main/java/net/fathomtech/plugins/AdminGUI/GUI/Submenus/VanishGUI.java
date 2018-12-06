package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class VanishGUI implements GUI {
    
    /**
     * The instance
     */
    static VanishGUI instance = new VanishGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get a singular instance
     * 
     * @returns Singular VanishGUI instance.
     */
    public static VanishGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private VanishGUI() {}
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
