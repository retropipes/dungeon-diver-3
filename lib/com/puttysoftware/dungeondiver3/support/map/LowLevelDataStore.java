/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.map;

import org.retropipes.diane.storage.ObjectStorage;

import com.puttysoftware.dungeondiver3.support.map.generic.MapObject;

class LowLevelDataStore extends ObjectStorage<MapObject> {
    // Constructor
    LowLevelDataStore(final int... shape) {
	super(shape);
    }

    // Copy constructor
    LowLevelDataStore(final LowLevelDataStore copyFrom) {
	super(copyFrom);
    }

    // Methods
    public MapObject getMapCell(final int... loc) {
	return this.getCell(loc);
    }

    public void setMapCell(final MapObject obj, final int... loc) {
	this.setCell(obj, loc);
    }
}
