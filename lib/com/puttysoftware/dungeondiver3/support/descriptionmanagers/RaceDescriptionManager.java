/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.descriptionmanagers;

import org.retropipes.diane.fileio.utility.ResourceStreamReader;

import com.puttysoftware.dungeondiver3.support.creatures.races.RaceConstants;
import com.puttysoftware.dungeondiver3.support.scenario.Extension;

public class RaceDescriptionManager {
    public static String getRaceDescription(final int r) {
	final String name = RaceConstants.getRaceName(r).toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(RaceDescriptionManager.class
		.getResourceAsStream("/com/puttysoftware/dungeondiver3/support/resources/descriptions/race/" + name
			+ Extension.getDescriptionExtensionWithPeriod()))) {
	    // Fetch description
	    final String desc = rsr.readString();
	    return desc;
	} catch (final Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
