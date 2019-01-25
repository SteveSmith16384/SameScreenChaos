package com.scs.splitscreenchaos.abilities;

import com.scs.splitscreenchaos.entities.WizardAvatar;
import com.scs.splitscreenchaos.entities.nonphysical.TurmoilEffect;
import com.scs.splitscreenfpsengine.MultiplayerVoxelWorldMain;
import com.scs.splitscreenfpsengine.modules.AbstractGameModule;

public class TurmoilSpell extends AbstractSpell {

	public TurmoilSpell(MultiplayerVoxelWorldMain _game, AbstractGameModule module, WizardAvatar _player) {
		super(_game, module, _player, "Turmoil", 1);
	}

	public boolean cast() {
		new TurmoilEffect(game, module);
		return true;
	}
}