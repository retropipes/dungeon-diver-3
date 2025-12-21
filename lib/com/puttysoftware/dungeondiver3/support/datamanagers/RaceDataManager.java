/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.datamanagers;

import org.retropipes.diane.fileio.utility.ResourceStreamReader;

import com.puttysoftware.dungeondiver3.support.creatures.races.RaceConstants;
import com.puttysoftware.dungeondiver3.support.scenario.Extension;

public class RaceDataManager {
    public static int[] getRaceData(final int r) {
	final String name = RaceConstants.getRaceName(r).toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(RaceDataManager.class
		.getResourceAsStream("/com/puttysoftware/dungeondiver3/support/resources/data/race/" + name
			+ Extension.getRaceExtensionWithPeriod()))) {
	    // Fetch data
	    final int[] rawData = new int[RaceConstants.RACE_ATTRIBUTE_COUNT];
	    for (int x = 0; x < rawData.length; x++) {
		rawData[x] = rsr.readInt();
	    }
	    return rawData;
	} catch (final Exception e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
