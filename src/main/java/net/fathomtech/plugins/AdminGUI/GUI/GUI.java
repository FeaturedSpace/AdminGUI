package net.fathomtech.plugins.AdminGUI.GUI;

import org.bukkit.entity.Player;

public interface GUI {
    
    public void openGUI(Player player, Player target);
    
    public void viewGUI(Player player);
}
