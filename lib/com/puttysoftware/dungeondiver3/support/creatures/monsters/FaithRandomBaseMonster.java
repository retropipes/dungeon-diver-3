/*  DungeonDiver3: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.dungeondiver3.support.creatures.monsters;

import org.retropipes.diane.asset.image.BufferedImageIcon;

import com.puttysoftware.dungeondiver3.support.creatures.faiths.FaithManager;

abstract class FaithRandomBaseMonster extends BaseMonster {
    // Constructors
    FaithRandomBaseMonster() {
	super();
	this.element = FaithRandomBaseMonster.getInitialElement();
    }

    @Override
    public boolean randomAppearance() {
	return false;
    }

    @Override
    public boolean randomFaith() {
	return true;
    }

    @Override
    protected BufferedImageIcon getInitialImage() {
	return null;
    }

    private static Element getInitialElement() {
	return new Element(FaithManager.getRandomFaith());
    }

    @Override
    public void loadMonster() {
	this.image = this.getInitialImage();
    }
}
