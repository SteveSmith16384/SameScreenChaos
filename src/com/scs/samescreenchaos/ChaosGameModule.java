package com.scs.samescreenchaos;

import java.awt.Point;

import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.scs.multiplayervoxelworld.MultiplayerVoxelWorldMain;
import com.scs.multiplayervoxelworld.blocks.GrassBlock;
import com.scs.multiplayervoxelworld.blocks.LeavesBlock;
import com.scs.multiplayervoxelworld.blocks.StoneBlock;
import com.scs.multiplayervoxelworld.blocks.WoodBlock;
import com.scs.multiplayervoxelworld.entities.AbstractPlayersAvatar;
import com.scs.multiplayervoxelworld.entities.VoxelTerrainEntity;
import com.scs.multiplayervoxelworld.input.IInputDevice;
import com.scs.multiplayervoxelworld.modules.AbstractGameModule;
import com.scs.samescreenchaos.entities.WizardsPlayersAvatars;

import mygame.util.Vector3Int;
import ssmith.lang.NumberFunctions;

public class ChaosGameModule extends AbstractGameModule {

	private static final int MAP_SIZE = 100;

	private enum Phase {Waiting, Attack};

	private Vector3f CRYSTAL_POS = new Vector3f(MAP_SIZE/2, 2, MAP_SIZE/2);

	private long nextPhaseInterval;
	
	public ChaosGameModule(MultiplayerVoxelWorldMain _game) {
		super(_game);
	}

	
	@Override
	public void setupLevel() {
		VoxelTerrainEntity vte = new VoxelTerrainEntity(game, this, 0, 0, 0, new Vector3Int(200, 20, 200), 16, 1, 1);
		this.addEntity(vte);

		vte.addRectRange_Blocks(new Vector3Int(0, 0, 0), new Vector3Int(100, 1, 100), GrassBlock.class);
		//vte.addRectRange_Blocks(BlockCodes.SAND, new Vector3Int(10, 1, 10), new Vector3Int(1, 1, 1));
		for (int i=0 ; i<20 ; i++) {
			Point p = this.getRandomBlockPos();
			vte.addRectRange_Blocks(new Vector3Int(p.x, 1, p.y), new Vector3Int(2, 1, 2), StoneBlock.class);
		}
		for (int i=0 ; i<10 ; i++) {
			Point p = this.getRandomBlockPos();
			this.createTree(vte, new Vector3f(p.x, 1, p.y));
		}

	}


	@Override
	public Vector3f getPlayerStartPos(int id) {
		return new Vector3f(MAP_SIZE/2-3, 2, MAP_SIZE/2-3);
	}


	private Point getRandomBlockPos() {
		int x = NumberFunctions.rnd(1, MAP_SIZE-2);
		int z = NumberFunctions.rnd(1, MAP_SIZE-2);
		return new Point(x, z) ;
	}


	private void createTree(VoxelTerrainEntity vte, Vector3f pos) {
		int height = NumberFunctions.rnd(4,  7);
		int leavesStartHeight = NumberFunctions.rnd(3,  height);
		int maxRad = NumberFunctions.rnd(1,  4);

		// Trunk
		for (int y=0 ; y<height ; y++) {
			vte.blocks.setBlock(new Vector3Int(pos.x, pos.y+y, pos.z), WoodBlock.class);
		}

		for (int y=leavesStartHeight ; y<height ; y++) {
			for (int x=(int)pos.x-maxRad ; x<=pos.x+maxRad ; x++) {
				for (int z=(int)pos.z-maxRad ; z<=pos.z+maxRad ; z++) {
					if (NumberFunctions.rnd(1, 3) == 1) {
						vte.blocks.setBlock(new Vector3Int(x, pos.y+y,z), LeavesBlock.class);
					}
				}
			}
		}
	}


	@Override
	protected AbstractPlayersAvatar getPlayersAvatar(MultiplayerVoxelWorldMain _game, AbstractGameModule _module, int _playerID,
			Camera _cam, IInputDevice _input, int _side) {
		return new WizardsPlayersAvatars(_game, this, _playerID, _cam, _input, _side);
	}

}
