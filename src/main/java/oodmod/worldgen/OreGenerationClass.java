package oodmod.worldgen;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import oodmod.block.BlockClass;

public class OreGenerationClass implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

	generate(world, random, chunkX*16, chunkZ*16);
	}

	private void generate(World world, Random random, int x, int z) {

		for(int i = 0; i < 2; i++) {
			int posX = x + random.nextInt(16);
			int posY = random.nextInt(20);
			int posZ = z + random.nextInt(16);

			BlockPos pos = new BlockPos(posX,posY,posZ);

			(new WorldGenMinable(BlockClass.KroostylOre.getDefaultState(), 4)).generate(world, random, pos);
		}
	}
}