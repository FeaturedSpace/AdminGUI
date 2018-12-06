package net.fathomtech.plugins.AdminGUI.GUI;

import net.fathomtech.plugins.AdminGUI.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory.ClickEvent;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventoryButton;
import com.Ben12345rocks.AdvancedCore.Util.Item.ItemBuilder;

public class UserGUI implements GUI {
    
    /**
     * The instance
     */
    static UserGUI instance = new UserGUI();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Returns the singular instance of this class.
     */
    public static UserGUI getInstance() {
        return instance;
    }
    
    private UserGUI() {
        
    }
    
    
    /**
     * Open the GUI (With target player)
     */
    @Override
    public void openGUI(Player player, Player target) {
        
    }
    
    /**
     * View the GUIs contents without selecting a target
     */
    @Override
    public void viewGUI(Player player) {
        
    }
    
    public void selectUser(Player player, GUI toGUI) {
        // First, open the selection GUI.
        Player target;
        
        BInventory inv = new BInventory("&6&lUser Selection");
        
        ItemBuilder headSelect = new ItemBuilder(Material.PLAYER_HEAD, 1);
        headSelect.setName("&3&lSelect by List");
        headSelect.addLoreLine("&7View a GUI of online");
        headSelect.addLoreLine("&7player's heads for selection.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(headSelect) {

            @Override
            public void onClick(ClickEvent event) {
                // We want to open the PlayerList inventory here.
                userList(player, toGUI).openInventory(player);    
                return;
            }
            
        });
        
        ItemBuilder valueSelect = new ItemBuilder(Material.BOOK, 1);
        valueSelect.setName("&6Select by Name");
        valueSelect.addLoreLine("&7Select a player by inputting");
        valueSelect.addLoreLine("&7their name.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(valueSelect) {

            @Override
            public void onClick(ClickEvent event) {
                
                
                
            }
            
        });
        
        // Then, after they've made their selection, route them to the proper GUI.
        // toGUI.openGUI(player, target);
    }
    
    public BInventory userList(Player staff, GUI toGUI) {
        BInventory inv = new BInventory("&6&lUser List");
        
        // NOTE/TODO: Permissions for staff ranks are cumulative; you must have each of them that you need.
        
        for(Player player : Bukkit.getOnlinePlayers()) {
            /* Figure out Whether We'll show this Player or not */
            if(player.hasPermission("AdminGUI.Owner") && !(staff.hasPermission("AdminGUI.Owner")))  {
                // This player has prerogative, so we won't add them to the list.
            } else if(player.hasPermission("AdminGUI.Admin") && !(staff.hasPermission("AdminGUI.Admin"))) {
                // Prerogative; do nothing.
            } else if(player.hasPermission("AdminGUI.Mod") && !(staff.hasPermission("AdminGUI.Mod"))) {
                // Prerogative; do nothing.
            } else {
                // There are no prerogatives, so we will add this player to the list.
                
                // Add the player's skull to the next slot.
                ItemBuilder playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1);
                playerHead.setSkullOwner(player);
                
                // Formatting variables
                String color = "&f";
                String rankLorePrefix = "&7";
                String rankLore = "";
                
                // Check against normal player ranks
                if(player.hasPermission("ChatControl.Group.VIP")) {
                    color = "&2";
                    rankLore = "VIP";
                } else if(player.hasPermission("ChatControl.Group.MVP")) {
                    color = "&1";
                    rankLore = "MVP";
                } else if(player.hasPermission("ChatControl.Group.Specter")) {
                    color = "&6";
                    rankLore = "Specter";
                } else if(player.hasPermission("ChatControl.Group.Lord")) {
                    color = "&5";
                    rankLore = "Lord";
                } else if(player.hasPermission("ChatControl.Group.Titan")) {
                    color = "&4";
                    rankLore = "Titan";
                }
                
                // Check against staff ranks
                if(player.hasPermission("ChatControl.Group.Helper")) {
                    color = "&2&l";
                    rankLore = "Helper";
                } else if(player.hasPermission("ChatControl.Group.Mod")) {
                    color = "&9&l";
                    rankLore = "Mod";
                } else if(player.hasPermission("ChatControl.Group.Admin")) {
                    color = "&c&l";
                    rankLore = "Admin";
                } else if(player.hasPermission("ChatControl.Group.Owner")) {
                    color = "&4&l";
                    rankLore = "Owner";
                }
                
                
                playerHead.setName("" + color + "" + player.getName());
                playerHead.addLoreLine(rankLorePrefix + "Player is a(n) " + color + rankLore);
                
                inv.addButton(inv.getNextSlot(), new BInventoryButton(playerHead) {

                    @Override
                    public void onClick(ClickEvent event) {
                        // Select the player.
                        toGUI.openGUI(staff, player);
                        return;
                    }
                    
                });
                
            }
            
        }
        
        return inv;
    }
    
    
    public void selectPlayerByClick(Player staff, GUI toGUI) {
        // On their next click, see if they clicked a player
        
    }
    
}
