package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class StaffGUI implements GUI {
    
    /**
     * The instance
     */
    static StaffGUI instance = new StaffGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the singular instance
     * 
     * @returns Singular StaffGUI instance.
     */
    public static StaffGUI getInstance() {
        return instance;
    }
    
    /**
     * Private constructor
     */
    private StaffGUI() {}
    
    
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
