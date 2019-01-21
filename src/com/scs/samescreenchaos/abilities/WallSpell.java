package com.scs.samescreenchaos.abilities;

import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.scs.multiplayervoxelworld.MultiplayerVoxelWorldMain;
import com.scs.multiplayervoxelworld.Settings;
import com.scs.multiplayervoxelworld.entities.AbstractPhysicalEntity;
import com.scs.multiplayervoxelworld.entities.AbstractPlayersAvatar;
import com.scs.multiplayervoxelworld.entities.VoxelTerrainEntity;
import com.scs.multiplayervoxelworld.modules.AbstractGameModule;
import com.scs.samescreenchaos.blocks.StoneBlock;

import mygame.util.Vector3Int;

public class WallSpell extends AbstractSpell {
	
	private static final int SIZE = 1;

	public WallSpell(MultiplayerVoxelWorldMain _game, AbstractGameModule module, AbstractPlayersAvatar p) {
		super(_game, module, p, "WallSpell", 1);
	}


	@Override
	public boolean process(float interpol) {
		return false;
	}


	@Override
	public boolean activate(float interpol) {
		Ray ray = new Ray(this.player.getCamera().getLocation(), this.player.getCamera().getDirection());

		CollisionResults results = new CollisionResults();
		module.getRootNode().collideWith(ray, results);

		CollisionResult result = results.getClosestCollision();
		if (result != null) {
			if (result.getDistance() > 1f) { // So we don't build a block on top of ourselves
				Geometry g = result.getGeometry();
				AbstractPhysicalEntity ape = (AbstractPhysicalEntity)AbstractGameModule.getEntityFromSpatial(g);
				if (ape instanceof VoxelTerrainEntity) {
					VoxelTerrainEntity vte = (VoxelTerrainEntity)ape;
					Vector3f position = result.getContactPoint();
					vte.addRectRange_Actual(new Vector3Int(position), new Vector3Int(SIZE, SIZE, SIZE), StoneBlock.class);
					return true;
				} else {
					Settings.p(ape + " selected");
				}
			}
		}
		return false;
	}


	@Override
	public boolean onlyActivateOnClick() {
		return true;
	}


	@Override
	public String getHudText() {
		return "[SummonGolemSpell]";
	}

}
