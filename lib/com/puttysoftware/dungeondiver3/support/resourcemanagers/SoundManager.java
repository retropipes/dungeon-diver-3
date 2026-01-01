/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.resourcemanagers;

import org.retropipes.diane.asset.sound.DianeSoundPlayer;
import org.retropipes.diane.random.RandomRange;

import com.puttysoftware.dungeondiver3.support.prefs.LocalPreferencesManager;

public class SoundManager {
    private static final String INTERNAL_LOAD_PATH = "/com/puttysoftware/dungeondiver3/support/resources/sounds/";
    private final static Class<?> LOAD_CLASS = SoundManager.class;

    public static void playSound(final int soundID) {
	if (LocalPreferencesManager.getSoundsEnabled()) {
	    try {
		int offset;
		RandomRange rr;
		switch (soundID) {
		case GameSoundConstants.SOUND_STEP:
		    rr = new RandomRange(0, 1);
		    offset = rr.generate();
		    break;
		default:
		    offset = 0;
		    break;
		}
		final String soundName = SoundNames.getSoundNames()[soundID + offset];
		DianeSoundPlayer.playSource(SoundManager.LOAD_CLASS
			.getResource(SoundManager.INTERNAL_LOAD_PATH + soundName.toLowerCase() + ".wav"));
	    } catch (final ArrayIndexOutOfBoundsException aioob) {
		// Do nothing
	    }
	}
    }
}