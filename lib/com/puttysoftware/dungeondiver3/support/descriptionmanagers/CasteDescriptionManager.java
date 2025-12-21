/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.descriptionmanagers;

import org.retropipes.diane.fileio.utility.ResourceStreamReader;

import com.puttysoftware.dungeondiver3.support.creatures.castes.CasteConstants;
import com.puttysoftware.dungeondiver3.support.scenario.Extension;

public class CasteDescriptionManager {
    public static String getCasteDescription(final int c) {
	final String name = CasteConstants.CASTE_NAMES[c].toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(CasteDescriptionManager.class
		.getResourceAsStream("/com/puttysoftware/dungeondiver3/support/resources/descriptions/caste/" + name
			+ Extension.getDescriptionExtensionWithPeriod()));) {
	    final String desc = rsr.readString();
	    return desc;
	} catch (final Exception e) {
	    return null;
	}
    }
}
