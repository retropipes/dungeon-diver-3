/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.map;

import org.retropipes.diane.storage.ObjectStorage;

class LowLevelNoteDataStore extends ObjectStorage<MapNote> {
    // Constructor
    LowLevelNoteDataStore(final int... shape) {
        super(shape);
    }
    
    // Copy constructor
    LowLevelNoteDataStore(final LowLevelNoteDataStore copyFrom) {
	super(copyFrom);
    }

    // Methods
    public MapNote getNote(final int... loc) {
        return this.getCell(loc);
    }

    public void setNote(final MapNote obj, final int... loc) {
        this.setCell(obj, loc);
    }
}
