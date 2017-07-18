package me.amc.mybiomes.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.amc.mybiomes.MyBiomesMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ItemBiomeFinder extends ItemBasic{

	public ItemBiomeFinder(String unlocalizedName) {
		super(unlocalizedName);
	}

	
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
    	
    	List biomesToFind = new ArrayList();
    	biomesToFind.add(MyBiomesMod.diamondWoods);
    	Random rdm = new Random();
    	
        BlockPos biomePos = worldIn.getWorldChunkManager().findBiomePosition((int)playerIn.posX, (int)playerIn.posZ, 5000, biomesToFind, rdm);
        
        System.out.println("Found Biome at: " + biomePos.getX() + " " +biomePos.getZ());
        return itemStackIn;
    }
}
