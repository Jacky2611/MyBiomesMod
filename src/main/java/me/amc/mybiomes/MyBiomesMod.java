package me.amc.mybiomes;

import me.amc.mybiomes.item.ItemBiomeFinder;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MyBiomesMod.MODID, version = MyBiomesMod.VERSION)
public class MyBiomesMod {
	
    public static final String MODID = "mybiomes";
    public static final String VERSION = "1.0";
    
    public static BiomeGenBase diamondWoods = new BiomeGenWoods(52).setBiomeName("DiamondWoods");
    
    
    
    
    //Items
    public static Item itemBiomeFinder;
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    	
    	//Items
    	//GameRegistry.registerItem(itemExample1 = new ItemBasic("example1"), "example1");
    	//GameRegistry.registerItem(itemExample2 = new ItemBasic("example2"), "example2");
    	GameRegistry.registerItem(itemBiomeFinder = new ItemBiomeFinder("biomeFinder"), "biomeFinder");

    	

    	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(diamondWoods, 1));
    	BiomeManager.addSpawnBiome(diamondWoods);

    }
    
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		

    	
    }
}
