package com.puttysoftware.dungeondiver3.game;

import java.io.IOException;

import org.retropipes.diane.fileio.XDataReader;
import org.retropipes.diane.fileio.XDataWriter;

import com.puttysoftware.dungeondiver3.support.creatures.PartyManager;

public class FileHooks {
    private FileHooks() {
        // Do nothing
    }

    public static void loadGameHook(final XDataReader mapFile)
            throws IOException {
        PartyManager.loadGameHook(mapFile);
    }

    public static void loadGameHookV1(final XDataReader mapFile)
            throws IOException {
        PartyManager.loadGameHookV1(mapFile);
    }

    public static void saveGameHook(final XDataWriter mapFile)
            throws IOException {
        PartyManager.saveGameHook(mapFile);
    }
}
