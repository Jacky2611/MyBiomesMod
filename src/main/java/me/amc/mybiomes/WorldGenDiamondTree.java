package me.amc.mybiomes;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDiamondTree extends WorldGenerator{
	
	int height;
	IBlockState wood = Blocks.diamond_block.getDefaultState();
	IBlockState leaf = Blocks.emerald_block.getDefaultState();

	public boolean generate(World world, Random random, BlockPos pos)
	{
			if(true)
				return true;
	
			//making sure that this code isn't started until you fix it.
			
			while (world.isAirBlock(pos.down()) && pos.getY() > 55)
			{
				pos.subtract(new Vec3i(0, 1, 0));
			}
			if (!world.isAirBlock(pos))
				return false;

			height = 2 + random.nextInt(5);

			for (int i = 0; i < height; i++)
			{
				world.setBlockState(pos.up(i), wood);
			}

			int top = 1 + random.nextInt(3);

			int left = 2 + random.nextInt(3);
			int right = 2 + random.nextInt(3);
			int front = 2 + random.nextInt(3);
			int back = 2 + random.nextInt(3);

			for (int i = 0; i < top; i++)
			{
				setBlock(world, pos.getX(), pos.getY() + i, pos.getZ(), wood);

				if (i > 0)
				{
					setBlock(world, pos.getX() + 1, pos.getY() + i, pos.getZ(), leaf);
					setBlock(world, pos.getX() - 1, pos.getY() + i, pos.getZ(), leaf);
					setBlock(world, pos.getX(), pos.getY() + i, pos.getZ() + 1, leaf);
					setBlock(world, pos.getX(), pos.getY() + i, pos.getZ() - 1, leaf);
					setBlock(world, pos.getX(), pos.getY() + i + 1, pos.getZ(), leaf);
				}
			}

			for (int i = 0; i < left; i++)
			{
				setBlock(world, pos.getX() + i, pos.getY(), pos.getZ(), wood);
				setBlock(world, pos.getX() + i, pos.getY() + 1, pos.getZ(), leaf);
				if (i > 0)
				{
					setBlock(world, pos.getX() + i, pos.getY(), pos.getZ() + 1, leaf);
					setBlock(world, pos.getX() + i, pos.getY(), pos.getZ() - 1, leaf);
				}
			}
			for (int i = 0; i < right; i++)
			{
				setBlock(world, pos.getX() - i, pos.getY(), pos.getZ(), wood);
				setBlock(world, pos.getX() - i, pos.getY() + 1, pos.getZ(), leaf);
				if (i > 0)
				{
					setBlock(world, pos.getX() - i, pos.getY(), pos.getZ() + 1, leaf);
					setBlock(world, pos.getX() - i, pos.getY(), pos.getZ() - 1, leaf);
				}
			}
			for (int i = 0; i < front; i++)
			{
				setBlock(world, pos.getX(), pos.getY(), pos.getZ() + i, wood);
				setBlock(world, pos.getX(), pos.getY() + 1, pos.getZ() + i, leaf);
				if (i > 0)
				{
					setBlock(world, pos.getX() - 1, pos.getY(), pos.getZ() + i, leaf);
					setBlock(world, pos.getX() + 1, pos.getY(), pos.getZ() + i, leaf);
				}
			}
			for (int i = 0; i < back; i++)
			{
				setBlock(world, pos.getX(), pos.getY(), pos.getZ() - i, wood);
				setBlock(world, pos.getX(), pos.getY() + 1, pos.getZ() - i, leaf);
				if (i > 0)
				{
					setBlock(world, pos.getX() - 1, pos.getY(), pos.getZ() - i, leaf);
					setBlock(world, pos.getX() + 1, pos.getY(), pos.getZ() - i, leaf);
				}
			}

			setBlock(world, pos.getX() + left, pos.getY(), pos.getZ(), leaf);
			setBlock(world, pos.getX() - right, pos.getY(), pos.getZ(), leaf);
			setBlock(world, pos.getX(), pos.getY(), pos.getZ() + front, leaf);
			setBlock(world, pos.getX(), pos.getY(), pos.getZ() - back, leaf);

			return true;
			
			
	
	}

	public void setBlock(World world, int x, int y, int z, IBlockState block)
	{
		world.setBlockState(new BlockPos(x, y + height, z), block);
	}
}
