package net.fathomtech.plugins.AdminGUI.Config;

import java.io.File;

import com.Ben12345rocks.AdvancedCore.Util.Annotation.AnnotationHandler;
import com.Ben12345rocks.AdvancedCore.Util.Annotation.ConfigDataInt;
import com.Ben12345rocks.AdvancedCore.Util.Annotation.ConfigDataString;
import com.Ben12345rocks.AdvancedCore.YML.YMLFile;

import net.fathomtech.plugins.AdminGUI.Main;

public class Config extends YMLFile {
    
    /**
     * The config.
     */
    static Config instance = new Config();
    
    /**
     * The plugin
     */
    static Main plugin = Main.plugin;
    
    /**
     * Get's a single instance of the Config
     */
    public static Config getInstance() {
        return instance;
    }
    
    /**
     * ALL CONFIG VALUES
     */
    
    @ConfigDataString(
        path="Prefix",
        defaultValue="&8[&cTitan&fAdmin&8] &r"
    )
    private String prefix;
    
    @ConfigDataInt(
        path="UpdateDelay"
    )
    private int updateDelay = 3;
    
    
    /**
     * Constructor
     */
    public Config() {
        super(new File(Main.plugin.getDataFolder(), "config.yml"));
    }
    
    /**
     * Getters/Setters
     */
    public String getPrefix() {
        return prefix;
    }
    
    public int getUpdateDelay() {
        return updateDelay;
    }
    
    /**
     * Utility Methods
     */
    public void loadValues() {
        new AnnotationHandler().load(getData(), this);
    }

    @Override
    public void onFileCreation() {
        plugin.saveResource("config.yml", true);
    }
    
    
    
}
