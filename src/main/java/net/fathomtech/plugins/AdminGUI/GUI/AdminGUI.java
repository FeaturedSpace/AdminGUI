package net.fathomtech.plugins.AdminGUI.GUI;

import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.metadata.MetadataValue;

import com.Ben12345rocks.AdvancedCore.AdvancedCoreHook;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventory.ClickEvent;
import com.Ben12345rocks.AdvancedCore.Util.Inventory.BInventoryButton;
import com.Ben12345rocks.AdvancedCore.Util.Item.ItemBuilder;

import net.fathomtech.plugins.AdminGUI.Main;
import net.fathomtech.plugins.AdminGUI.GUI.UserGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.ChatGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.GameModeGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.PlayerGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.PunishGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.RankGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.ServerGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.StaffGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.VanishGUI;
import net.fathomtech.plugins.AdminGUI.GUI.Submenus.WorldGUI;

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

    // private ArrayList<BInventoryButton> pluginGUIs; // We don't need this because all of these are hardcoded.

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
         * Chat Button
         */
        ItemBuilder chatButton = new ItemBuilder(Material.SPONGE, 1);
        punishButton.setName("&6&lChat");
        chatButton.addLoreLine("&7Mute players and the chat.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(chatButton) {

            @Override
            public void onClick(ClickEvent event) {
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // View the inventory
                    ChatGUI.getInstance().viewGUI(player);
                    return;
                }
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
                    PlayerGUI.getInstance().viewGUI(player);
                } else {
                    UserGUI.getInstance().selectUser(player, PlayerGUI.getInstance());
                }
            }
            
        });
        
        /**
         * Staff
         */
        ItemBuilder staffButton = new ItemBuilder(Material.GOLD_BLOCK, 1);
        staffButton.setName("&e&lStaff");
        staffButton.addLoreLine("&7See online staff, toggle");
        staffButton.addLoreLine("&7StaffMode, Vanish, etc.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(staffButton) {

            @Override
            public void onClick(ClickEvent event) {
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // View the inventory
                    StaffGUI.getInstance().viewGUI(player);
                    return;
                } else {
                    // Open the UserGUI
                    UserGUI.getInstance().selectUser(player, StaffGUI.getInstance());
                }
            }
            
        });
        
        
        /**
         * World
         */
        ItemBuilder worldButton = new ItemBuilder(Material.PLAYER_HEAD, 1);
        worldButton.setSkullOwner("Dipicrylamine");
        worldButton.setName("&b&lWorld");
        worldButton.addLoreLine("&7WorldEdit tools,");
        worldButton.addLoreLine("&7CoreProtect CommandBuilder,");
        worldButton.addLoreLine("&7and Inventory Restoration.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(worldButton) {

            @Override
            public void onClick(ClickEvent event) {
                WorldGUI.getInstance().viewGUI(player);
                return;
            }
            
        });
        
        /**
         * Gamemode
         */
        ItemBuilder gamemodeButton = new ItemBuilder(Material.GLASS_PANE, 1);
        if(player.getGameMode().equals(GameMode.SURVIVAL)) {
            gamemodeButton.setDyeColor(DyeColor.RED);
            gamemodeButton.setName("&4&lGameMode");
            gamemodeButton.addLoreLine("&7Click to Toggle between");
            gamemodeButton.addLoreLine("&7&4Survival &7and &3Creative&7.");
            gamemodeButton.addLoreLine("&7Middle click for options.");
        } else {
            gamemodeButton.setDyeColor(DyeColor.BLUE);
            gamemodeButton.setName("&3&lGameMode");
            gamemodeButton.addLoreLine("&7Click to Toggle between");
            gamemodeButton.addLoreLine("&7&3Creative &7and &4Survival&7.");
            gamemodeButton.addLoreLine("&7Middle click for more options.");
        }
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(gamemodeButton) {

            @Override
            public void onClick(ClickEvent event) {
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // Open the options menu.
                    GameModeGUI.getInstance().viewGUI(player);
                    return;
                } else {
                    // Run the toggle command
                    
                    if(player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE)) {
                        player.performCommand("gmc");
                    } else {
                        player.performCommand("gms");
                    }
                }
                
                return;
            }
            
        });
        
        
        /**
         * Vanish
         */
        ItemBuilder vanishButton = new ItemBuilder(Material.GLASS_PANE);
        boolean isVanished = false;
        for (MetadataValue meta : player.getMetadata("vanished")) {
            isVanished = meta.asBoolean();
        }
        
        if (isVanished) {
            // They're vanished.
            vanishButton.setDyeColor(DyeColor.GREEN);
            vanishButton.setName("&5&lVanish");
            vanishButton.addLoreLine("&7Click to toggle vanish off,");
            vanishButton.addLoreLine("&7or middle click for more options.");
        } else {
            // Not vanished.
            vanishButton.setDyeColor(DyeColor.RED);
            vanishButton.setName("&5&lVanish");
            vanishButton.addLoreLine("&7Click to toggle vanish on,");
            vanishButton.addLoreLine("&7or middle click for more options");
        }
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(vanishButton) {

            @Override
            public void onClick(ClickEvent event) {
                if(event.getClick().equals(ClickType.MIDDLE)) {
                    // Open the inventory
                    VanishGUI.getInstance().viewGUI(player);
                    return;
                } else {
                    // Toggle Vanish
                    player.performCommand("sv -s");
                    return;
                }
            }
            
        });
        
        
        /**
         * Server
         */
        ItemBuilder serverButton = new ItemBuilder(Material.BEDROCK, 1);
        serverButton.setName("&f&lSERVER");
        serverButton.setLore("&4Restricted access only.");
        
        inv.addButton(inv.getNextSlot(), new BInventoryButton(serverButton) {

            @Override
            public void onClick(ClickEvent event) {
                ServerGUI.getInstance().viewGUI(player);
                return;
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
        
        // Open the GUI Already focused on a player.
        
    }
}
