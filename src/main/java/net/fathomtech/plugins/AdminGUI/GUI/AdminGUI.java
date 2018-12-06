package net.fathomtech.plugins.AdminGUI.GUI;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import com.Ben12345rocks.AdvancedCore.AdvancedCoreHook;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory.ClickEvent;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventoryButton;
import com.Ben12345rocks.AdvancedCore.Util.Item.ItemBuilder;
import com.Ben12345rocks.AdvancedCore.Util.ValueRequest.ValueRequest;
import com.Ben12345rocks.AdvancedCore.Util.ValueRequest.Listeners.StringListener;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.UserGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.PunishGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.RankGUI;

public class AdminGUI implements GUI {

    /**
     * The instance.
     */
    static AdminGUI instance = new AdminGUI();
    
    /**
     * The plugin.
     */
    static Main     plugin   = Main.plugin;
    
    /**
     * Gets the single instance of AdminGUI.
     *
     * @return single instance of AdminGUI
     */
    public static AdminGUI getInstance() {
        return instance;
    }

    private ArrayList<BInventoryButton> pluginGUIs;

    private AdminGUI() {

    }

    /**
     * View GUI.
     *
     * @param player
     *            the player
     */
    public void viewGUI(Player player) {
        if (!player.hasPermission(AdvancedCoreHook.getInstance().getOptions().getPermPrefix() + ".Open")) {
            player.sendMessage("Not enough permissions");
            return;
        }

        BInventory inv = new BInventory("&4&lAdmin Menu");
        
        
        /**
         * Items
         */
        
        /**
         * Punish Button
         */
        ItemBuilder punishButton = new ItemBuilder(Material.LAVA_BUCKET, 1);
        punishButton.setName("&c&lPunishments");
        punishButton.addLoreLine("&7Kicks, Mutes, Tempbans, Bans, etc.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(punishButton) {

            @Override
            public void onClick(ClickEvent event) {
                // Open the User Selection Menu, if it's not a middle click
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // Open the Inventory without specifying a player.
                    PunishGUI.getInstance().viewGUI(player);
                } else {
                    // Select a User, then route to the PunishGUI
                    UserGUI.getInstance().selectUser(player, PunishGUI.getInstance());
                }
                
                return;
            }
            
        });
        
        
        /**
         * Ranks Button
         */
        ItemBuilder ranksButton = new ItemBuilder(Material.EMERALD, 1);
        ranksButton.setName("&2&lRanks");
        ranksButton.addLoreLine("&7Set a rank,");
        ranksButton.addLoreLine("&7Give a temporary rank,");
        ranksButton.addLoreLine("&7Remove a rank.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(ranksButton) {
            
            @Override
            public void onClick(ClickEvent event) {
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // View the inventory without selecting a player
                    RankGUI.getInstance().viewGUI(player);
                } else {
                    // Open the GUI and select a player
                    UserGUI.getInstance().selectUser(player, RankGUI.getInstance());
                }
                
                return;
            }
            
        });
        
        
        /**
         * Player
         */
        ItemBuilder playerButton = new ItemBuilder(Material.PLAYER_HEAD, 1);
        playerButton.setName("&6&lPlayers");
        playerButton.addLoreLine("&7Access player data/permissions.");
        playerButton.addLoreLine("&7Alter player stats.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(playerButton) {

            @Override
            public void onClick(ClickEvent event) {
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // View the Player GUI
                    PlayerGUI.viewGUI(player);
                } else {
                    UserGUI.selectUser(player, PlayerGUI.getInstance());
                }
            }
            
        });
        
        
        // Open the inventory
        inv.openInventory(player);
    }
    
    /**
     * Open the GUI with a target Player
     * 
     * @param player The player to open the inventory to.
     * @param target The player to focus any GUI actions on.
     */
    public void openGUI(Player player, Player target) {
        
        // Ope
        
    }


}
