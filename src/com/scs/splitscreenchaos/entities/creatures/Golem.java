package com.scs.splitscreenchaos.entities.creatures;

import com.jme3.math.Vector3f;
import com.scs.splitscreenchaos.components.ICreatureModel;
import com.scs.splitscreenchaos.entities.WizardAvatar;
import com.scs.splitscreenchaos.models.GolemModel;
import com.scs.splitscreenfpsengine.SplitScreenFpsEngine;
import com.scs.splitscreenfpsengine.modules.AbstractGameModule;

public class Golem extends AbstractCreature {

	public Golem(SplitScreenFpsEngine _game, AbstractGameModule _module, Vector3f startPos, WizardAvatar _side) {
		super(_game, _module, "Golem", startPos, _side, 0.6f, 1, 1, 8, false);
	}

	
	@Override
	public ICreatureModel getCreatureModel() {
		return new GolemModel(game.getAssetManager());
	}


}
