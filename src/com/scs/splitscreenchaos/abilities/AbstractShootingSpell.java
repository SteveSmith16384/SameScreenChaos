package com.scs.splitscreenchaos.abilities;

import com.scs.splitscreenchaos.entities.WizardAvatar;
import com.scs.splitscreenfpsengine.MultiplayerVoxelWorldMain;
import com.scs.splitscreenfpsengine.entities.AbstractBullet;
import com.scs.splitscreenfpsengine.modules.AbstractGameModule;

public abstract class AbstractShootingSpell extends AbstractSpell {

	public AbstractShootingSpell(MultiplayerVoxelWorldMain _game, AbstractGameModule module, WizardAvatar _player, String _name, int _cost) {
		super(_game, module, _player, _name, _cost);
	}


	public boolean cast() {
		AbstractBullet b = this.getBullet();
		return true;
	}
	
	
	protected abstract AbstractBullet getBullet();
}