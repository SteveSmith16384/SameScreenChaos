package com.scs.samescreenchaos.blocks;

import java.io.IOException;

import com.scs.multiplayervoxelworld.entities.VoxelTerrainEntity;

import mygame.texturesheet.TextureSheetGenerator;

public class GenerateChaosTextureSheet {
	
	private static final int TILE_SIZE_PIXELS = 64;

	public static void main(String[] args) {
		try {
			new GenerateChaosTextureSheet();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public GenerateChaosTextureSheet() throws IOException {
		String[][] tiles = {
				{"grass.jpg", "lavarock.jpg", "stone.png", "scarybark.jpg", "leaves.jpg"}, 
				{"road2.png", "sand.jpg"}
		}; // Keep these in the same order!

		TextureSheetGenerator gen = new TextureSheetGenerator();
		gen.generateTextureSheet("assets/Textures/blocks", tiles, VoxelTerrainEntity.TEX_PER_SHEET, TILE_SIZE_PIXELS, "mvw_tiles", 4, true);

	}

}
