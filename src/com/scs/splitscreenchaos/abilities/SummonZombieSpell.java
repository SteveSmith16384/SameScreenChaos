package com.scs.splitscreenchaos.abilities;

import com.jme3.math.Vector3f;
import com.scs.splitscreenchaos.ChaosGameModule;
import com.scs.splitscreenchaos.entities.WizardAvatar;
import com.scs.splitscreenchaos.entities.creatures.AbstractCreature;
import com.scs.splitscreenchaos.entities.creatures.Zombie;
import com.scs.splitscreenfpsengine.SplitScreenFpsEngine;
import com.scs.splitscreenfpsengine.modules.AbstractGameModule;

public class SummonZombieSpell extends AbstractSummonSpell {

	public SummonZombieSpell(SplitScreenFpsEngine _game, AbstractGameModule module, WizardAvatar p) {
		super(_game, module, p, "Summon Zombie", 30);
	}

	@Override
	protected AbstractCreature createCreature(Vector3f pos) {
		Zombie golem = new Zombie(game, (ChaosGameModule)module, pos, (WizardAvatar)this.avatar);
		game.soundSystem.playSound("Sound/Zombie Sound.wav", 1, false);
		return golem;
	}

}
