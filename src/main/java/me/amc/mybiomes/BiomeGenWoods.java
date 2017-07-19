package me.amc.mybiomes;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenWoods extends BiomeGenBase {

	public BiomeGenWoods(int par1)
	{
		super(par1);
		this.spawnableCreatureList.clear();
		this.topBlock = Blocks.diamond_block.getDefaultState();
		this.fillerBlock = Blocks.dirt.getDefaultState();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setHeight(height_LowPlains);
		
		
		
	}


	@Override
	public void decorate(World par1World, Random par2Random, BlockPos pos)
	{
		super.decorate(par1World, par2Random, pos);

		for(int i = 0; i < par2Random.nextInt(2)+1; i++) {
			int x = par2Random.nextInt(16) - 8;
			int z = par2Random.nextInt(16) - 8;
			int y = par2Random.nextInt(par1World.getHorizon(pos.add(x, 0, z)).getY() + 32);
			
			WorldGenDiamondTree worldGenDiamondTree = new WorldGenDiamondTree();
			worldGenDiamondTree.generate(par1World, par2Random, pos.add(x,y,z));
			System.out.println("=========> Position: "+pos.getX()+", "+pos.getY()+", "+pos.getZ());

		}
	}

	
	
}
