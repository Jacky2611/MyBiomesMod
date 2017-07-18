package me.amc.mybiomes.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBasic extends Item{
	
	public ItemBasic(String unlocalizedName) {
	    this(unlocalizedName, CreativeTabs.tabRedstone);
	}
	
	public ItemBasic(String unlocalizedName, CreativeTabs tab) {
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
