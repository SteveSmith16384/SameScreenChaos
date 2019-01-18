package com.scs.samescreenchaos.abilities;

import java.util.ArrayList;

import com.scs.multiplayervoxelworld.MultiplayerVoxelWorldMain;
import com.scs.multiplayervoxelworld.abilities.AbstractAbility;
import com.scs.multiplayervoxelworld.abilities.AddBlockAbility;
import com.scs.multiplayervoxelworld.abilities.IAbility;
import com.scs.multiplayervoxelworld.abilities.PlaceTurretAbility;
import com.scs.multiplayervoxelworld.abilities.RemoveBlockAbility;
import com.scs.multiplayervoxelworld.entities.PlayersAvatar;
import com.scs.multiplayervoxelworld.modules.GameModule;

public class CycleThroughAbilitiesAbility extends AbstractAbility {
	
	private ArrayList<IAbility> abilities = new ArrayList();
	private int index;

	public CycleThroughAbilitiesAbility(MultiplayerVoxelWorldMain _game, GameModule module, PlayersAvatar p) {
		super(_game, module, p);
		
		abilities.add(new AddBlockAbility(game, module, p));
		abilities.add(new RemoveBlockAbility(game, module, p));
		abilities.add(new PlaceTurretAbility(game, module, p));
	}


	@Override
	public boolean process(float interpol) {
		return false;
	}


	@Override
	public boolean activate(float interpol) {
		index++;
		if (index >= this.abilities.size()) {
			index = 0;
		}
		this.player.ability[0] = this.abilities.get(index);
		return true;
	}
	

	@Override
	public boolean onlyActivateOnClick() {
		return true;
	}

	
	@Override
	public String getHudText() {
		return "[CycleThru]";
	}

}
