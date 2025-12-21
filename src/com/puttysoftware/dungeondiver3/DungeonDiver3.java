/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3;

import org.retropipes.diane.Diane;
import org.retropipes.diane.gui.dialog.CommonDialogs;
import org.retropipes.diane.integration.Integration;

import com.puttysoftware.dungeondiver3.prefs.PreferencesLauncher;
import com.puttysoftware.dungeondiver3.prefs.PreferencesManager;
import com.puttysoftware.dungeondiver3.resourcemanagers.LogoManager;
import com.puttysoftware.dungeondiver3.support.Support;
import com.puttysoftware.dungeondiver3.support.creatures.PartyManager;

public class DungeonDiver3 {
    // Constants
    private static Application application;
    private static final String PROGRAM_NAME = "DungeonDiver3";
    private static final String ERROR_MESSAGE = "Something has gone horribly wrong. Please report this as a bug.";
    public static final int GENERATOR_RANDOMNESS_MAX = 6;

    // Methods
    public static Application getApplication() {
        return DungeonDiver3.application;
    }
    
    public static void logError(final Throwable t) {
	CommonDialogs.showErrorDialog(DungeonDiver3.ERROR_MESSAGE);
	Diane.handleError(t);
    }
    
    public static void logWarning(final Throwable t) {
	Diane.handleWarning(t);
    }

    public static String getProgramName() {
        return DungeonDiver3.PROGRAM_NAME;
    }

    public static void newScenario() {
        if (Support.getScenario() != null) {
            // Check character writeback
            if (PreferencesManager.areCharacterChangesPermanent()) {
                PartyManager.writebackCharacters();
            }
            Support.deleteScenario();
            DungeonDiver3.application.getScenarioManager().setMap(null);
        }
        Support.createScenario();
        PartyManager.revivePartyFully();
    }

    public static void main(final String[] args) {
        try {
            String suffix;
            if (Support.inDebugMode()) {
                suffix = " (DEBUG)";
            } else {
                suffix = "";
            }
            // Integrate with host platform
            var i = Integration.integrate();
            // Set defaults
            CommonDialogs.setDefaultTitle(DungeonDiver3.PROGRAM_NAME + suffix);
            CommonDialogs.setIcon(LogoManager.getMicroLogo());
            // Initialization
            Support.preInit();
            DungeonDiver3.application = new Application();
            DungeonDiver3.application.postConstruct();
            Application.playLogoSound();
            DungeonDiver3.application.getGUIManager().showGUI();
            // Register platform hooks
            i.setAboutHandler(DungeonDiver3.application.getAboutDialog());
            i.setOpenFileHandler(DungeonDiver3.application.getScenarioManager());
            i.setPreferencesHandler(new PreferencesLauncher());
            i.setQuitHandler(DungeonDiver3.application.getGUIManager());
        } catch (final Throwable t) {
            DungeonDiver3.logError(t);
        }
    }
}
