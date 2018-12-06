package net.fathomtech.plugins.AdminGUI.GUI.Submenus;

import org.bukkit.entity.Player;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.GUI;

public class PunishGUI implements GUI {
    
    /**
     * The instance.
     */
    static PunishGUI instance = new PunishGUI();
    
    /**
     * The plugin.
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get the single instance
     * 
     * @return Singular instance of PunishGUI
     */
    public static PunishGUI getInstance() {
        return instance;
    }
    
    /**
     * New Instance
     */
    private PunishGUI() {
        
    }
    
    
    
    
    @Override
    public void openGUI(Player player, Player target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewGUI(Player player) {
        // TODO Auto-generated method stub
        
    }
    
}
