/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.map;

import java.io.IOException;

import org.retropipes.diane.fileio.XDataReader;
import org.retropipes.diane.fileio.XDataWriter;

public interface PrefixIO {
    void writePrefix(XDataWriter writer) throws IOException;

    int readPrefix(XDataReader reader) throws IOException;
}
